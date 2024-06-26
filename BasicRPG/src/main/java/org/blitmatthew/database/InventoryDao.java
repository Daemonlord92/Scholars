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

    public long save(Inventory inventory) {
        String sql = "INSERT INTO inventory(gold) VALUE(?)";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, inventory.getGold());
            int row = statement.executeUpdate();
            if(row > 0){
                System.out.println("Inventory Gold Saved!");
                try(ResultSet resultSet = statement.getGeneratedKeys()) {
                    while(resultSet.next()) {
                        long id = (long) resultSet.getInt(1);
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

    public void update(Inventory inventory) {
        String sql = "UPDATE inventory SET gold = ? WHERE id = ?";
        try(PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, inventory.getGold());
            statement.setLong(2, inventory.getId());
            int row = statement.executeUpdate();
            if(row>0) {
                System.out.println("Gold Updated");
                saveInventory(inventory.getInventory(), inventory.getId());
                System.out.println("Inventory Updated");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeItem(Item item, Long id) {
        Inventory inventory = getInventoryOfPlayerCharacter(id);
        inventory.getInventory().remove(item);
        updateInventory(inventory.getInventory(), id);
    }

    public Inventory getInventoryOfPlayerCharacter(Long pCId) {
        Inventory inventory = new Inventory();
        List<Item> items = new LinkedList<>();
        String sql = "SELECT * FROM inventory i LEFT JOIN inventory_item iit ON i.id = iit.inventory_id LEFT JOIN item it ON iit.item_id = it.id WHERE i.id = ?";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setLong(1, pCId);
            statement.executeQuery();
            try(ResultSet resultSet = statement.getResultSet()) {
                while(resultSet.next()) {
                    inventory.setId(resultSet.getLong("i.id"));
                    inventory.setGold(resultSet.getInt("gold"));
                    if(resultSet.getInt("damage") > 0) {
                        for (int i = 0; i < resultSet.getInt("quantity"); i++) {
                            Weapon weapon = new Weapon();
                            weapon.setId(resultSet.getLong("it.id"));
                            weapon.setName(resultSet.getString("name"));
                            weapon.setUnique(resultSet.getBoolean("is_unique"));
                            weapon.setValue(resultSet.getInt("value"));
                            weapon.setDamage(resultSet.getInt("damage"));
                            weapon.setDamageBonus(resultSet.getInt("damage_bonus"));
                            items.add(weapon);
                        }
                    } else if (resultSet.getInt("heal") > 0) {
                        for (int i = 0; i < resultSet.getInt("quantity"); i++) {
                            Potion potion = new Potion();
                            potion.setId(resultSet.getLong("it.id"));
                            potion.setName(resultSet.getString("name"));
                            potion.setUnique(resultSet.getBoolean("is_unique"));
                            potion.setValue(resultSet.getInt("value"));
                            potion.setHeal(resultSet.getInt("heal"));
                            items.add(potion);
                        }
                    } else {
                        for (int i = 0; i < resultSet.getInt("quantity"); i++) {
                            Item item = new Item();
                            item.setId(resultSet.getLong("it.id"));
                            item.setName(resultSet.getString("name"));
                            item.setUnique(resultSet.getBoolean("is_unique"));
                            item.setValue(resultSet.getInt("value"));
                            items.add(item);
                        }
                    }
                }

                inventory.setInventory(items);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return inventory;
    }

    public void addItemToInventory(Item item, Long id) {
        Inventory items = getInventoryOfPlayerCharacter(id);
        items.getInventory().add(item);
        saveInventory(items.getInventory(), id);
    }

    private void saveInventory(List<Item> items, Long id) {
        String sql = "INSERT INTO inventory_item(inventory_id, item_id, quantity) VALUE (?,?,?)";
        Map<Item, Integer> itemMap = new HashMap<>();
        for (Item item : items) {
            if(itemMap.containsKey(item) &&
                    !itemMap.keySet().stream().filter(x ->
                            x.equals(item))
                            .findFirst()
                            .orElseThrow()
                            .getUnique()){
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

    private void updateInventory(List<Item> items, Long id) {
        String sql = "UPDATE inventory_item SET quantity = ? WHERE item_id = ? AND inventory_id = ?";
        Map<Item, Integer> itemMap = new HashMap<>();
        for (Item item : items) {
            if(itemMap.containsKey(item) &&
                    !itemMap.keySet().stream().filter(x ->
                                    x.equals(item))
                            .findFirst()
                            .orElseThrow()
                            .getUnique()){
                itemMap.merge(item, 1, Integer::sum);
            } else {
                itemMap.put(item, 1);
            }
        }

        itemMap.forEach((i,v) -> {
            try(PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)){
                statement.setLong(3, id);
                statement.setLong(2, i.getId());
                statement.setLong(1, v);
                int row = statement.executeUpdate();
                if(row > 0) {
                    System.out.println("Inventory Updated");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        });
        System.out.println("Inventory Update Save Complete");
    }
}
