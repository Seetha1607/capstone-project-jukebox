/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 23-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;


import com.niit.jdp.exception.PlaylistNotFoundException;
import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository implements Repository<Playlist> {
    /**
     * This function is used to read all the data from the database and display it in the console
     *
     * @param connection This is the connection to the database.
     * @return A list of Playlist objects.
     */
    @Override
    public List<Playlist> getAll(Connection connection) throws SQLException {
        String readQuery = "SELECT * FROM `jukebox`.`playlist`;";
        ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(readQuery);
            while (resultSet.next()) {
                System.out.format("%s     \n%s     \n%s     \n%s\n",
                        "Playlist ID :" + resultSet.getInt(1) + " ",
                        "Playlist Name :" + resultSet.getString(2) + " ",
                        "Song ID :" + resultSet.getInt(3) + " ",
                        "Song Name :" + resultSet.getString(4));
                System.out.println();
            }
        }
        return List.of(new Playlist());
    }

    /**
     * This function takes a connection and a playlist object as parameters and inserts the playlist object into the
     * database
     *
     * @param connection This is the connection to the database.
     * @param playlist The playlist object that you want to add to the database.
     * @return The number of rows affected by the query.
     */
    @Override
    public boolean add(Connection connection, Playlist playlist) throws SQLException {
        String insertQuery = "INSERT INTO `jukebox`.`playlist` (playlist_name, song_id,song_name) VALUES (?,?,?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, playlist.getPlaylistName());
            preparedStatement.setInt(2, playlist.getSongId());
            preparedStatement.setString(3,playlist.getSongName());
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    /**
     * This function is used to get a playlist by its id
     *
     * @param connection The connection to the database.
     * @param id The id of the playlist you want to get.
     * @return The method returns a playlist object.
     */
    @Override
    public Playlist getById(Connection connection, int id) throws SQLException {
        String searchQuery = "SELECT * FROM `jukebox`.`playlist` WHERE(`playlist_id` = ?);";
        List<Song> songList = new SongRepository().getAll(connection);
        List<Song> songs = new ArrayList<>();
        Playlist playlist = new Playlist();
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet playlistResultSet = preparedStatement.executeQuery();
            while (playlistResultSet.next()) {
                int playlistId = playlistResultSet.getInt("playlist_id");
                String playlistName = playlistResultSet.getString("playlist_name");
                int songNumber = playlistResultSet.getInt("song_id");
                String songName = playlistResultSet.getString("song_name");
                Song songId = songList.get(songNumber - 1);
                songs.add(songId);
                playlist = new Playlist(playlistId, playlistName, songNumber,songName);
                if (playlistId == 0) {
                    throw new PlaylistNotFoundException("The playlist is not found !");
                }
            }
        } catch (PlaylistNotFoundException e) {
            throw new RuntimeException(e);
        }
        return playlist;
    }

    /**
     * > This function deletes a playlist from the database by its id
     *
     * @param connection The connection to the database.
     * @param id The id of the playlist to delete.
     * @return A boolean value.
     */
    @Override
    public boolean deleteById(Connection connection, int id) throws SQLException {
        String deleteQuery = "DELETE FROM `jukebox`.`playlist` WHERE (`playlist_id` = ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }
}
