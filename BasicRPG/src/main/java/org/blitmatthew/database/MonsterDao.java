package org.blitmatthew.database;

import org.blitmatthew.general.monster.Monster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MonsterDao {
    private Connection connection;

    public MonsterDao() {
        this.connection = DatabaseConnection.getConnection();
    }

    public List<Monster> getAllMonster() {
        List<Monster> monsters = new LinkedList<>();
        String sql = "SELECT * FROM monster";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeQuery();
            try(ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    Monster monster = new Monster();
                    monster.setId(resultSet.getLong("id"));
                    monster.setName(resultSet.getString("name"));
                    monster.setHitPoints(resultSet.getInt("hit_point"));
                    monster.setStrStat(resultSet.getShort("str_stat"));
                    monster.setStrBonus(resultSet.getShort("str_bonus"));
                    monster.setDexStat(resultSet.getShort("dex_stat"));
                    monster.setDexBonus(resultSet.getShort("dex_bonus"));
                    monster.setIntStat(resultSet.getShort("int_stat"));
                    monster.setIntBonus(resultSet.getShort("int_bonus"));
                    monster.setChrStat(resultSet.getShort("chr_stat"));
                    monster.setChrBonus(resultSet.getShort("chr_bonus"));
                    monster.setDamage(resultSet.getInt("damage"));
                    monster.setLocationId(resultSet.getLong("location_id"));
                    monsters.add(monster);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return monsters;
    }
}
