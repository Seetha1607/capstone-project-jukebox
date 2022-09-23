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
    private String songPath;

    public Playlist() {
    }

    public Playlist(int playlistId, String playlistName, int songId, String songName, String songPath) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.songId = songId;
        this.songName = songName;
        this.songPath = songPath;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return playlistId == playlist.playlistId && songId == playlist.songId && Objects.equals(playlistName, playlist.playlistName) && Objects.equals(songName, playlist.songName) && Objects.equals(songPath, playlist.songPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, playlistName, songId, songName, songPath);
    }
    @Override
    public String toString() {
        return "Playlist ID : " + getPlaylistId() + ", Playlist Name : " + getPlaylistName() +
                ", Song ID : " + getSongId() + ", Song Name : " + getSongName() + ", Song Path : " + getSongPath();
    }
}
