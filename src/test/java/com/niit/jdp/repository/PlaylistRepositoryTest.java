package com.niit.jdp.repository;

import com.niit.jdp.exception.PlaylistNotFoundException;
import com.niit.jdp.model.Playlist;
import com.niit.jdp.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;


class PlaylistRepositoryTest {
    PlaylistRepository playlistRepository = null;
    Playlist playlist;
    DatabaseService databaseService = new DatabaseService();

    @BeforeEach
    void setUp() {
        playlistRepository = new PlaylistRepository();
        playlist = new Playlist();
        databaseService = new DatabaseService();
    }

    @AfterEach
    void tearDown() {
        playlistRepository = null;
        playlist = null;
    }

    @Test
    void getPlaylistByIdSuccess() throws SQLException, ClassNotFoundException, PlaylistNotFoundException {
        databaseService.connect();
        Connection connection1 = databaseService.getConnection();
        Playlist actualOutput = playlistRepository.getById(connection1, playlist.getPlaylistId());
        Playlist expectedOutput = playlistRepository.getById(connection1, actualOutput.getPlaylistId());
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void getPlaylistByIdFailure() throws SQLException, ClassNotFoundException, PlaylistNotFoundException {
        databaseService.connect();
        Connection connection1 = databaseService.getConnection();
        Playlist expectedOutput = playlistRepository.getById(connection1, playlist.getPlaylistId());
        boolean actualOutput = playlistRepository.deleteById(connection1, playlist.getPlaylistId());
        Assertions.assertNotEquals(expectedOutput, actualOutput);
    }
}