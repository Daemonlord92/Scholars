package org.blitmatthew.database;

import org.blitmatthew.general.items.Item;
import org.blitmatthew.general.items.Potion;
import org.blitmatthew.general.items.Weapon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ItemDao {
    public List<Item> getAllItems() {
        List<Item> items = new LinkedList<>();
        String sql = "SELECT * from item";
        try(PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.executeQuery();
            try(ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
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
}
