package org.blitmatthew.database;

import org.blitmatthew.general.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LocationDao {
    private Connection connection;

    public LocationDao() {
        this.connection = DatabaseConnection.getConnection();
    }

    public List<Location> getLocations() {
        List<Location> locations = new LinkedList<>();
        String sql = "SELECT * FROM location";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeQuery();
            try(ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()){
                    Location location = new Location(
                            resultSet.getLong("id"),
                            resultSet.getString("name")
                    );
                    locations.add(location);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return locations;
    }
}
