package net.twelvefourseven;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private final static int MAX_MOVES = 3;
    private final static int MAX_CARDS_IN_HAND = 7;
    private final Game game;
    private final Scanner sc = new Scanner(System.in);

    public GameController(List<String> playerNames) {
        this.game = new Game(playerNames);
    }

    public void run() {
        while (!isGameOver()) {
            Player p = game.getCurrentPlayer();
            System.out.println("It's " + p.getName() + "'s turn. You can make up to 3 moves.");

            game.startTurn();
            int moveCount = 0;
            while (moveCount < MAX_MOVES) {
                System.out.println();
                System.out.println("MOVE #" + moveCount + 1);
                displayHand(p);
                System.out.print("Choose a card to play by entering 'bank <card number>', or type 'skip' to end your turn: ");

                String input = sc.nextLine().trim();
                if (input.equalsIgnoreCase("skip")) break;

                if (handlePlayerMove(p, input)) {
                    moveCount++;
                }
            }
            handlePlayerHandLimit(p);
            game.endTurn();
        }
    }

    private boolean handlePlayerMove(Player p, String input) {
        try {
            String[] fields = input.split(" ");
            if (fields.length != 2) {
                System.out.println("Invalid input format.");
                return false;
            }

            String action = fields[0];
            int cardIndex = Integer.parseInt(fields[1]) - 1;

            List<Card> hand = p.getHand();
            if (cardIndex < 0 || cardIndex >= hand.size()) {
                System.out.println("Invalid card index.");
                return false;
            }

            // NOTE TO SELF: I'd like to handle this logic more elegantly, 
            // but for now I'm just focusing on a minimal yet functional implementation
            if (action.equalsIgnoreCase("bank")) {
                p.addToBank(cardIndex);
                return true;
            } else {
                System.out.println("Unknown action: " + action);
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return false;
        }
        // TODO: HANDLE OTHER MOVE TYPES
    }

    private void handlePlayerHandLimit(Player p) {
        while (p.getHand().size() > MAX_CARDS_IN_HAND) {
            System.out.println("You have more than 7 cards in your hand.");
            System.out.println();
            displayHand(p);
            System.out.print("Select a card to move to the discard pile: ");
            int cardIndex = Integer.parseInt(sc.nextLine()) - 1;
            if (cardIndex < 0 || cardIndex >= p.getHand().size()) {
                System.out.println("Invalid card index.");
                continue;
            } else {
                p.removeFromHand(cardIndex);
            }
        }
    }

    private void displayHand(Player player) {
        List<Card> hand = player.getHand();
        for (int i = 1; i < hand.size() + 1; i++) {
            System.out.println(i + ": " + hand.get(i - 1));
        }
        System.out.println();
    }

    private boolean isGameOver() {
        for (Player p : game.getPlayers()) {
            if (p.hasWinCondition()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(2);
        names.add("Pascal");
        names.add("Jackie");
        GameController gc = new GameController(names);
        Player pascal = gc.game.getCurrentPlayer();
        gc.game.startTurn();
        gc.game.startTurn();
        gc.handlePlayerHandLimit(pascal);
    }
}
