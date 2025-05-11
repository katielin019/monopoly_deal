package net.twelvefourseven;

public class Card {
    private final int value;
    
    public Card(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return this.value + "M";
    }
}
