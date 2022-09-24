package com.niit.jdp.service;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.SongRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

class SongServiceTest {
    SongService service;
    SongRepository songRepository;
    DatabaseService databaseService = new DatabaseService();

    @BeforeEach
    void setUp() {
        service = new SongService();
        songRepository = new SongRepository();
    }

    @AfterEach
    void tearDown() {
        service = null;
        songRepository = null;
    }

    @Test
    void getSortedNameByOrderSuccess() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        Connection connection1 = databaseService.getConnection();
        List<Song> all = songRepository.getAll(connection1);
        List<Song> expectedOutput = service.getSortedNameByOrder(all);
        Assertions.assertEquals(expectedOutput, service.getSortedNameByOrder(all));
    }

    @Test
    void getSortedNameByOrderFailure() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        Connection connection1 = databaseService.getConnection();
        List<Song> all = songRepository.getAll(connection1);
        List<Song> expectedOutput = service.getSortedNameByOrder(all);
        Assertions.assertNotEquals(expectedOutput, service.getSortedNameByOrder(all).toString());
    }
}