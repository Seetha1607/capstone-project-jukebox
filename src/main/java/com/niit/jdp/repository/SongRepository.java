/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 23-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.exception.SongNotFoundException;
import com.niit.jdp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository implements Repository<Song> {
    /**
     * This function is used to read all the songs from the database and return them as a list of songs
     *
     * @param connection This is the connection to the database.
     * @return A list of songs.
     */
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
                System.out.format("%s     %n%s     %n%s     %n%s%n", "Song ID :" + songsResultSet.getInt(1) + " ", "Song Name :" + songsResultSet.getString(2) + " ", "Artist Name :" + songsResultSet.getString(3) + " ", "Genre :" + songsResultSet.getString(4));
                System.out.println();
                Song songs = new Song(songId, songName, artistName, genre, duration, songPath);
                songsList.add(songs);
            }
        }
        return songsList;
    }

    /**
     * This function is used to get a song by its id
     *
     * @param connection The connection to the database.
     * @param id         The id of the song you want to get.
     * @return A song object.
     */
    @Override
    public Song getById(Connection connection, int id) throws SQLException {

        String searchQuery = "SELECT * FROM `jukebox`.`song` WHERE(`song_id` = ?);";
        Song songs = new Song();
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet songsResultSet = preparedStatement.executeQuery();
            while (songsResultSet.next()) {
                int songId = songsResultSet.getInt("song_id");
                String songName = songsResultSet.getString("song_name");
                String artistName = songsResultSet.getString("artist_name");
                String genre = songsResultSet.getString("genre");
                String duration = songsResultSet.getString("duration");
                String songPath = songsResultSet.getString("Song path");
                songs = new Song(songId, songName, artistName, genre, duration, songPath);
                if (songId == 0) {
                    throw new SongNotFoundException("The song is not in the list!! Try Valid choice.");
                }
            }
        } catch (SongNotFoundException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }

    /**
     * > This function deletes a song from the database by its id
     *
     * @param connection The connection to the database.
     * @param id         The id of the song to be deleted.
     * @return A boolean value.
     */
    @Override
    public boolean deleteById(Connection connection, int id) throws SQLException {
        String deleteQuery = "DELETE FROM `jukebox`.`song` WHERE (`song_id` = ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }
}
