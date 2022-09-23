/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 23-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;


import com.niit.jdp.model.Playlist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PlaylistRepository implements Repository<Playlist> {
    @Override
    public List<Playlist> getAll(Connection connection) throws SQLException {
        String readQuery = "SELECT * FROM `jukebox`.`playlist`;";
        ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(readQuery);
            while (resultSet.next()) {
                System.out.format("%s     \n%s     \n%s     \n%s          \n%s\n",
                        "Playlist ID :" + resultSet.getInt(1) + " ",
                        "Playlist Name :" + resultSet.getString(2) + " ",
                        "Song ID :" + resultSet.getInt(3) + " ",
                        "Song Name :" + resultSet.getString(4) + " ",
                        "Song Path :" + resultSet.getString(5));
                System.out.println();
            }
        }
        return List.of(new Playlist());
    }

    @Override
    public Playlist getById(Connection connection, int id) throws SQLException {
        return null;
    }

    @Override
    public boolean deleteById(Connection connection, int id) throws SQLException {
        return false;
    }
}
