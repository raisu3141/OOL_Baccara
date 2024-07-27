public class Display {
    private String suit;
    private String rank;

    public Display(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public void printCard() {
        String cardTop = " _______ ";
        String cardMiddle = "| " + rank + (rank.length() == 1 ? "     |" : "    |");
        String cardBottom = "|     " + (rank.length() == 1 ? " " : "") + rank + "|";
        String cardSuit;

        switch (suit) {
            case "H":
                cardSuit = "|   H   |";
                break;
            case "D":
                cardSuit = "|   D   |";
                break;
            case "C":
                cardSuit = "|   C   |";
                break;
            case "S":
                cardSuit = "|   S   |";
                break;
            default:
                cardSuit = "|       |";
                break;
        }

        System.out.println(cardTop);
        System.out.println(cardMiddle);
        System.out.println("|       |");
        System.out.println(cardSuit);
        System.out.println("|       |");
        System.out.println(cardBottom);
        System.out.println(" ‾‾‾‾‾‾‾ ");
    }

    public static void main(String[] args) {
        Display card1 = new Display("H", "A");
        Display card2 = new Display("S", "10");
        Display card3 = new Display("C", "K");
        
        card1.printCard();
        card2.printCard();
        card3.printCard();
    }
}
