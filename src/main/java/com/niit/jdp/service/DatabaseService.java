/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 23-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static final String URL = "jdbc:mysql://localhost:3306/jukebox";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Seetha@007";

    private Connection connection;

    public DatabaseService() {
        this.connection = null;
    }

    public Connection getConnection() {
        return connection;
    }

    /**
     * It connects to the database.
     *
     * @return A boolean value.
     */
    public boolean connect() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection != null;
    }

    /**
     * If the connection is not null, print "Connected to the database", otherwise print "Not connected to the database"
     */
    public void printConnectionStatus() {
        if (connection != null) {
            System.out.println("Connected to the database");
        } else {
            System.err.println("Not connected to the database");
        }
    }
}
