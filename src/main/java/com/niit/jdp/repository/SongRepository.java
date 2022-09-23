/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 23-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongRepository implements Repository<Song> {
    @Override
    public List<Song> getAll(Connection connection) throws SQLException {
        String readQuery = "SELECT * FROM `jukebox`.`song`;";
        List<Song> songsList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet songsResultSet = statement.executeQuery(readQuery);
            while (songsResultSet.next()) {
                int songId = songsResultSet.getInt("song_id");
                String songName = songsResultSet.getString("song_name");
                String artistName = songsResultSet.getString("artist_name");
                String genre = songsResultSet.getString("genre");
                String duration = songsResultSet.getString("duration");
                String songPath = songsResultSet.getString("Song path");
                Song songs = new Song(songId, songName, artistName, genre, duration, songPath);
                songsList.add(songs);
            }
        }
        return songsList;
    }

    @Override
    public Song getById(Connection connection, int id) throws SQLException {
        return null;
    }

    @Override
    public boolean deleteById(Connection connection, int id) throws SQLException {
        return false;
    }
}
