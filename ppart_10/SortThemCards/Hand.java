import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand implements Comparable<Hand> {

    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void add(Card card) {
        hand.add(card);
    }

    public void print() {
        hand.stream().forEach(card -> System.out.println(card));
    }

    public void sort() {
        Collections.sort(hand);
    }

    @Override
    public int compareTo(Hand second) {
        return this.getHandValue() - second.getHandValue();
    }

    public int getHandValue() {
        return hand.stream()
                .mapToInt(card -> card.getValue())
                .sum();
    }

    public void sortBySuit() {
        Collections.sort(hand, new BySuitInValueOrder());
    }
}
