/* THE COMPARABLE INTERFACE */

/*In the previous section, we looked at interfaces in more general terms - let's
now familiarize ourselves with one of Java's ready-made interfaces. The
Comparable interface defines the compareTo method used to compare objects. If a
class implements the Comparable interface, objects created from that class can
be sorted using Java's sorting algorithms.

The compareTo method required by the Comparable interface receives as its
parameter the object to which the "this" object is compared. If the "this"
object comes before the object received as a parameter in terms of sorting
order, the method should return a negative number. If, on the other hand,
the "this" object comes after the object received as a parameter, the method
should return a positive number. Otherwise, 0 is returned. The sorting
resulting from the compareTo method is called natural ordering.

Let's take a look at this with the help of a Member class that represents a
child or youth who belongs to a club. Each club member has a name and height.
The club members should go to eat in order of height, so the Member class
should implement the Comparable interface. The Comparable interface takes as
its type parameter the class that is the subject of the comparison. We'll use
the same Member class as the type parameter.*/

public class Member implements Comparable<Member> {
    private String name;
    private int height;

    public Member(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return this.name;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        return this.getName() + " (" + this.getHeight() + ")";
    }

    @Override
    public int compareTo(Member member) {
        if (this.height == member.getHeight()) {
            return 0;
        } else if (this.height > member.getHeight()) {
            return 1;
        } else {
            return -1;
        }
    }
}

/*The compareTo method required by the interface returns an integer that informs
us of the order of comparison.

As returning a negative number from compareTo() is enough if the this object is
smaller than the parameter object, and returning zero is sufficient when the
lengths are the same, the compareTo method described above can also be
implemented as follows.*/

@Override
public int compareTo(Member member) {
    return this.height - member.getHeight();
}

/*Since the Member class implements the Comparable interface, it is possible to
sort the list by using the sorted method. In fact, objects of any class that
implement the Comparable interface can be sorted using the sorted method. Be
aware, however, that a stream does not sort the original list - only the items
in the stream are sorted.

If a programmer wants to organize the original list, the sort method of the
Collections class should be used. This, of course, assumes that the objects on
the list implement the Comparable interface.

Sorting club members is straightforward now.*/

List<Member> member = new ArrayList<>();
member.add(new Member("mikael", 182));
member.add(new Member("matti", 187));
member.add(new Member("ada", 184));

member.stream().forEach(m -> System.out.println(m));
System.out.println();
// sorting the stream that is to be printed using the sorted method
member.stream().sorted().forEach(m -> System.out.println(m));
member.stream().forEach(m -> System.out.println(m));
// sorting a list with the sort-method of the Collections class
Collections.sort(member);
member.stream().forEach(m -> System.out.println(m));
// Sample output
// mikael (182)
// matti (187)
// ada (184)

// mikael (182)
// ada (184)
// matti (187)

// mikael (182)
// matti (187)
// ada (184)

// mikael (182)
// ada (184)
// matti (187)

// //

// Implementing Multiple Interfaces
/*A class can implement multiple interfaces. Multiple interfaces are implemented
by separating the implemented interfaces with commas (public class ...
implements *FirstInterface*, *SecondInterface* ...). Implementing multiple
interfaces requires us to implement all of the methods for which
implementations are required by the interfaces.

Say we have the following Identifiable interface.
*/
public interface Identifiable {
    String getId();
}

/*We want to create a Person who is both identifiable and sortable. This can be
achieved by implementing both of the interfaces. An example is provided below.*/

public class Person implements Identifiable, Comparable<Person> {
    private String name;
    private String socialSecurityNumber;

    public Person(String name, String socialSecurityNumber) {
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    @Override
    public String getId() {
        return getSocialSecurityNumber();
    }

    @Override
    public int compareTo(Person another) {
        return this.getId().compareTo(another.getId());
    }
}

// // 

// Sorting Method as a Lambda Expression
/*Let's assume that we have the following Person class for use.*/

public class Person {

    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }
}

// And person objects on a list.

ArrayList<Person> persons = new ArrayList<>();
persons.add(new Person("Ada Lovelace", 1815));
persons.add(new Person("Irma Wyman", 1928));
persons.add(new Person("Grace Hopper", 1906));
persons.add(new Person("Mary Coombs", 1929));

/*We want to sort the list without having to implement the Comparable interface.

Both the sort method of the Collections class and the stream's sorted method
accept a lambda expression as a parameter that defines the sorting criteria.
More specifically, both methods can be provided with an object that implements
the Comparator interface, which defines the desired order - the lambda
expression is used to create this object.*/

ArrayList<Person> persons = new ArrayList<>();
persons.add(new Person("Ada Lovelace", 1815));
persons.add(new Person("Irma Wyman", 1928));
persons.add(new Person("Grace Hopper", 1906));
persons.add(new Person("Mary Coombs", 1929));

persons.stream().sorted((p1, p2) -> {
    return p1.getBirthYear() - p2.getBirthYear();
}).forEach(p -> System.out.println(p.getName()));

System.out.println();

persons.stream().forEach(p -> System.out.println(p.getName()));

System.out.println();

Collections.sort(persons, (p1, p2) -> p1.getBirthYear() - p2.getBirthYear());

persons.stream().forEach(p -> System.out.println(p.getName()));
// Sample output
// Ada Lovelace
// Grace Hopper
// Irma Wyman
// Mary Coombs

// Ada Lovelace
// Irma Wyman
// Grace Hopper
// Mary Coombs

// Ada Lovelace
// Grace Hopper
// Irma Wyman
// Mary Coombs

/*When comparing strings, we can use the compareTo method provided by the String
class. The method returns an integer that describes the order of both the
string given to it as a parameter and the string that's calling it.*/

ArrayList<Person> persons = new ArrayList<>();
persons.add(new Person("Ada Lovelace", 1815));
persons.add(new Person("Irma Wyman", 1928));
persons.add(new Person("Grace Hopper", 1906));
persons.add(new Person("Mary Coombs", 1929));

persons.stream().sorted((p1, p2) -> {
    return p1.getName().compareTo(p2.getName());
}).forEach(p -> System.out.println(p.getName()));
// Sample output
// Ada Lovelace
// Grace Hopper
// Irma Wyman
// Mary Coombs

// //

/*Sorting By Multiple Criteria

We sometimes want to sort items based on a number of things. Let's look at an
example in which films are listed in order of their name and year of release.
We'll make use of Java's Comparator class here, which offers us the
functionality required for sorting. Let's assume that we have the class Film at
our disposal.*/

public class Film {
    private String name;
    private int releaseYear;

    public Film(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return this.name;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public String toString() {
        return this.name + " (" + this.releaseYear + ")";
    }
}

/*The Comparator class provides two essential methods for sorting: comparing and
thenComparing. The comparing method is passed the value to be compared first,
and the thenComparing method is the next value to be compared. The
thenComparing method can be used many times by chaining methods, which allows
virtually unlimited values to be used for comparison.

When we sort objects, the comparing and thenComparing methods are given a
reference to the object's type - the method is called in order and the values
returned by the method are compared. The method reference is given as
Class::method. In the example below, we print movies by year and title in
order.
*/
List<Film> films = new ArrayList<>();
films.add(new Film("A", 2000));
films.add(new Film("B", 1999));
films.add(new Film("C", 2001));
films.add(new Film("D", 2000));

for (Film e: films) {
    System.out.println(e);
}

Comparator<Film> comparator = Comparator
              .comparing(Film::getReleaseYear)
              .thenComparing(Film::getName);

Collections.sort(films, comparator);

for (Film e: films) {
    System.out.println(e);
}
// Sample output
// A (2000)
// B (1999)
// C (2001)
// D (2000)

// B (1999)
// A (2000)
// D (2000)
// C (2001)

// // // //