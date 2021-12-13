
package com.mycompany.artbalear.DataAcces;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DataAcces {
    private Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try {
            properties.load(DataAcces.class.getClassLoader().getResourceAsStream("application.properties"));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return connection;
    }
}
