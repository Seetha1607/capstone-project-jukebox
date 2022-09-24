/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 23-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.model;

import java.util.Objects;

public class Playlist {
    private int playlistId;
    private String playlistName;
    private int songId;
    private String songName;

    public Playlist() {
    }

    public Playlist(int playlistId, String playlistName, int songId, String songName) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.songId = songId;
        this.songName = songName;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public int getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return playlistId == playlist.playlistId && songId == playlist.songId && Objects.equals(playlistName, playlist.playlistName) && Objects.equals(songName, playlist.songName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, playlistName, songId, songName);
    }

    @Override
    public String toString() {
        return "Playlist ID : " + getPlaylistId() + ", Playlist Name : " + getPlaylistName() + ", Song ID : " + getSongId() + ", Song Name : " + getSongName();
    }
}
