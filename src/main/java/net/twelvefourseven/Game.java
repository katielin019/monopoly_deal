package net.twelvefourseven;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final static int INITIAL_HAND_SIZE = 5;
    private final static int DRAW_SIZE = 2;
    private final List<Player> players;
    private final Deck deck;
    private int currPlayerIndex;

    public Game(List<String> playerNames) {
        this.players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }

        this.deck = new Deck();
        this.currPlayerIndex = 0;
        startGame();
    }

    private void startGame() {
        for (Player p : players) {
            p.drawCards(deck.deal(INITIAL_HAND_SIZE));
        }
    }

    public Player getCurrentPlayer() {
        return players.get(currPlayerIndex);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void startTurn() {
        Player curr = players.get(currPlayerIndex);
        if (curr.getHand().isEmpty()) {
            System.out.println("Since you're out of cards, 5 new ones have been drawn into your hand to start your turn.");
            curr.drawCards(deck.deal(INITIAL_HAND_SIZE));
        } else {
            System.out.println("To start your turn, 2 cards have been drawn into your hand.");
            curr.drawCards(deck.deal(DRAW_SIZE));
        }
    }

    public void passGo() {
        Player curr = players.get(currPlayerIndex);
        curr.drawCards(deck.deal(DRAW_SIZE));
    }

    public void endTurn() {
        this.currPlayerIndex = (this.currPlayerIndex + 1) % this.players.size();
    }

    // TODO: add "end game" method
}
