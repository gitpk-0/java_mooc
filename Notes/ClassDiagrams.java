/* CLASS DIAGRAMS */

/*A class diagram is a diagram used in designing and modeling software to describe
classes and their relationships. Class diagrams enable us to model software in
a high level of abstraction and without having to look at the source code.

Classes in a class diagram correspond with classes in the source code. The
diagram shows the names and attributes of the classes, connections between the
classes, and sometimes also the methods of the classes.

Next we will get familiar with creating and reading class diagrams using UML.
Using a unified modeling language ensures that class diagrams drawn by
different people can be read and understood by everyone familiar with the
language.

// Describing class and class attributes
First we will describe one class and its attributes. Below is the source code
for a class called Person which has two class attributes name and age.*/

public class Person {
    private String name;
    private int age;
}

/*In a class diagram, a class is represented by a rectangle with the name of the
class written on top. A line below the name of the class divides the name from
the list of attributes (names and types of the class variables). The attributes
are written one attribute per line.

In a class diagram, class attributes are written "attributeName: attributeType".
A + before the attribute name means the attribute is public, and a - means the
attribute is private.*/

// [Person|-name:String;-age:int]

// Describing class constructor
/*Below we have the source code for a constructor for our Person class. The
constructor gets the name of the person as a parameter.
*/
public class Person {
    private String name;
    private int age;

    public Person(String initialName) {
        this.name = initialName;
        this.age = 0;
    }
}

/*In a class diagram, we list the constructor (and all other methods) below the
attributes. A line below the attributes list separates it from the method list.
Methods are written with +/- (depending on the visibility of the method),
method name, parameters, and their types. The constructor above is
written +Person(initialName:String)

The parameters are written the same way class attributes are — "parameterName:
parameterType".*/

// [person|-name:String;-age:int|+Person(initialName:String)]

// Describing class methods
/*Below we have added a method printPerson() which returns void to the Person
class.*/

public class Person {
    private String name;
    private int age;

    public Person(String initialName) {
        this.name = initialName;
        this.age = 0;
    }

    public void printPerson() {
        System.out.println(this.name + ", age " +   this.age + " years");
    }
}

/*In a class diagram, we list all class methods including the constructors;
constructors are listed first and then all class methods. We also write the
return type of a method in the class diagram.*/

/*[Person|
-name:String;
-age:int|
+Person(initialName:String);
+printPerson():void]*/

// A class diagram describes classes, constructors and methods
/*A class diagram describes classes and their attributes, constructors and methods
as well as the connections between classes. However a class diagram tells us
nothing about the implementation of the constructors or the methods. Therefore
a class diagram describes the structure of an object but not its
functionality.

For example the method printPerson uses the class attributes name and age, but
this cannot be seen from the class diagram.

Below we have added the method getName to the Person class which returns the
name of the Person.*/

public class Person {
    private String name;
    private int age;

    public Person(String initialName) {
        this.name = initialName;
        this.age = 0;
    }

    public void printPerson() {
        System.out.println(this.name + ", age " +   this.age + " years");
    }

    public String getName() {
        return this.name;
    }
}

/*[Person|
-name:String;
-age:int|
+Person(initialName:String);
+printPerson():void;
+getName():String]*/

// //

// Connections between classes
/*In a class diagram, the connections between classes are shown as arrows. The
arrows also show the direction of the connection.

Below we have a class Book.*/

public class Book {
    private String name;
    private String publisher;

    // constructors and methods
}

[Book|-name:String;-publisher:String]

/*If we add a variable author, type of which is Person, in the source code the
variable is declared like all other class variables.
*/
public class Book {
    private String name;
    private String publisher;
    private Person author;

    // constructors and methods
}

/*In a class diagram variables which refer to other objects are not written with
the rest of the class attributes, but are shown as connections between the
classes. In the class diagram below we have the classes Person and Book, and
the connection between them.
*/

/*[Person|
-name:String;
-age:int|
+Person(initialName:String);
+printPerson():void;
+getName():String]

[Book|
-name:String;
-publisher:String]

[Book]
-author->[Person]*/

/*The arrow shows the direction of the connection. The connection above shows that
a Book knows its author but a Person does not know about books they are the
author of. We can also add a label to the arrow to describe the connection. In
the above diagram the arrow has an accompanying label telling us that a Book
has an author.

If a book has multiple authors, the authors are saved to a list.*/

public class Book {
    private String name;
    private String publisher;
    private ArrayList<Person> authors;

    // constructors and methods
}

/*In a class diagram, this situation is described by adding a star to the end of
the arrow showing the connection between the classes. The star tells us that a
book can have between 0 and unlimited number of authors. Below we have not
amended the label to describe the multiplicity of the connection, but it would
be a good idea for the sake of clarity.*/

[Person|-name:String;-age:int|+Person(initialName:String);+printPerson():void;+getName():String][Book|-name:String;-publisher:String][Book]-*->[Person]

/*Class methods are described just like we did before. Below we have added methods
getAuthors and addAuthor to the Book class.*/

public class Book {
    private String name;
    private String publisher;
    private ArrayList<Person> authors;

    // constructor

    public ArrayList<Person> getAuthors() {
        return this.authors;
    }

    public void addAuthor(Person author) {
        this.authors.add(author);
    }
}

[Person|-name:String;-age:int|+Person(initialName:String);+printPerson():void;+getName():String][Book|-name:String;-publisher:String|+getAuthors():ArrayList;+addAuthor(author:Person)][Book]-*->[Person]

/*We could add the type of the elements in the ArrayList ArrayList<Person> and a
label describing the connection "authors" to the class diagram above.

If there is no arrowhead in a connection, both classes know about each other.
Below is an example where a book knows about its author and a person knows
about a book they have written.
*/
[Person|-name:String;-age:int|+Person(initialName:String);+printPerson():void;+getName():String][Book|-name:String;-publisher:String|+getAuthors():ArrayList;+addAuthor(author:Person)][Book]-*[Person]


public class Person {
    private String name;
    private int age;
    private Book book;

    // ...
}
public class Book {
    private String name;
    private String publisher;
    private ArrayList<Person> authors;

    // ..
}

/*As you can see, by default — if there is no star on the connection — the
connection is singular. The classes above are interesting, because a Person can
only have one book.

If a person can have multiple books and a book can have multiple authors, we add
a star to both ends of the connection:*/

[Person|-name:String;-age:int|+Person(initialName:String);+printPerson():void;+getName():String][Book|-name:String;-publisher:String|+getAuthors():ArrayList;+addAuthor(author:Person)][Book]*-*[Person]
Now the person class would be as follows:

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<Book> books;

    // ...
}

// // 

/*// Describing inheritance
In a class diagram inheritance is described by an arrow with a triangle head.
The triangle points to the class being inherited from. In the below example the
Engine inherits the class Part.*/

[Part|-id:String;-manufacturer:String;-description:String][Engine|-type:String][Part]^-[Engine]

/*In the below example the class diagram describes the classes from the Product
warehouse exercise. The ProductWarehouseWithHistory class inherits the
ProductWarehouse class, which, in turn, inherits the Warehouse class.
ChangeHistory is a separate class connected to the ProductWarehouse.
ProductWarehouseWithHistory knows about the ChangeHistory but the ChangeHistory
does not know about the ProductWarehouseWithHistory.*/

[Warehouse|-capacity:double;-balance:double|+Warehouse(capacity:double);+getBalance():double;+getCapacity():double;+howMuchSpaceLeft():double;+addToWarehouse(amount:double):void;+takeFromWarehouse(amount:double):double;+toString():String][ProductWarehouse|-name:String|+ProductWarehouse(name:String، capacity:double);+getName():String;+setName(name:String):String;+toString():String][ChangeHistory|-states:ArrayList|+ChangeHistory();+add(status:double);+clear():void;...][ProductWarehouseWithHistory||+ProductWarehouseWithHistory(name:String، capacity:double، initialBalance:double);+history():String;+printAnalysis():void;+addToWarehouse(amount:double);+takeFromWarehouse(amount:double):double][Warehouse]^-[ProductWarehouse][ProductWarehouse]^-[ProductWarehouseWithHistory][ChangeHistory]<-[ProductWarehouseWithHistory]

/*Inheritance of abstract classes is described almost the same way as regular
classes. However we add the description <<abstract>> above the name of the
class. The name of the class and its abstract methods are also written in
cursive.
*/
// part11 1 classdiagram abstracts

// //

// Describing interfaces
/*In class diagrams, interfaces are written <<interface>> NameOfTheInterface.
Below we describe an interface Readable.
*/
public interface Readable {

}

[<<interface>> Readable]

// Methods are described just like they are for a class.

/*Implementing an interface is shown as a dashed arrow with a triangle arrowhead.
Below, we describe a situation where Book implements interface Readable.*/

[<<interface>> Readable][Book]-.-^[<<interface>> Readable]


// //

/*// How these should be drawn?
Class diagrams are an excellent way to describe a problem and a problem-domain
to others. They are particularily useful when a programmer is designing a
program with multiple classes.

Often a class diagram is drawn on a whiteboard or a large sheet of paper during
the design phase. Class diagrams should be thought of as helpful tools to build
a program, which can be thrown away afterwards. You should not use too much
energy to think about the correctness and details of the modeling language.
Class diagrams should also be drawn in a suitable level of abstraction. For
example, if you have tens of classes, it might not be worth describing each
attribute and each method of each class; getting a good overview of the program
structure is the most important.

The class diagrams here have been drawn using yUML, Creately, and draw.io.
NetBeans also has tools for drawing class diagrams; for example, easyUML draws
class diagrams from the source code.*/