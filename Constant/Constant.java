package Constant;

public class Constant {
    //デッキ数
    public static final int NUM_DECKS = 6;
    //デッキ枚数
    public static final int CARDS_PER_DECK = 52;
    //デッキ総枚数
    public static final int TOTAL_CARDS = NUM_DECKS * CARDS_PER_DECK;
    //スート
    public static final String[] SUITS = { "Hearts", "Diamonds", "Clubs", "Spades" };
    //ランク
    public static final String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
}