/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 23-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.model;

import java.util.Objects;

public class Song {
    private int songId;
    private String songName;
    private String artistName;
    private String genre;
    private String duration;
    private String songPath;

    public Song() {
    }

    public Song(int songId, String songName, String artistName, String genre, String duration, String songPath) {
        this.songId = songId;
        this.songName = songName;
        this.artistName = artistName;
        this.genre = genre;
        this.duration = duration;
        this.songPath = songPath;
    }

    public int getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getSongPath() {
        return songPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return songId == song.songId && Objects.equals(songName, song.songName) && Objects.equals(artistName, song.artistName) && Objects.equals(genre, song.genre) && Objects.equals(duration, song.duration) && Objects.equals(songPath, song.songPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, songName, artistName, genre, duration, songPath);
    }

    @Override
    public String toString() {
        return "Song ID : " + getSongId() + ", Song Name : " + getSongName() + ", Artist Name : " + getArtistName() + ", Genre : " + getGenre() + ", Duration : " + getDuration();
    }
}
