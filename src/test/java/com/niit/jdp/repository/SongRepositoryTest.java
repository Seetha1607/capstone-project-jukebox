package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

class SongRepositoryTest {
    SongRepository songRepository = null;
    Song song;
    DatabaseService databaseService = new DatabaseService();


    @BeforeEach
    void setUp() {
        songRepository = new SongRepository();
        song = new Song();
        databaseService = new DatabaseService();

    }

    @AfterEach
    void tearDown() {
        songRepository = null;
        song = null;
    }


    @Test
    void getSongByIdSuccess() throws SQLException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        Song output = songRepository.getById(connection, song.getSongId());
        Song expectedOutput = songRepository.getById(connection, output.getSongId());
        Assertions.assertEquals(expectedOutput, output);
    }

    @Test
    void getSongByIdFailure() throws SQLException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        Song expectedOutput = songRepository.getById(connection, song.getSongId());
        boolean output = songRepository.deleteById(connection, song.getSongId());
        Assertions.assertNotEquals(expectedOutput, output);
    }

}