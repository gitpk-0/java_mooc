/* ENUM AND ITERATOR*/

/*// Enumerated Type - Enum
If we know the possible values of a variable in advance, we can use a class of
type enum, i.e., enumerated type to represent the values. Enumerated types are
their own type in addition to being normal classes and interfaces. An
enumerated type is defined by the keyword enum. For example, the following Suit
enum class defines four constant values: DIAMOND, SPADE, CLUB and HEART.*/

public enum Suit {
    DIAMOND, SPADE, CLUB, HEART
}

/*In its simplest form, enum lists the constant values it declares, separated by a
comma. Enum types, i.e., constants, are conventionally written with capital
letters.

An Enum is (usually) written in its own file, much like a class or interface. In
NetBeans, you can create an Enum by selecting new/other/java/java enum from
project.

The following is a Card class where the suit is represented by an enum:*/

public class Card {

    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suit + " " + value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}

// The card is used in the following way:

Card first = new Card(10, Suit.HEART);

System.out.println(first);

if (first.getSuit() == Suit.SPADE) {
    System.out.println("is a spade");
} else {
    System.out.println("is not a spade");
}
// The output:

// Sample output
// HEARTS 10
// is not a spade

/*We see that the Enum values are outputted nicely! Oracle has a site related to
the enum data type at
http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html .

// Comparing Enums

In the example above, two enums were compared with equal signs. How does this
work?

Each enum field gets a unique number code, and they can be compared using the
equals sign. Just as other classes in Java, these values also inherit the
Object class and its equals method. The equals method compares this numeric
identifier in enum types too.

The numeric identifier of an enum field value can be found with ordinal(). The
method actually returns an order number - if the enum value is presented first,
its order number is 0. If its second, the order number is 1, and so on.*/

public enum Suits {
    DIAMOND, CLUB, HEART, SPADE
}
System.out.println(Suit.DIAMOND.ordinal());
System.out.println(Suit.HEART.ordinal());
// Sample output
// 0
// 3

/*
// Object References In Enums

Enumerated types may contain object reference variables. The values of the
reference variables should be set in an internal constructor of the class
defining the enumerated type, i.e., within a constructor having a private
access modifier. Enum type classes cannot have a public constructor.

In the following example, we have an enum Color that contains the constants RED,
GREEN and BLUE. The constants have been declared with object reference
variables referring to their color codes:
*/
public enum Color {
    // constructor parameters are defined as
    // the constants are enumerated
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF");

    private String code;        // object reference variable

    private Color(String code) { // constructor
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}

// The enum Color can be used like so:

// System.out.println(Color.GREEN.getCode());
// Sample output

// #00FF00



/*// Iterator
Let's look at the following Hand class that represents the set of cards that a
player is holding:*/

public class Hand {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void print() {
        this.cards.stream().forEach(card -> {
            System.out.println(card);
        });
    }
}

/*The print method of the class prints each card in the current hand.

ArrayList and other "object containers" that implement the Collection interface
implement the Iterable interface, and they can also be iterated over with the
help of an iterator - an object specifically designed to go through a
particular type of object collection. The following is a version of printing
the cards that uses an iterator:*/

public void print() {
    Iterator<Card> iterator = cards.iterator();

    while (iterator.hasNext()) {
        System.out.println(iterator.next());
    }
}

/*The iterator is requested from the cards list containing cards. The iterator can
be thought of as a "finger" that always points to a particular object inside
the list. Initially it points to the first item, then to the next, and so on...
until all the objects have been gone through with the help of the "finger".

The iterator offers a few methods. The hasNext() method is used to ask if there
are any objects still to be iterated over. If there are, the next object in
line can be requested from the iterator using the next() method. This method
returns the next object in line to be processed and moves the iterator,
or "finger", to point to the following object in the collection.

The object reference returned by the iterator's next method can of course also
be stored in a variable. As such, the print method could also be written in the
following way.*/

public void print(){
    Iterator<Card> iterator = cards.iterator();

    while (iterator.hasNext()) {
        Card nextInLine = iterator.next();
        System.out.println(nextInLine);
    }
}

/*Let's now consider a use case for an iterator. We'll first approach the issue
problematically to provide motivation for the coming solution. We attempt to
create a method that removes cards from a given stream with a value lower than
the given value.*/

public class Hand {
    // ...

    public void removeWorst(int value) {
        this.cards.stream().forEach(card -> {
            if (card.getValue() < value) {
                cards.remove(card);
            }
        });
    }
}

// Executing the method results in an error.

// Sample output
// Exception in thread "main" java.util.ConcurrentModificationException
// at ...
// Java Result: 1

/*The reason for this error lies in the fact that when a list is iterated over
using the forEach method, it's assumed that the list is not modified during the
traversal. Modifying the list (in this case deleting elements) causes an
error - we can think of the forEach method as getting "confused" here.

If you want to remove some of the objects from the list during a traversal, you
can do so using an iterator. Calling the remove method of the iterator object
neatly removes form the list the item returned by the iterator with the
previous next call. Here's a working example of the version of the method:*/

public class Hand {
    // ...

    public void removeWorst(int value) {
        Iterator<Card> iterator = cards.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getValue() < value) {
                // removing from the list the element returned by the previous next-method call
                iterator.remove();
            }
        }
    }
}