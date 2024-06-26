package org.blitmatthew.database;

import org.blitmatthew.general.Inventory;
import org.blitmatthew.general.player.PlayerCharacter;
import org.blitmatthew.general.player.Race;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerDao {
    private InventoryDao inventoryDao;

    public PlayerDao(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    public PlayerCharacter save(PlayerCharacter playerCharacter) {
        String sql = "INSERT INTO player_character(name, race, str_stat, str_bonus, dex_stat, " +
                "dex_bonus, int_stat, int_bonus, chr_stat, chr_bonus, inventory_id)" +
                "VALUE (?,?,?,?,?,?,?,?,?,?,?)";
        long invId = inventoryDao.save(playerCharacter.getInventory());
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            System.out.println("Beginning to save the Character");
            statement.setString(1, playerCharacter.getName());
            statement.setString(2, playerCharacter.getCharacterRace().toString());
            statement.setInt(3, playerCharacter.getStrStat());
            statement.setInt(4, playerCharacter.getStrBonus());
            statement.setInt(5, playerCharacter.getDexStat());
            statement.setInt(6, playerCharacter.getDexBonus());
            statement.setInt(7, playerCharacter.getIntStat());
            statement.setInt(8, playerCharacter.getIntBonus());
            statement.setInt(9, playerCharacter.getChrStat());
            statement.setInt(10, playerCharacter.getChrBonus());
            statement.setLong(11, invId);
            int row = statement.executeUpdate();
            if(row > 0 ) {
                System.out.println("Character Saved");
                try(ResultSet resultSet = statement.getGeneratedKeys()) {
                    while (resultSet.next()) {
                        playerCharacter.setId(resultSet.getLong(1));
                    }
                    return playerCharacter;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return playerCharacter;
    }

    public PlayerCharacter getPlayerCharacterByName(String name) {
        PlayerCharacter playerCharacter = new PlayerCharacter();
        Inventory inventory = new Inventory();
        String sql = "SELECT * FROM player_character pc WHERE pc.name = ?";
        try(PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, name);
            statement.executeQuery();
            try(ResultSet resultSet = statement.getResultSet()) {
                while(resultSet.next()) {
                    playerCharacter.setId(resultSet.getLong("id"));
                    playerCharacter.setName(resultSet.getString("name"));
                    playerCharacter.setCharacterRace(Race.valueOf(resultSet.getString("race")));
                    playerCharacter.setStrStat(resultSet.getShort("str_stat"));
                    playerCharacter.setStrBonus(resultSet.getShort("str_bonus"));
                    playerCharacter.setDexBonus(resultSet.getShort("dex_bonus"));
                    playerCharacter.setDexStat(resultSet.getShort("dex_stat"));
                    playerCharacter.setIntStat(resultSet.getShort("int_stat"));
                    playerCharacter.setIntBonus(resultSet.getShort("int_bonus"));
                    playerCharacter.setChrStat(resultSet.getShort("chr_stat"));
                    playerCharacter.setChrBonus(resultSet.getShort("chr_bonus"));
                    playerCharacter.setInventory(inventoryDao.getInventoryOfPlayerCharacter(resultSet.getLong("inventory_id")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return playerCharacter;
    }
}
