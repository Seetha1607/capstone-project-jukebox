/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 23-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.model;

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
}
