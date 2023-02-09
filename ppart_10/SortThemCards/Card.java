import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Card implements Comparable<Card> {

    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        if (value < 2 || value > 14) {
            throw new IllegalArgumentException("Card value must be in range 2...14.");
        }

        this.value = value;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card second) {
        boolean suit = this.getSuitOrdinal() == second.getSuitOrdinal();
        boolean value = this.getValue() == second.getValue();
        if (suit && value) {
            return 0; // cards are the same
        }

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(this);
        cards.add(second);

        Comparator<Card> comparator = Comparator
                .comparing(Card::getValue)
                .thenComparing(Card::getSuitOrdinal);

        Collections.sort(cards, comparator);
        int index = cards.indexOf(this);

        // this card is smaller returns -1, this card is larger returns 1
        return (index == 0) ? -1 : 1;

        // Suggested Solution
        // if (value == second.value) {
        //     return suit.ordinal() - second.suit.ordinal();
        // }
        //
        // return value - second.value;
    }

    @Override
    public String toString() {
        String cardValue = "" + value;
        if (value == 11) {
            cardValue = "J";
        } else if (value == 12) {
            cardValue = "Q";
        } else if (value == 13) {
            cardValue = "K";
        } else if (value == 14) {
            cardValue = "A";
        }

        return suit + " " + cardValue;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getSuitOrdinal() {
        return this.suit.ordinal();
    }

}
