package net.twelvefourseven;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Deck {
    private static final int TOTAL_CARDS = 106;
    private LinkedList<Card> drawPile;
    private List<Card> discardPile;

    public Deck() {
        this.drawPile = new LinkedList<>();
        this.discardPile = new ArrayList<>(TOTAL_CARDS);
        initializeCards();
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(drawPile);
    }

    public List<Card> draw(int count) {
        List<Card> drawn = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (drawPile.isEmpty()) {
                reshuffleDiscardIntoDrawPile();
                if (drawPile.isEmpty()) break;
            }
            drawn.add(drawPile.removeFirst());
        }
        return drawn;
    }

    public void discard(Card c) {
        discardPile.add(c);
    }

    public int remainingCards() {
        return drawPile.size();
    }

    private void reshuffleDiscardIntoDrawPile() {
        drawPile.addAll(discardPile);
        discardPile.clear();
        shuffle();
    }

    private void initializeCards() {
        String fp = "./cards/money.csv";
        try (Scanner sc = new Scanner(new File(fp))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                drawPile.add(new Card(Integer.parseInt(line)));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
