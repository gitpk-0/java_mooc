

public class Main {

    public static void main(String[] args) {
        // test your code here

        // Card first = new Card(2, Suit.DIAMOND);
        // Card second = new Card(14, Suit.SPADE);
        // Card third = new Card(12, Suit.HEART);
        //
        // System.out.println(first);
        // System.out.println(second);
        // System.out.println(third);

        // Hand hand = new Hand();
        //
        // hand.add(new Card(2, Suit.DIAMOND));
        // hand.add(new Card(14, Suit.SPADE));
        // hand.add(new Card(12, Suit.HEART));
        // hand.add(new Card(2, Suit.SPADE));
        //
        // hand.print();

        // Hand hand = new Hand();
        //
        // hand.add(new Card(2, Suit.DIAMOND));
        // hand.add(new Card(14, Suit.SPADE));
        // hand.add(new Card(12, Suit.HEART));
        // hand.add(new Card(2, Suit.SPADE));
        //
        // hand.sort();
        //
        // hand.print();

        // Hand hand1 = new Hand();
        //
        // hand1.add(new Card(2, Suit.DIAMOND));
        // hand1.add(new Card(14, Suit.SPADE));
        // hand1.add(new Card(12, Suit.HEART));
        // hand1.add(new Card(2, Suit.SPADE));
        //
        // Hand hand2 = new Hand();
        //
        // hand2.add(new Card(11, Suit.DIAMOND));
        // hand2.add(new Card(11, Suit.SPADE));
        // hand2.add(new Card(11, Suit.HEART));
        //
        // System.out.println("Hand 1 value: " + hand1.getHandValue());
        // System.out.println("Hand 2 value: " + hand2.getHandValue());
        //
        // int comparison = hand1.compareTo(hand2);
        // System.out.println(comparison);


        // Hand hand1 = new Hand();
        // hand1.add( new Card(12,Suit.HEART) );
        // Hand hand2 = new Hand();
        // hand2.add( new Card(3,Suit.SPADE) );
        // hand2.add( new Card(9,Suit.SPADE) );
        //
        // System.out.println("Hand 1 value: " + hand1.getHandValue());
        // System.out.println("Hand 2 value: " + hand2.getHandValue());
        //
        // hand2.compareTo(hand1);
        //
        // int comparison = hand1.compareTo(hand2);
        //
        // if (comparison < 0) {
        //     System.out.println("better hand is");
        //     hand2.print();
        // } else if (comparison > 0){
        //     System.out.println("better hand is");
        //     hand1.print();
        // } else {
        //     System.out.println("hands are equal");
        // }

        Hand hand = new Hand();

        hand.add(new Card(12, Suit.HEART));
        hand.add(new Card(4, Suit.SPADE));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(14, Suit.SPADE));
        hand.add(new Card(7, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));

        hand.sortBySuit();

        hand.print();
        // DIAMOND 2
        // HEART 7
        // HEART Q
        // SPADE 2
        // SPADE 4
        // SPADE A
    }
}
