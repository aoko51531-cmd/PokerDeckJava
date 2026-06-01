public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("Deck inicializado con " + deck.size() + " cartas.");

        deck.shuffle();

        System.out.println("\nMostrando head:");
        deck.head();

        System.out.println("\nHaciendo pick:");
        deck.pick();

        System.out.println("\nRepartiendo hand:");
        deck.hand();
    }
}