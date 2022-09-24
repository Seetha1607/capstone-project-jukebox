/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 23-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MusicPlayerService {
    /**
     * It takes the playlist ID as input and plays the song corresponding to that playlist ID
     *
     * @param connection The connection object that is used to connect to the database.
     * @param songPath   The path of the song file.
     */
    public void play(Connection connection, String songPath) throws SQLException {

        int playlistID;
        try (Statement statement = connection.createStatement()) {
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("Select playlist ID to play your song : ");
            playlistID = input.nextInt();
            statement.executeQuery("SELECT * FROM `playlist` WHERE playlist_id = '" + playlistID + "'");
        }
        if (playlistID == 1) {
            songPath = "src/main/resources/songs/Believer-Imagine-Dragons.wav";
        } else if (playlistID == 2) {
            songPath = "src/main/resources/songs/Dance-Monkey-Tones-And-I.wav";
        } else if (playlistID == 3) {
            songPath = "src/main/resources/songs/Umbrella-Rihanna.wav";
        } else if (playlistID == 4) {
            songPath = "src/main/resources/songs/Unstoppable-Sia.wav";
        } else if (playlistID == 5) {
            songPath = "src/main/resources/songs/Who-Says-Selena-Gomez.wav";
        } else if (playlistID == 6) {
            songPath = "src/main/resources/songs/Girls-Like-You-Maroon-5-Feat-Cardi-B.wav";
        } else if (playlistID == 7) {
            songPath = "src/main/resources/songs/Love-Yourself-Justin-Bieber.wav";
        } else if (playlistID == 8) {
            songPath = "src/main/resources/songs/Senorita-Camila-Cabello.wav";
        } else if (playlistID == 9) {
            songPath = "src/main/resources/songs/The-Weeknd-Blinding-Lights.wav";
        } else if (playlistID == 10) {
            songPath = "src/main/resources/songs/We-Dont-Talk-Anymore-Charlie-Puth-Feat-Selena-Gomez.wav";
        } else if (playlistID == 11) {
            songPath = "src/main/resources/songs/Lovely-Billie-Eilish.wav";
        } else if (playlistID == 12) {
            songPath = "src/main/resources/songs/Memories-Maroon-5.wav";
        } else if (playlistID == 13) {
            songPath = "src/main/resources/songs/Payphone-Maroon-5-Feat-Wiz-Khalifa.wav";
        } else if (playlistID == 14) {
            songPath = "src/main/resources/songs/Perfect-Ed-Sheeran.wav";
        } else if (playlistID == 15) {
            songPath = "src/main/resources/songs/What-Makes-You-Beautiful-Harry-Styles.wav";
        }
        File songFile = new File(songPath);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Scanner sc = new Scanner(System.in);
            int input;
            int temp = 0;
            long clippo = 0;

            while (temp == 0) {
                System.out.println("\nEnter your Choice\n------- ---- -------\n1.Pause\n2.Resume\n3.Restart\n4.Exit");

                input = sc.nextInt();
                switch (input) {
                    case 1 : {
                        clippo = clip.getMicrosecondPosition();
                        clip.stop();
                        System.out.println("---------------");
                        System.out.println("Song Paused");
                        System.out.println("---------------");
                    }
                    case 2 : {
                        clip.setMicrosecondPosition(clippo);
                        clip.start();
                        System.out.println("---------------");
                        System.out.println("Song Resumed");
                        System.out.println("---------------");
                    }
                    case 3 :{
                        clip.setMicrosecondPosition(0);
                        clip.start();
                        System.out.println("---------------");
                        System.out.println("Song Restarted");
                        System.out.println("---------------");
                    }
                    case 4 :{
                        System.out.println("Exit");
                    }
                    default:{
                        System.out.println("Invalid Choice!!");
                    }
                }
            }
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException exception) {
            exception.printStackTrace();
        }
    }
}
