package net.twelvefourseven;

import java.util.ArrayList;
import java.util.List;

public class Game {
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
            p.drawCards(deck.deal(5));
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
            curr.drawCards(deck.deal(5));
        } else {
            System.out.println("To start your turn, 2 cards have been drawn into your hand.");
            curr.drawCards(deck.deal(2));
        }
    }

    public void endTurn() {
        this.currPlayerIndex = (this.currPlayerIndex + 1) % this.players.size();
    }
}
