package net.twelvefourseven;

import java.util.List;
import java.util.UUID;

public class Player {
    private final UUID id;
    private final String name;
    private final PlayerState state;

    public Player(String name) {
        id = UUID.randomUUID();
        this.name = name;
        state = new PlayerState();
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public PlayerState getState() {
        return this.state;
    }

    public void drawCards(List<Card> cards) {

    }
}
