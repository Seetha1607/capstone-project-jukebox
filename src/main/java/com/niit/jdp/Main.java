package com.niit.jdp;

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

        } while (choice != 5);
    }
}