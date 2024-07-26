import net.goui.util.MTRandom;

public class DeckMake {
    private static final int NUM_DECKS = 6;
    private static final int CARDS_PER_DECK = 52;
    private static final int TOTAL_CARDS = NUM_DECKS * CARDS_PER_DECK;
    private static final String[] SUITS = { "Hearts", "Diamonds", "Clubs", "Spades" };
    private static final String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

    private String[] deck = new String[TOTAL_CARDS];
    private double rnd;

    public DeckMake(double rnd) {
        this.rnd = rnd;
        initializeDeck();
        shuffleDeck();
    }
    //デッキの初期化
    private void initializeDeck() {
        int index = 0;
        for (int i = 0; i < NUM_DECKS; i++) {
            for (String suit : SUITS) {
                for (String rank : RANKS) {
                    deck[index++] = rank + " : " + suit;
                }
            }
        }
    }
    //デッキのシャッフル
    private void shuffleDeck() {
        MTRandom random = new MTRandom((long) (rnd * 1e9)); // rndをシードとして使用
        for (int i = TOTAL_CARDS - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }
    //デッキの表示
    public void printDeck() {
        for (String card : deck) {
            System.out.println(card);
        }
    }
    //デッキの取得
    public String[] getDeck() {
        return deck;
    }

    public static void main(String[] args) {
        final long seed = Math.round(Math.random() * 1e9);
        double drnd = 0.0;
        MTRandom rnd = new MTRandom(seed);
        drnd = rnd.nextDouble();
        DeckMake cardDeck = new DeckMake(drnd);
        cardDeck.printDeck();
    }
}