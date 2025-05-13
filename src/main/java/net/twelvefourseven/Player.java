package net.twelvefourseven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Player {
    private final UUID id;
    private final String name;
    private final List<Card> hand;
    private final PlayerState state;

    public Player(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.hand = new ArrayList<>();
        this.state = new PlayerState();
    }

    public void addToBank(int cardIndex) {
        state.deposit(hand.get(cardIndex));
        hand.remove(cardIndex);
    }

    public void drawCards(List<Card> cards) {
        hand.addAll(cards);
    }

    public List<Card> getHand() {
        return Collections.unmodifiableList(hand);
    }

    public void removeFromHand(int cardIndex) {
        hand.remove(cardIndex);
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

    public boolean hasWinCondition() {
        return this.state.getFullSetCount() >= 3;
    }
}
