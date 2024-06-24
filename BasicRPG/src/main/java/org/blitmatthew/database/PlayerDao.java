package org.blitmatthew.database;

import org.blitmatthew.general.player.PlayerCharacter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerDao {

    private DatabaseConnection databaseConnection;
    private InventoryDao inventoryDao;

    public PlayerDao(DatabaseConnection databaseConnection, InventoryDao inventoryDao) {
        this.databaseConnection = databaseConnection;
        this.inventoryDao = inventoryDao;
    }

    public PlayerCharacter save(PlayerCharacter playerCharacter) {
        String sql = "INSERT INTO player_character(name, race, str_stat, str_bonus, dex_stat, " +
                "dex_bonus, int_stat, int_bonus, chr_stat, chr_bonus, inventory_id)" +
                "VALUE (?,?,?,?,?,?,?,?,?,?,?)";
        int invId = inventoryDao.save(playerCharacter.getInventory());
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)){
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
            statement.setInt(11, invId);
            int row = statement.executeUpdate();
            if(row > 0 ) {
                System.out.println("Character Saved");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
