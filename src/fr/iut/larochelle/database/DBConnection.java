package fr.iut.larochelle.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Enzo
 */
public class DBConnection {
    Connection conn = null;
    
    public DBConnection() {
    }
    
    public Connection getConnection() {
        try {
            // Load Java DB Drivers
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
            // Establish Connection
            conn = DriverManager
                    .getConnection(DBProperties.getDbUrl(),
                            DBProperties.getDbUser(),
                            DBProperties.getDbPasswd());
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void closeConnection() {
        try {
            conn.close();
            DriverManager.getConnection(DBProperties.getDbUrl() + ";"
                    + "user=" + DBProperties.getDbUser() + ";"
                    + "password=" + DBProperties.getDbPasswd() + ";"
                    + "shutdown=true");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
