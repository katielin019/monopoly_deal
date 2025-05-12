package net.twelvefourseven;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int numPlayers = 0;
        
        while (true) {
            System.out.print("Input the number of players: ");
            String input = sc.nextLine();

            try {
                numPlayers = Integer.parseInt(input);
                if (numPlayers < 2 || numPlayers > 5) {
                    System.out.println("Please enter a number between 2 and 5.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        System.out.println("In Monopoly Deal, the youngest player goes first.");
        List<String> names = new ArrayList<>(numPlayers);

        for (int i = 1; i < numPlayers + 1; i++) {
            System.out.print("Input the name of player " + i + ": ");
            names.add(sc.nextLine());
        }

        System.out.println("Initializing game...");
        System.out.println("--------------------");
        GameController gc = new GameController(names);
        gc.run();
    }
}