package com.trms.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public static Connection getConnection() throws SQLException, IOException {

        // magic
        // DriverManager.registerDriver(new OracleDriver());

        Properties prop = new Properties();
        InputStream in = new FileInputStream("src/main/resources/connection.properties");
        prop.load(in);

        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

        return DriverManager.getConnection(url, user, password);
    }
}
