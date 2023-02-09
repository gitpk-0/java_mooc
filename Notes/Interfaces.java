/* Interfaces */

/*We can use interfaces to define behavior that's required from a class, i.e., its
methods. They're defined the same way that regular Java classes are,
but "public interface ..." is used instead of "public class ..." at the
beginning of the class. Interfaces define behavior through method names and
their return values. However, they don't always include the actual
implementations of the methods. A visibility attribute on interfaces is not
marked explicitly as they're always public. Let's examine a Readable interface
that describes readability.*/

public interface Readable {
    String read();
}

/*The Readable interface declares a read() method, which returns a String-type
object. Readable defines certain behavior: for example, a text message or an
email may be readable.

The classes that implement the interface decide how the methods defined in the
interface are implemented. A class implements the interface by adding the
keyword implements after the class name followed by the name of the interface
being implemented. Let's create a class called TextMessage that implements the
Readable interface.*/

public class TextMessage implements Readable {
    private String sender;
    private String content;

    public TextMessage(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public String getSender() {
        return this.sender;
    }

    public String read() {
        return this.content;
    }
}

/*Since the TextMessage class implements the Readable interface (public class
TextMessage implements Readable), the TextMessage class must contain an
implementation of the public String read() method. Implementations of methods
defined in the interface must always have public as their visibility
attribute.

// An Interface Is a Contract of Behaviour
When a class implements an interface, it signs an agreement. The agreement
dictates that the class will implement the methods defined by the interface. If
those methods are not implemented in the class, the program will not function.

The interface defines only the names, parameters, and return values the
required methods. The interface, however, does not have a say on the internal
implementation of its methods. It is the responsibility of the programmer to
define the internal functionality for the methods.

In addition to the TextMessage class, let's add another class that implements
the Readable interface. The Ebook class is an electronic implementation of a
book that containing the title and pages of a book. The ebook is read page by
page, and calling the public String read() method always returns the next page
as a string.*/

public class Ebook implements Readable {
    private String name;
    private ArrayList<String> pages;
    private int pageNumber;

    public Ebook(String name, ArrayList<String> pages) {
        this.name = name;
        this.pages = pages;
        this.pageNumber = 0;
    }

    public String getName() {
        return this.name;
    }

    public int pages() {
        return this.pages.size();
    }

    public String read() {
        String page = this.pages.get(this.pageNumber);
        nextPage();
        return page;
    }

    private void nextPage() {
        this.pageNumber = this.pageNumber + 1;
        if(this.pageNumber % this.pages.size() == 0) {
            this.pageNumber = 0;
        }
    }
}

/*Objects can be instantiated from interface-implementing classes just like with
normal classes. They're also used in the same way, for instance, as an
ArrayList's type.*/

TextMessage message = new TextMessage("ope", "It's going great!");
System.out.println(message.read());

ArrayList<TextMessage> textMessage = new ArrayList<>();
textMessage.add(new TextMessage("private number", "I hid the body.");
// Sample output
// It's going great!

ArrayList<String> pages = new ArrayList<>();
pages.add("Split your method into short, readable entities.");
pages.add("Separate the user-interface logic from the application logic.");
pages.add("Always program a small part initially that solves a part of the problem.");
pages.add("Practice makes the master. Try different out things for yourself and work on your own projects.");

Ebook book = new Ebook("Tips for programming.", pages);

int page = 0;
while (page < book.pages()) {
    System.out.println(book.read());
    page = page + 1;
}
// Sample output
// Split your method into short, readable entities.
// Separate the user-interface logic from the application logic.
// Always program a small part initially that solves a part of the problem.
// Practice makes the master. Try different out things for yourself and work on
// your own projects.

// //

/*// Interface as Variable Type
The type of a variable is always stated as its introduced. There are two kinds
of type, the primitive-type variables (int, double, ...) and reference-type
variables (all objects). We've so far used an object's class as the type of a
reference-type variable.*/

String string = "string-object";
TextMessage message = new TextMessage("ope", "many types for the same object");

/*An object's type can be other than its class. For example, the type of the Ebook
class that implements the Readable interface is both Ebook and Readable.
Similarly, the text message also has multiple types. Because the TextMessage
class implements the Readable interface, it has a Readable type in addition to
the TextMessage type.*/

TextMessage message = new TextMessage("ope", "Something cool's about to happen);
Readable readable = new TextMessage("ope", "The text message is Readable!");
ArrayList<String> pages = new ArrayList<>();
pages.add("A method can call itself.");

Readable book = new Ebook("Introduction to Recursion", pages);

int page = 0;
while (page < book.pages()) {
    System.out.println(book.read());
    page = page + 1;
}

/*Because an interface can be used as a type, it's possible to create a list that
contains objects of the interface's type.*/

ArrayList<Readable> readingList = new ArrayList<>();

readingList.add(new TextMessage("ope", "never been programming before..."));
readingList.add(new TextMessage("ope", "gonna love it i think!"));
readingList.add(new TextMessage("ope", "give me something more challenging! :)"));
readingList.add(new TextMessage("ope", "you think i can do it?"));
readingList.add(new TextMessage("ope", "up here we send several messages each day"));


ArrayList<String> pages = new ArrayList<>();
pages.add("A method can call itself.");

readingList.add(new Ebook("Introduction to Recursion.", pages));

for (Readable readable: readingList) {
    System.out.println(readable.read());
}
/*
Note that although the Ebook class that inherits the Readable interface class is
always of the interface's type, not all classes that implement the Readable
interface are of type Ebook. You can assign an object created from the Ebook
class to a Readable-type variable, but it does not work the other way without a
separate type conversion.*/

Readable readable = new TextMessage("ope", "TextMessage is Readable!"); // works
TextMessage message = readable; // doesn't work

// works if, and only if, readable is of text message type
TextMessage castMessage = (TextMessage) readable; 

/*Type conversion succeeds if, and only if, the variable is of the type that it's
being converted to. Type conversion is not considered good practice, and one of
the few situation where it's use is appropriate is in the implementation of the
equals method.
*/

/*
// Interfaces as Method Parameters
The true benefits of interfaces are reaped when they are used as the type of
parameter provided to a method. Since an interface can be used as a variable's
type, it can also be used as a parameter type in method calls. For example, the
print method in the Printer class of the class below gets a variable of type
read.
*/
public class Printer {
    public void print(Readable readable) {
        System.out.println(readable.read());
    }
}

/*The value of the print method of the printer class lies in the fact that it can
be given any class that implements the Readable interface as a parameter. Were
we to call the method with any object instantiated from a class that inherits
the Readable class, the method would function as desired.*/

TextMessage message = new TextMessage("ope", "Oh wow, this printer knows how to print these as well!");

ArrayList<String> pages = new ArrayList<>();
pages.add("Values common to both {1, 3, 5} and {2, 3, 4, 5} are {3, 5}.");
Ebook book = new Ebook("Introduction to University Mathematics.", pages);

Printer printer = new Printer();
printer.print(message);
printer.print(book);
// Sample output
// Oh wow, this printer knows how to print these as well!
// Values common to both {1, 3, 5} and {2, 3, 4, 5} are {3, 5}.

/*Let's make another class called ReadingList to which we can add interesting
things to read. The class has an ArrayList instance as an instance variable,
where the things to be read are added. Adding to the reading list is done using
the add method, which receives a Readable-type object as its parameter.*/

public class ReadingList {
    private ArrayList<Readable> readables;

    public ReadingList() {
        this.readables = new ArrayList<>();
    }

    public void add(Readable readable) {
        this.readables.add(readable);
    }

    public int toRead() {
        return this.readables.size();
    }
}

/*Reading lists are usually readable, so let's have the ReadingList class
implement the Readable interface. The read method of the reading list reads all
the objects in the readables list, and adds them to the string returned by the
read() method one-by-one.*/

public class ReadingList implements Readable {
    private ArrayList<Readable> readables;

    public ReadingList() {
        this.readables = new ArrayList<>();
    }

    public void add(Readable readable) {
        this.readables.add(readable);
    }

    public int toRead() {
        return this.readables.size();
    }

    public String read() {
        String read = "";

        for (Readable readable: this.readables) {
            read = read + readable.read() + "\n";
        }

        // once the reading list has been read, we empty it
        this.readables.clear();
        return read;
    }
}

ReadingList jonisList = new ReadingList();
jonisList.add(new TextMessage("arto", "have you written the tests yet?"));
jonisList.add(new TextMessage("arto", "have you checked the submissions yet?"));

System.out.println("Joni's to-read: " + jonisList.toRead());
// Sample output
// Joni's to-read: 2

/*Because the ReadingList is of type Readable, we're able to add ReadingList
objects to the reading list. In the example below, Joni has a lot to read.
Fortunately for him, Verna comes to the rescue and reads the messages on Joni's
behalf.*/

ReadingList jonisList = new ReadingList();
int i = 0;
while (i < 1000) {
    jonisList.add(new TextMessage("arto", "have you written the tests yet?"));
    i = i + 1;
}

System.out.println("Joni's to-read: " + jonisList.toRead());
System.out.println("Delegating the reading to Verna");

ReadingList vernasList = new ReadingList();
vernasList.add(jonisList);
vernasList.read();

System.out.println();
System.out.println("Joni's to-read: " + jonisList.toRead());
// Sample output
// Joni's to-read: 1000
// Delegating the reading to Verna

// Joni's to-read:0

/*The read method called on Verna's list goes through all the Readable objects and
calls the read method on them. When the read method is called on Verna's list
it also goes through Joni's reading list that's included in Verna's reading
list. Joni's reading list is run through by calling its read method. At the end
of each read method call, the read list is cleared. In this way, Joni's reading
list empties when Verna reads it.

As you notice, the program already contains a lot of references. It's a good
idea to draw out the state of the program step-by-step on paper and outline how
the read method call of the vernasList object proceeds!*/

// //

// Interface as a return type of a method
/*Interfaces can be used as return types in methods — just like regular variable
types. In the next example is a class Factory that can be asked to construct
different objects that implement the Packable interface.
*/
import java.util.Random;

public class Factory {

    public Factory() {
        // Note that there is no need to write an empy constructor without
        // parameters if the class doesn't have other constructors.
        // In these cases Java automatically creates a default constructor for
        // the class which is an empty constructor without parameters.
    }

    public Packable produceNew() {
        // The Random-object used here can be used to draw random numbers.
        Random ticket = new Random();
        // Draws a number from the range [0, 4). The number will be 0, 1, 2, or 3.
        int number = ticket.nextInt(4);

        if (number == 0) {
            return new CD("Pink Floyd", "Dark Side of the Moon", 1973);
        } else if (number == 1) {
            return new CD("Wigwam", "Nuclear Nightclub", 1975);
        } else if (number == 2) {
            return new Book("Robert Martin", "Clean Code", 1);
        } else {
            return new Book("Kent Beck", "Test Driven Development", 0.7);
        }
    }
}

/*The Factory can be used without exactly knowing what different kind of Packable
classes exist. In the next example there is a class Packer that gives a box of
things. A packer defines a factory which is used to create the things:*/

public class Packer {
    private Factory factory;

    public Packer() {
        this.factory = new Factory();
    }

    public Box giveABoxOfThings() {
         Box box = new Box(100);

         int i = 0;
         while (i < 10) {
             Packable newThing = factory.produceNew();
             box.add(newThing);

             i = i + 1;
         }

         return box;
    }
}

/*Because the packer does not know the classes that implement the interface
Packable, one can add new classes that implement the interface without changing
the packer. The next example creates a new class that implements the Packable
interface ChocolateBar. The factory has been changed so that it creates
chocolate bars in addition to books and CDs. The class Packer works without
changes with the updated version of the factory.*/

public class ChocolateBar implements Packable {
    // Because Java's automatically generated default constructor is enough,
    // we don't need a constructor

    public double weight() {
        return 0.2;
    }
}
import java.util.Random;

public class Factory {
    // Because Java's automatically generated default constructor is enough,
    // we don't need a constructor

    public Packable produceNew() {

        Random ticket = new Random();
        int number = ticket.nextInt(5);

        if (number == 0) {
            return new CDDisk("Pink Floyd", "Dark Side of the Moon", 1973);
        } else if (number == 1) {
            return new CDDisk("Wigwam", "Nuclear Nightclub", 1975);
        } else if (number == 2) {
            return new Book("Robert Martin", "Clean Code", 1 );
        } else if (number == 3) {
            return new Book("Kent Beck", "Test Driven Development", 0.7);
        } else {
            return new ChocolateBar();
        }
    }
}

// //

/*// Reducing the dependencies between classes
Using interfaces in programming enables reducing dependencies between classes.
In the previous example the Packer does not depend on the classes that
implement the Packable interface. Instead, it just depends on the interface.
This makes possible to add new classes that implement the interface without
changing the Packer class. What is more, adding new Packable classes doesn't
affect the classes that use the Packer class.

// Built-in Interfaces
Java offers a considerable amount of built-in interfaces. Here we'll get
familiar with four commonly used interfaces: List, Map, Set, and Collection.


// The List Interface
The List interface defines the basic functionality related to lists. Because the
ArrayList class implements the List interface, one can also use it through the
List interface.*/


List<String> strings = new ArrayList<>();
strings.add("string objects inside an arraylist object!");

/*As we can see fom the Java API of List, there are many classes that implement
the List interface. One list that is familiar to computer scientists is a
linked list. A linked list can be used through the List interface exactly the
same way as an object created from ArrayList.*/


List<String> strings = new LinkedList<>();
strings.add("string objects inside a linkedlist object!");

/*From the perspective of the user, both implementations of the List interface
work the same way. The interface abstracts their inner functionality. The
internal structures of ArrayList and LinkedList differ quite a bit. ArrayList
saves objects to an array where fetching an object with a specific index is
very fast. On the other hand LinkedList constructs a list where each element
contains a reference to the next element in the list. When one searches for an
object by index in a linked list, one has to go though the list from the
beginning until the index.

One can see noticeable performance differences between list implementations if
the lists are big enough. The strength of a linked list is that adding to it is
always fast. ArrayList, on the other hand, is backed by an array, which needs
to be resized each time it gets full. Resizing the array requires creating a
new array and copying the values from the old array to the new one. On the
other hand, searching objects by index is much faster in an array list compared
to a linked list.

For the problems that you encounter during this course you should almost always
choose ArrayList. However, "interface programming" is beneficial: implement
your programs so that you'll use the data structures through the interfaces.*/

// //

// The Map Interface
/*The Map interface defines the basic behavior associated with hash tables.
Because the HashMap class implements the Map interface, it can also be accessed
through the Map interface.*/

Map<String, String> maps = new HashMap<>();
maps.put("ganbatte", "good luck");
maps.put("hai", "yes");

// The keys to the hash table are obtained using the keySet method.

Map<String, String> maps = new HashMap<>();
maps.put("ganbatte", "good luck");
maps.put("hai", "yes");

for (String key : maps.keySet()) {
    System.out.println(key + ": " + maps.get(key));
}
// Sample output
// ganbatte: good luck
// hai: yes

/*The keySet method returns a set of elements that implement the Set interface.
You can use a for-each statement to go through a set that implements the Set
interface. The hash values can be obtained from the hash table using the values
method. The values method returns a set of elements that implement the
Collection interface. Let's take a quick look at the Set and Collection
interfaces.*/

// //

// The Set Interface
/*The Set interface describes functionality related to sets. In Java, sets always
contain either 0 or 1 amounts of any given object. As an example, the set
interface is implemented by HashSet. Here's how to go through the elements of a
set.
*/
Set<String> set = new HashSet<>();
set.add("one");
set.add("one");
set.add("two");

for (String element: set) {
    System.out.println(element);
}
// Sample output
// one
// two

/*Note that HashSet in no way assumes the order of a set of elements. If objects
created from custom classes are added to the HashSet object, they must have
both the equals and hashCode methods defined.*/

// //

// The Collection Interface
/*The Collection interface describes functionality related to collections. Among
other things, lists and sets are categorized as collections in Java — both the
List and Set interfaces implement the Collection interface. The Collection
interface provides, for instance, methods for checking the existence of an
item (the method contains) and determining the size of a collection (the method
size).

The Collection interface also determines how the collection is iterated over.
Any class that implements the Collection interface, either directly or
indirectly, inherits the functionality required for a for-each loop.

Let's create a hash table and iterate over its keys and values.*/

Map<String, String> translations = new HashMap<>();
translations.put("ganbatte", "good luck");
translations.put("hai", "yes");

Set<String> keys = translations.keySet();
Collection<String> keyCollection = keys;

System.out.println("Keys:");
for (String key: keyCollection) {
    System.out.println(key);
}

System.out.println();
System.out.println("Values:");
Collection<String> values = translations.values();

for (String value: values) {
    System.out.println(value);
}
// Sample output
// Keys:
// ganbatte
// hai

// Values:
// yes
// good luck

/*In the next exercise, we build functionality related to e-commerce and practice
using classes through their interfaces.*/

// //