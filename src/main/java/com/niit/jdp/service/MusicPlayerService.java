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

        int songID;
        try (Statement statement = connection.createStatement()) {
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("Select Song ID to play your song : ");
            songID = input.nextInt();
            statement.executeQuery("SELECT * FROM `playlist` WHERE song_id = '" + songID + "'");
        }
        if (songID == 1) {
            songPath = "src/main/resources/songs/Believer-Imagine-Dragons.wav";
        } else if (songID == 2) {
            songPath = "src/main/resources/songs/Dance-Monkey-Tones-And-I.wav";
        } else if (songID == 3) {
            songPath = "src/main/resources/songs/Girls-Like-You-Maroon-5-Feat-Cardi-B.wav";
        } else if (songID == 4) {
            songPath = "src/main/resources/songs/Love-Yourself-Justin-Bieber.wav";
        } else if (songID == 5) {
            songPath = "src/main/resources/songs/Lovely-Billie-Eilish.wav";
        } else if (songID == 6) {
            songPath = "src/main/resources/songs/Memories-Maroon-5.wav";
        } else if (songID == 7) {
            songPath = "src/main/resources/songs/Payphone-Maroon-5-Feat-Wiz-Khalifa.wav";
        } else if (songID == 8) {
            songPath = "src/main/resources/songs/Perfect-Ed-Sheeran.wav";
        } else if (songID == 9) {
            songPath = "src/main/resources/songs/Senorita-Camila-Cabello.wav";
        } else if (songID == 10) {
            songPath = "src/main/resources/songs/The-Weeknd-Blinding-Lights.wav";
        } else if (songID == 11) {
            songPath = "src/main/resources/songs/Umbrella-Rihanna.wav";
        } else if (songID == 12) {
            songPath = "src/main/resources/songs/Unstoppable-Sia.wav";
        } else if (songID == 13) {
            songPath = "src/main/resources/songs/We-Dont-Talk-Anymore-Charlie-Puth-Feat-Selena-Gomez.wav";
        } else if (songID == 14) {
            songPath = "src/main/resources/songs/What-Makes-You-Beautiful-Harry-Styles.wav";
        } else if (songID == 15) {
            songPath = "src/main/resources/songs/Who-Says-Selena-Gomez.wav";
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
                System.out.println("\nEnter your Choice\n------- ---- -------\n1.Pausen\n2.Resume\n3.Restart\n4.Forward by 5s\n5.Backwards by 5s\n6.Stop and Exit");
                input = sc.nextInt();
                switch (input) {
                    case 1: {
                        clippo = clip.getMicrosecondPosition();
                        clip.stop();
                        System.out.println("---------------");
                        System.out.println("Song Paused");
                        System.out.println("---------------");
                        break;
                    }
                    case 2: {
                        clip.setMicrosecondPosition(clippo);
                        clip.start();
                        System.out.println("---------------");
                        System.out.println("Song Resumed");
                        System.out.println("---------------");
                        break;
                    }
                    case 3: {
                        clip.setMicrosecondPosition(0);
                        clip.start();
                        System.out.println("---------------");
                        System.out.println("Song Restarted");
                        System.out.println("---------------");
                        break;
                    }
                    case 4: {
                        System.out.println("---------------");
                        System.out.println("Forwarding by 5s");
                        System.out.println("---------------");
                        clip.setMicrosecondPosition(clip.getMicrosecondPosition() + 5000000);
                        break;
                    }
                    case 5: {
                        System.out.println("---------------");
                        System.out.println("Back-warding by 5s");
                        System.out.println("---------------");
                        clip.setMicrosecondPosition(clip.getMicrosecondPosition() - 5000000);
                        break;
                    }
                    case 6: {
                        clip.stop();
                        System.out.println("Stop and Exit");
                        break;
                    }
                    default: {
                        System.out.println("Invalid Choice!!");
                        break;
                    }
                }
            }
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException exception) {
            exception.printStackTrace();
        }
    }
}
