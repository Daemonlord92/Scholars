package org.blitmatthew.database;

import org.blitmatthew.general.Inventory;
import org.blitmatthew.general.items.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryDao {
    private DatabaseConnection databaseConnection;

    public InventoryDao(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public int save(Inventory inventory) {
        String sql = "INSERT INTO inventory(gold) VALUE(?)";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
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
