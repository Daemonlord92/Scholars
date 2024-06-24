package org.blitmatthew.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements AutoCloseable {
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/rpg_game",
                    "root",
                    "Gudmord92!"
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    @Override
    public void close() throws Exception {
        System.out.println("CLOSING CONNECTION");
        if(connection != null && !connection.isClosed()) {
            System.out.println("CLOSING GOODBYE!");
            connection.close();
        }
    }
}
