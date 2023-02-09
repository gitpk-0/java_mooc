/* Hash Map */


/*
A HashMap is, in addition to ArrayList, one of the most widely used of Java's
pre-built data structures. The hash map is used whenever data is stored as
key-value pairs, where values can be added, retrieved, and deleted using keys.

In the example below, a HashMap object has been created to search for cities by
their postal codes, after which four postal code-city pairs have been added to
the HashMap object. At the end, the postal code "00710" is retrieved from the
hash map. Both the postal code and the city are represented as strings.
*/

HashMap<String, String> postalCodes = new HashMap<>();
postalCodes.put("00710", "Helsinki");
postalCodes.put("90014", "Oulu");
postalCodes.put("33720", "Tampere");
postalCodes.put("33014", "Tampere");

System.out.println(postalCodes.get("00710")); // Helsinki

/*
If the hash map does not contained the key used for the search, its get method
returns a null reference. */

HashMap<String, String> numbers = new HashMap<>();
numbers.put("One", "Uno");
numbers.put("Two", "Dos");

String translation = numbers.get("One");
System.out.println(translation);

System.out.println(numbers.get("Two"));
System.out.println(numbers.get("Three"));
System.out.println(numbers.get("Uno"));
// output:
// Uno
// Dos
// null
// null

/* 
Using a hash map requires the import java.util.HashMap; statement at the
beginning of the class.

Two type parameters are required when creating a hash map - the type of the key
and the type of the value added. If the keys of the hash map are of type
string, and the values of type integer, the hash map is created with the
following statement HashMap<String, Integer> hashmap = new HashMap<>();

Adding to the hash map is done through the put(*key*, *value*) method that has
two parameters, one for the key, the other for the value. Retrieving from a
hash map happens with the help of the get(*key*) method that is passed the key
as a parameter and returns a value. */

// // 

// Hash Map Keys Correspond to a Single Value at Most

/*
The hash map has a maximum of one value per key. If a new key-value pair is
added to the hash map, but the key has already been associated with some other
value stored in the hash map, the old value will vanish from the hash map.
*/

HashMap<String, String> numbers = new HashMap<>();
numbers.put("Uno", "One");
numbers.put("Dos", "Zwei");
numbers.put("Uno", "Ein");

String translation = numbers.get("Uno");
System.out.println(translation);

System.out.println(numbers.get("Dos"));
System.out.println(numbers.get("Tres"));
System.out.println(numbers.get("Uno"));
// Sample output
// Ein
// Zwei
// null
// Ein

// //

// A Reference Type Variable as a Hash Map Value

public class Book {
    private String name;
    private String content;
    private int published;

    public Book(String name, int published, String content) {
        this.name = name;
        this.published = published;
        this.content = content;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublished() {
        return this.published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return "Name: " + this.name + " (" + this.published + ")\n"
            + "Content: " + this.content;
    }
}

HashMap<String, Book> directory = new HashMap<>();

Book senseAndSensibility = new Book("Sense and Sensibility", 1811, "...");
Book prideAndPrejudice = new Book("Pride and Prejudice", 1813, "....");

HashMap<String, Book> directory = new HashMap<>();
directory.put(senseAndSensibility.getName(), senseAndSensibility);
directory.put(prideAndPrejudice.getName(), prideAndPrejudice);

Book book = directory.get("Persuasion");
System.out.println(book);
System.out.println();
book = directory.get("Pride and Prejudice");
System.out.println(book);
// output:
// null
//
// Name: Pride and Prejudice (1813)
// Content: ...

// // 

// When should HashMaps be used?

/*
The hash map is implemented internally in such a way that searching by a key is
very fast. The hash map generates a "hash value" from the key, i.e. a piece of
code, which is used to store the value of a specific location. When a key is
used to retrieve information from a hash map, this particular code identifies
the location where the value associated with the key is. In practice, it's not
necessary to go through all the key-value pairs in the hash map when searching
for a key; the set that's checked is significantly smaller.

Hash maps work well when we know exactly what we are looking for. If we wanted
to identify books whose title contains a particular string, the hash map would
be of little use.

The hash maps also have no internal order, and it is not possible to search the
hash map based on the indexes. The items in a list are in the order they were
added to the list.

Typically, hash maps and lists are used together. The hash map provides quick
access to a specific key or keys, while the list is used, for instance, to
maintain order. */

// // 

// HashMap as an Instance Variable

String text = "Pride and Prejudice ";
text = text.toLowerCase(); // text currently "pride and prejudice "
text = text.trim(); // text now "pride and prejudice"

public class Library {
    private HashMap<String, Book> directory;

    public Library() {
        this.directory = new HashMap<>();
    }

    public void addBook(Book book) {
        String name = book.getName()
        if (name == null) {
            name = "";
        }

        name = name.toLowerCase();
        name = name.trim();

        if (this.directory.containsKey(name)) {
            System.out.println("Book is already in the library!");
        } else {
            directory.put(name, book);
        }
    }
}

// creating a sanitizedString helper method
public static String sanitizedString(String string) {
    if (string == null) {
        return "";
    }

    string = string.toLowerCase();
    return string.trim();
}


public class Library {
    private HashMap<String, Book> directory;

    public Library() {
        this.directory = new HashMap<>();
    }

    public void addBook(Book book) {
        String name = sanitizedString(book.getName());

        if (this.directory.containsKey(name)) {
            System.out.println("Book is already in the library!");
        } else {
            directory.put(name, book);
        }
    }

    public Book getBook(String bookTitle) {
        bookTitle = sanitizedString(bookTitle);
        return this.directory.get(bookTitle);
    }

    public void removeBook(String bookTitle) {
        bookTitle = sanitizedString(bookTitle);

        if (this.directory.containsKey(bookTitle)) {
            this.directory.remove(bookTitle);
        } else {
            System.out.println("Book was not found, cannot be removed!");
        }
    }

    public static String sanitizedString(String string) {
        if (string == null) {
            return "";
        }

        string = string.toLowerCase();
        return string.trim();
    }
}

Book senseAndSensibility = new Book("Sense and Sensibility", 1811, "...");
Book prideAndPrejudice = new Book("Pride and Prejudice", 1813, "....");

Library library = new Library();
library.addBook(senseAndSensibility);
library.addBook(prideAndPrejudice);

System.out.println(library.getBook("pride and prejudice");
System.out.println();

System.out.println(library.getBook("PRIDE AND PREJUDICE");
System.out.println();

System.out.println(library.getBook("SENSE"));

// output:
// Name: Pride and Prejudice (1813)
// Content: ...
//
// Name: Pride and Prejudice (1813)
// Content: ...
//
// null

// DRY (Don't Repeat Yourself) 
/* In the above example, we adhered to the DRY (Don't Repeat Yourself) principle
according to which code duplication should be avoided. Sanitizing a string,
i.e., changing it to lowercase, and trimming, i.e., removing empty characters
from the beginning and end, would have been repeated many times in our library
class without the sanitizedString method. Repetitive code is often not noticed
until it has already been written, which means that it almost always makes its
way into the code. There's nothing wrong with that - the important thing is
that the code is cleaned up so that places that require tidying up are noticed*/

// //

// Going through a HashMap's keys

/*
We may sometimes want to search for a book by a part of its title. The get
method in the hash map is not applicable in this case as it's used to search by
a specific key. Searching by a part of a book title is not possible with it.

We can go through the values of a hash map by using a for-each loop on the set
returned by the keySet() method of the hash map.

Below, a search is performed for all the books whose names contain the given
string.
*/

public ArrayList<Book> getBookByPart(String titlePart) {
    titlePart = sanitizedString(titlePart);

    ArrayList<Book> books = new ArrayList<>();

    for(String bookTitle : this.directory.keySet()) {
        if(!bookTitle.contains(titlePart)) {
            continue;
        }

        // if the key contains the given string
        // we retrieve the value related to it
        // and add it tot the set of books to be returned

        books.add(this.directory.get(bookTitle));
    }

    return books;
}

/*
This way, however, we lose the speed advantage that comes with the hash map. The
hash map is implemented in such a way that searching by a single key is
extremely fast. The example above goes through all the book titles when looking
for the existence of a single book using a particular key. */

// //

// Going Through A Hash map's Values

/*
The preceding functionality could also be implemented by going through the hash
map's values. The set of values can be retrieved with the hash map's values
() method. This set of values can also be iterated over with a for-each
loop. */

public ArrayList<Book> getBookByPart(String titlePart) {
    titlePart = sanitizedString(titlePart);

    ArrayList<Book> books = new ArrayList<>();

    for(Book book : this.directory.values()) {
        if(!book.getName().contains(titlePart)) {
            continue;
        }

        books.add(book);
    }

    return books;
}

/*As with the previous example, the speed advantage that comes with the hash map
is lost. */

// //

// Primitive Variables in Hash Maps

/*
A hash map expects that only reference-variables are added to it (in the same
way that ArrayList does). Java converts primitive variables to their
corresponding reference-types when using any Java's built in data structures
(such as ArrayList and HashMap). Although the value 1 can be represented as a
value of the primitive int variable, its type should be defined as Integer when
using ArrayLists and HashMaps. */

HashMap<Integer, String> hashmap = new HashMap<>(); // works
hashmap.put(1, "Ole!");
HashMap<int, String> map2 = new HashMap<>(); // doesn't work

/*
A hash map's key and the object to be stored are always reference-type
variables. If you want to use a primitive variable as a key or value, there
exists a reference-type version for each one. A few have been introduced
below.

PRIMITIVE  ----->   REFERENCE-TYPE EQUIVALENT
int        ----->   Integer
double     ----->   Double
char       ----->   Character

Java converts primitive variables to reference-types automatically as they are
added to either a HashMap or an ArrayList. This automatic conversion to a
reference-type variable is termed auto-boxing in Java, i.e. putting something
in a box automatically. The automatic conversion is also possible in the other
direction. */

int key = 2;
HashMap<Integer, Integer> hashmap = new HashMap<>();
hashmap.put(key, 10);
int value = hashmap.get(key);
System.out.println(value);
// Sample output
// 10

/*
The following examples describes a class used for counting the number of vehicle
number-plate sightings. Automatic type conversion takes place in the
addSighting and timesSighted methods. */

public class registerSightingCounter {
    private HashMap<String, Integer> allSightings;

    public registerSightingCounter() {
        this.allSightings = new HashMap<>();
    }

    public void addSighting(String sighted) {
        if (!this.allSightings.containsKey(sighted)) {
            this.allSightings.put(sighted, 0);
        }

        int timesSighted = this.allSightings.get(sighted);
        timesSighted++;
        this.allSightings.put(sighted, timesSighted);
    }

    public int timesSighted(String sighted) {
        return this.allSightings.get(sighted);
    }
}

/*
There is, however, some risk in type conversions. If we attempt to convert a
null reference - a sighting not in HashMap, for instance - to an integer, we
witness a java.lang.reflect.InvocationTargetException error. Such an error may
occur in the timesSighted method in the example above - if the allSightings
hash map does not contain the value being searched, it returns a null reference
and the conversion to an integer fails.

When performing automatic conversion, we should ensure that the value to be
converted is not null. For example, the timesSighted method in the program
program should be fixed in the following way. -> */

public int timesSighted(String sighted) {
    return this.allSightings.getOrDefault(sighted, 0);
}

/*
The getOrDefault method of the HashMap searches for the key passed to it as a
parameter from the HashMap. If the key is not found, it returns the value of
the second parameter passed to it. The one-liner shown above is equivalent in
its function to the following. */

public int timesSighted(String sighted) {
    if (this.allSightings.containsKey(sighted)) {
        return this.allSightings.get(sighted);
    }

    return 0;
}

/*
Let's make the addSighting method a little bit neater. In the original version,
0 is set as the value of the sighting count in the hash map if the given key is
not found. We then get retrieve the count of the sightings, increment it by
one, and the previous value of the sightings is replaced with the new one by
adding the incremented count back into the hash map. A part of this can also be
replaced with the getOrDefault method. */

public class registerSightingCounter {
    private HashMap<String, Integer> allSightings;

    public registerSightingCounter() {
        this.allSightings = new HashMap<>();
    }

    public void addSighting(String sighted) {
        int timesSighted = this.allSightings.getOrDefault(sighted, 0);
        timesSighted++;
        this.allSightings.put(sighted, timesSighted);
    }

    public int timesSighted(String sighted) {
        return this.allSightings.getOrDefault(sighted, 0);
    }
}