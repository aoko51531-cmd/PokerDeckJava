import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;
    private List<Card> discarded;

    public Deck() {
        cards = new ArrayList<>();
        discarded = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] palos = {"treboles", "corazones", "picas", "diamantes"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {
            String color = (palo.equals("corazones") || palo.equals("diamantes")) ? "rojo" : "negro";
            for (String valor : valores) {
                cards.add(new Card(palo, color, valor));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezclo el Deck.");
    }

    public void head() {
        if (cards.isEmpty()) {
            System.out.println("El deck esta vacio.");
            return;
        }
        Card card = cards.remove(0);
        discarded.add(card);
        System.out.println(card);
        System.out.println("Quedan " + cards.size() + " cartas en deck");
    }

    public void pick() {
        if (cards.isEmpty()) {
            System.out.println("El deck esta vacio.");
            return;
        }
        Random rand = new Random();
        int index = rand.nextInt(cards.size());
        Card card = cards.remove(index);
        discarded.add(card);
        System.out.println(card);
        System.out.println("Quedan " + cards.size() + " cartas en deck");
    }

    public Card[] hand() {
        if (cards.size() < 5) {
            System.out.println("No hay suficientes cartas.");
            return new Card[0];
        }
        Card[] hand = new Card[5];
        for (int i = 0; i < 5; i++) {
            Card card = cards.remove(0);
            hand[i] = card;
            discarded.add(card);
            System.out.println(card);
        }
        System.out.println("Quedan " + cards.size() + " cartas en deck");
        return hand;
    }

    public int size() {
        return cards.size();
    }
}