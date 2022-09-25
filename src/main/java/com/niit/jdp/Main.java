package com.niit.jdp;

import com.niit.jdp.exception.PlaylistNotFoundException;
import com.niit.jdp.exception.SongNotFoundException;
import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("Welcome to the JukeBox Catalogue");
            System.out.println("============================================");
            System.out.println("1. View all playlist");
            System.out.println("2. Search full song details by playlist ID");
            System.out.println("3: Play song from the Playlist");
            System.out.println("4. Create you're own playlist");
            System.out.println("5: Delete the created playlist if you need");
            System.out.println("6. Exit");
            System.out.println("============================================");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            DatabaseService databaseService = new DatabaseService();
            try {
                boolean connect = databaseService.connect();
                System.out.println(connect);
                databaseService.printConnectionStatus();
                Connection connection = databaseService.getConnection();
                SongRepository songRepository = new SongRepository();
                PlaylistRepository playlistRepository = new PlaylistRepository();
                MusicPlayerService musicPlayerService = new MusicPlayerService();

                switch (choice) {
                    case 1: {
                        System.out.println();
                        System.out.println("View all Playlist");
                        System.out.println("===========================");
                        playlistRepository.getAll(connection);
                        break;
                    }
                    case 2: {

                        System.out.println();
                        playlistRepository.getAll(connection);
                        System.out.println("-------------------------------------------------------");
                        System.out.println("Enter Song ID to view full song details :");
                        int id = scanner.nextInt();
                        Song byId = songRepository.getById(connection, id);
                        if (byId.getSongId() == 0) {
                            throw new SongNotFoundException("The song is not in the list!! Try Valid choice.");
                        } else {
                            System.out.println(byId);
                        }
                        break;
                    }
                    case 3: {
                        System.out.println();
                        System.out.println("Viewing playlist to select ID");
                        System.out.println();
                        playlistRepository.getAll(connection);
                        musicPlayerService.play(connection, null);
                        break;
                    }
                    case 4: {
                        System.out.println();
                        System.out.println("Enter you're own Playlist Name : ");
                        String playlistName = scanner.next();
                        System.out.println("Your Playlist Name is created : " + playlistName);
                        System.out.println("Enter 1 to add song to your playlist : ");
                        int next = scanner.nextInt();
                        if (1 == next) {
                            List<Song> all = songRepository.getAll(connection);
                            System.out.println(all);
                            System.out.println("Enter Song ID to add into the playlist :");
                            int songId = scanner.nextInt();
                            System.out.println("Enter Song Name to add into the playlist : ");
                            String songName = scanner.next();
                            playlistRepository.createPlaylist(connection, playlistName, songId, songName);
                            System.out.println("Enter 2 to continue adding song to your playlist or 0 to stop adding");
                            scanner.nextInt();
                        }
                        break;
                    }
                    case 5: {
                        System.out.println();
                        List<Playlist> all = playlistRepository.getAll(connection);
                        System.out.println(all);
                        System.out.println("Enter playlist ID to delete : ");
                        int playlistId = scanner.nextInt();
                        playlistRepository.deleteById(connection, playlistId);
                        if (playlistId == 0) {
                            throw new PlaylistNotFoundException("The playlist ID is not in the list!! Try Valid choice.");
                        }
                        break;
                    }
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (SQLException | SongNotFoundException | PlaylistNotFoundException exception) {
                System.err.println("Could not connect to the database!");
                exception.printStackTrace();
                choice = 5;
            }
        } while (choice != 5);
    }
}