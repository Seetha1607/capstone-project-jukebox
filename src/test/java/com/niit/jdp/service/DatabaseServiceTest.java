package com.niit.jdp.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

class DatabaseServiceTest {
    DatabaseService databaseService;

    @BeforeEach
    void setUp() {
        databaseService = new DatabaseService();
    }

    @AfterEach
    void tearDown() {
        databaseService = null;
    }

    @Test
    void getConnectionSuccess() throws SQLException, ClassNotFoundException {
        boolean actualOutput = databaseService.connect();
        boolean expectedOutput = databaseService.connect();
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void getConnectionFailure() throws SQLException, ClassNotFoundException {
        Connection actualOutput = databaseService.getConnection();
        boolean expectedOutput = databaseService.connect();
        Assertions.assertNotEquals(expectedOutput, actualOutput);
    }
}