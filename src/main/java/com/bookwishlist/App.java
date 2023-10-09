package com.bookwishlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.SwingUtilities;

public class App {
    private static Connection connection = null;
    public static void main(String[] args) {
        String serverName = "bookwishlist-server.database.windows.net";
        String databaseName = "bookwishlist-data";
        String username = "brookehartley";
        String password = "Bh168058";

        String jdbcUrl = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", serverName, databaseName, username, password);

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            SwingUtilities.invokeLater(() -> {
                // Pass the database connection to your GUI application
                AppInput app = new AppInput(connection);
                app.setVisible(true);
            });
        } catch (SQLException e) {
            // Handle database connection errors
            System.err.println("Failed to establish a database connection:");
            e.printStackTrace();
        } 
    }
}

