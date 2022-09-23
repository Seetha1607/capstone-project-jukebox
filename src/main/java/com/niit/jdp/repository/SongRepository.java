/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 23-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SongRepository implements Repository<Song> {
    @Override
    public List<Song> getAll(Connection connection) throws SQLException {
        return null;
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
