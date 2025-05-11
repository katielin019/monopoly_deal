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
            p.drawCards(deck.draw(5));
        }
    }

    public Player getCurrentPlayer() {
        return players.get(currPlayerIndex);
    }
}
