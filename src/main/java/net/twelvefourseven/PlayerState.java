package net.twelvefourseven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerState {
    private final List<Card> bank;
    private final List<PropertySet> properties;
    
    public PlayerState() {
        this.bank = new ArrayList<>();
        this.properties = new ArrayList<>();
    }

    public void deposit(Card card) {
        bank.add(card);
    }

    public List<Card> getBank() {
        return Collections.unmodifiableList(bank);
    }

    public int getBankValue() {
        return bank.stream().mapToInt(Card::getValue).sum();
    }

    public boolean hasEnoughCash(int amount) {
        return getBankValue() >= amount;
    }

    public void addProperty(PropertyCard card) {
        for (PropertySet set : this.properties) {
            if (set.getType() == card.getType() && !set.isComplete()) {
                set.addProperty(card);
            }
        }

        PropertySet newSet = new PropertySet(card.getType());
        newSet.addProperty(card);
        this.properties.add(newSet);
    }
    
    public List<PropertySet> getPropertySets() {
        return Collections.unmodifiableList(this.properties);
    }

    public int getFullSetCount() {
        int count = 0;
        for (PropertySet set : this.properties) {
            if (set.isComplete()) count++;
        }
        return count;
    }
}
