import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {
    public int compare(Card c1, Card c2) {
        boolean suit = c1.getSuitOrdinal() == c2.getSuitOrdinal();
        boolean value = c1.getValue() == c2.getValue();
        if (suit && value) {
            return 0; // cards are the same
        }

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(c1);
        cards.add(c2);

        Comparator<Card> comparator = Comparator
                .comparing(Card::getSuitOrdinal)
                .thenComparing(Card::getValue);

        Collections.sort(cards, comparator);
        int index = cards.indexOf(c1);

        // c1 is smaller returns -1 | c1 is larger returns 1
        return (index == 0) ? -1 : 1;
    }

    // Suggested solution
    // @Override
    // public int compare(Card c1, Card c2) {
    //     if (c1.getSuit() == c2.getSuit()) {
    //         return c1.getValue() - c2.getValue();
    //     }
    //
    //     return c1.getSuit().compareTo(c2.getSuit());
    // }
}
