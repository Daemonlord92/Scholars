package org.blitmatthew.database;

import org.blitmatthew.general.Inventory;
import org.blitmatthew.general.items.Item;
import org.blitmatthew.general.items.Potion;
import org.blitmatthew.general.items.Weapon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InventoryDao {

    public InventoryDao() {
    }

    public int save(Inventory inventory) {
        String sql = "INSERT INTO inventory(gold) VALUE(?)";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, inventory.getGold());
            int row = statement.executeUpdate();
            if(row > 0){
                System.out.println("Inventory Gold Saved!");
                try(ResultSet resultSet = statement.getGeneratedKeys()) {
                    while(resultSet.next()) {
                        int id = (int) resultSet.getInt(1);
                        saveInventory(inventory.getInventory(), id);
                        return id;
                    }
                }
            } else {
                System.out.println("Inventory Save Failed");
                return row;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public List<Item> getInventoryOfPlayerCharacter(Long pCId) {
        List<Item> items = new LinkedList<>();
        String sql = "SELECT * FROM inventory i LEFT JOIN inventory_item iit ON i.id = iit.inventory_id LEFT JOIN item it ON iit.item_id = it.id WHERE i.id = ?";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setLong(1, pCId);
            statement.executeQuery();
            try(ResultSet resultSet = statement.getResultSet()) {
                while(resultSet.next()) {
                    if(resultSet.getInt("damage") > 0) {
                        Weapon weapon = new Weapon();
                        weapon.setId(resultSet.getLong("id"));
                        weapon.setName(resultSet.getString("name"));
                        weapon.setUnique(resultSet.getBoolean("is_unique"));
                        weapon.setValue(resultSet.getInt("value"));
                        weapon.setDamage(resultSet.getInt("damage"));
                        weapon.setDamageBonus(resultSet.getInt("damage_bonus"));
                        items.add(weapon);
                    } else if (resultSet.getInt("heal") > 0) {
                        Potion potion = new Potion();
                        potion.setId(resultSet.getLong("id"));
                        potion.setName(resultSet.getString("name"));
                        potion.setUnique(resultSet.getBoolean("is_unique"));
                        potion.setValue(resultSet.getInt("value"));
                        potion.setHeal(resultSet.getInt("heal"));
                        items.add(potion);
                    } else {
                        Item item = new Item();
                        item.setId(resultSet.getLong("id"));
                        item.setName(resultSet.getString("name"));
                        item.setUnique(resultSet.getBoolean("is_unique"));
                        item.setValue(resultSet.getInt("value"));
                        items.add(item);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    public void addItemToInventory(Item item, Long id) {

    }

    private void saveInventory(List<Item> items, int id) {
        String sql = "INSERT INTO inventory_item(inventory_id, item_id, quantity) VALUE (?,?,?)";
        Map<Item, Integer> itemMap = new HashMap<>();
        for (Item item : items) {
            if(itemMap.containsKey(item)){
                itemMap.merge(item, 1, Integer::sum);
            } else {
                itemMap.put(item, 1);
            }
        }

        itemMap.forEach((i,v) -> {
            try(PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)){
                statement.setLong(1, id);
                statement.setLong(2, i.getId());
                statement.setLong(3, v);
                int row = statement.executeUpdate();
                if(row > 0) {
                    System.out.println("Inventory Updated");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        });
        System.out.println("Inventory Initial Save Complete");
    }
}
