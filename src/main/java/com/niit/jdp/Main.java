package com.niit.jdp;

import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;

        do {
            System.out.println("Welcome to the JukeBox Catalogue");
            System.out.println("============================================");
            System.out.println("1. View all playlist");
            System.out.println("2. Search full song details by playlist ID");
            System.out.println("3: Play song from the Playlist");
            System.out.println("4. Create you're own playlist");
            System.out.println("5. Exit");
            System.out.println("============================================");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            DatabaseService databaseService = new DatabaseService();
            try {
                databaseService.connect();
                Connection connection = databaseService.getConnection();
                SongRepository songRepository = new SongRepository();
                PlaylistRepository playlistRepository = new PlaylistRepository();
                MusicPlayerService musicPlayerService = new MusicPlayerService();

                switch (choice){
                    case 1: {
                        System.out.println();
                        System.out.println("View all Playlist");
                        System.out.println("===========================");
                        playlistRepository.getAll(connection);
                        break;
                    }
                }
            } catch (SQLException | ClassNotFoundException exception) {
                System.err.println("Could not connect to the database!");
                exception.printStackTrace();
                choice = 5;
            }
        } while (choice != 5);
    }
}