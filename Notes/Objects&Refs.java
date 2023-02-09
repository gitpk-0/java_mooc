/* Objects and References */

public class Person {

    private String name;
    private int age;
    private int weight;
    private int height;

    public Person(String name) {
        this(name, 0, 0, 0);
    }

    public Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    // other constructors and methods

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getHeight() {
        return this.height;
    }

    public void growOlder() {
        this.age = this.age + 1;
    }

    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    public void setWeight(int newWeight) {
        this.weight = newWeight;
    }

    public double bodyMassIndex() {
        double heightPerHundred = this.height / 100.0;
        return this.weight / (heightPerHundred * heightPerHundred);
    }

    @Override
    public String toString() {
        return this.name + ", age " + this.age + " years";
    }
}

Person joan = new Person("Joan Ball");

/* Calling a constructor with the command new causes several things to happen. 
First, space is reserved in the computer memory for storing object variables. 
Then default or initial values are set to object variables (e.g. an int type 
variable receives an initial value of 0). Lastly, the source code in the 
constructor is executed.

A constructor call returns a reference to an object. A reference is information 
about the location of object data.

So the value of the variable is set to be a reference, i.e. knowledge about the 
location of related object data. The image above also reveals that strings — 
the name of our example person, for instance — are objects, too.


/* Assigning a reference type variable copies the reference */

/* Let's add a Person type variable called ball into the program, and 
assign joan as its initial value. What happens then? */

Person joan = new Person("Joan Ball");
System.out.println(joan);

Person ball = joan;

/* The statement Person ball = joan; creates a new Person variable ball, and 
copies the value of the variable joan as its value. As a result, ball refers 
to the same object as joan. 

Let's inspect the same example a little more thoroughly: */

Person joan = new Person("Joan Ball");
System.out.println(joan);

Person ball = joan;
ball.growOlder();
ball.growOlder();

System.out.println(joan);
// outputs:
// Joan Ball, age 0 years
// Joan Ball, age 2 years


/* Joan Ball — i.e. the Person object that the reference in the joan variable 
points at — starts as 0 years old. After this the value of the joan variable is 
assigned (so copied) to the ball variable. The Person object ball is aged by 
two years, and Joan Ball ages as a consequence!

An object's internal state is not copied when a variable's value is assigned. 
A new object is not being created in the statement Person ball = joan; — the 
value of the variable ball is assigned to be the copy of joan's value, i.e. a 
reference to an object. 

Next, the example is continued so that a new object is created for the joan 
variable, and a reference to it is assigned as the value of the variable. The 
variable ball still refers to the object that we created earlier. */

Person joan = new Person("Joan Ball");
System.out.println(joan);

Person ball = joan;
ball.growOlder();
ball.growOlder();

System.out.println(joan);

joan = new Person("Joan B.");
System.out.println(joan);
// outputs:
// Joan Ball, age 0 years
// Joan Ball, age 2 years
// Joan B., age 0 years

/* So in the beginning the variable joan contains a reference to one object, 
but in the end a reference to another object has been copied as its value. 
Here is a picture of the situation after the last line of code.

// //


/* null value of a reference variable */

/* Let's extend the example further by setting the value of the reference 
variable ball to null, i.e. a reference "to nothing". The null reference can 
be set as the value of any reference type variable. */

Person joan = new Person("Joan Ball");
System.out.println(joan);

Person ball = joan;
ball.growOlder();
ball.growOlder();

System.out.println(joan);

joan = new Person("Joan B.");
System.out.println(joan);

ball = null;

/* The object whose name is Joan Ball is referred to by nobody. In other words, 
the object has become "garbage". In the Java programming language the programmer
need not worry about the program's memory use. From time to time, the automatic
garbage collector of the Java language cleans up the objects that have become 
garbage. If the garbage collection did not happen, the garbage objects would 
reserve a memory location until the end of the program execution.

Let's see what happens when we try to print a variable that references "nothing"
i.e. null: */

Person joan = new Person("Joan Ball");
System.out.println(joan);

Person ball = joan;
ball.growOlder();
ball.growOlder();

System.out.println(joan);

joan = new Person("Joan B.");
System.out.println(joan);

ball = null;
System.out.println(ball);
// output:
// Joan Ball, age 0 years
// Joan Ball, age 2 years
// Joan B., age 0 years
// null

/* Printing a null reference prints "null". How about if we were to try and call
a method, say growOlder, on an object that refers to nothing: */

Person joan = new Person("Joan Ball");
System.out.println(joan);

joan = null;
joan.growOlder();
// output:
// Joan Ball, age 0 years
// Exception in thread "main" java.lang.NullPointerException
// at Main.main(Main.java:(row))
// Java Result: 1

/* In the course of the program, there occured an error indicating that we 
called a method on a variable that refers to nothing. Fortunately, the error 
message is useful: it tells which row caused the error. */

// //


//
// Object as a method parameter
//

public class AmusementParkRide {
    private String name;
    private int lowestHeight;

    public AmusementParkRide(String name, int lowestHeight) {
        this.name = name;
        this.lowestHeight = lowestHeight;
    }

    // passing a person object to the allowedToRide method
    public boolean allowedToRide(Person person) { 
        if (person.getHeight() < this.lowestHeight) {
            return false;
        }

        return true;
    }

    public String toString() {
        return this.name + ", minimum height: " + this.lowestHeight;
    }
}

// another example:
Person matt = new Person("Matt");
matt.setWeight(86);
matt.setHeight(180);

Person jasper = new Person("Jasper");
jasper.setWeight(34);
jasper.setHeight(132);

AmusementParkRide waterTrack = new AmusementParkRide("Water track", 140);

if (waterTrack.allowedToRide(matt)) {
    System.out.println(matt.getName() + " may enter the ride");
} else {
    System.out.println(matt.getName() + " may not enter the ride");
}

if (waterTrack.allowedToRide(jasper)) {
    System.out.println(jasper.getName() + " may enter the ride");
} else {
    System.out.println(jasper.getName() + " may not enter the ride");
}

System.out.println(waterTrack);
// output:
// Matt may enter the ride
// Jasper may not enter the ride
// Water track, minimum height: 140

/*
*
Assisted creation / generation of constructors, getters, and setters
IntelliJ IDEA = Shift + G (custom)
IntelliJ IDEA = Alt + Insert (default)
*
*/

// // 

//
// Object as object variable
//

public class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }
}

public class Person {
    private String name;
    private SimpleDate birthday;
    private int weight = 0;
    private int length = 0;
}
// ...

// constructor
public Person(String name, SimpleDate date) {
    this.name = name;
    this.birthday = date;
}

// alternative constructor
public Person(String name, int day, int month, int year) {
    this.name = name;
    this.birthday = new SimpleDate(day, month, year);
}


public String toString() {
    return this.name + ", born on " + this.birthday;
}

SimpleDate date = new SimpleDate(1, 1, 780);
Person muhammad = new Person("Muhammad ibn Musa al-Khwarizmi", date);
Person pascal = new Person("Blaise Pascal", 19, 6, 1623);

System.out.println(muhammad);
System.out.println(pascal);

// output:
// Muhammad ibn Musa al-Khwarizmi, born on 1.1.780
// Blaise Pascal, born on 19.6.1623

/* 
Now a person object has object variables name and birthday. The variable 
name is a string, which itself is an object; the variable birthday is a 
SimpleDate object.

Both variables contain a reference to an object. Therefore a person object 
contains two references. * weight and height are not considered in this example

So the main program is connected to two Person objects by strands. A person has 
a name and a birthday. Since both variables are objects, these attributes exist 
at the other ends of the strands.

Birthday appears to be a good extension to the Person class. Earlier we noted 
that the object variable age can be calculated with birthday, so it was removed.
*/


// //

//
// Date in Java programs
//

/*
In the section above, we use our own class SimpleDate to represent date, 
because it is suitable for illustrating and practising the operation of objects.
If you want to handle dates in your own programs, it's worth reading about the 
premade Java class LocalDate. It contains a significant amount of functionality 
that can be used to handle dates.

LocalDate:
https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html

For example, the current date can be used with the existing LocalDate class in 
the following manner: */

import java.time.LocalDate;

public class Example {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        System.out.println("today is  " + day + "." + month + "." + year);

    }
}


// //

//
// Object of same type as method parameter
//

public class Person {
    // ...

    public boolean olderThan(Person compared) {
        // 1. First compare years
        int ownYear = this.getBirthday().getYear();
        int comparedYear = compared.getBirthday().getYear();

        if (ownYear < comparedYear) {
            return true;
        }

        if (ownYear > comparedYear) {
            return false;
        }

        // 2. Same birthyear, compare months
        int ownMonth = this.getBirthday().getMonth();
        int comparedMonth = compared.getBirthday().getMonth();

        if (ownMonth < comparedMonth) {
            return true;
        }

        if (ownMonth > comparedMonth) {
            return false;
        }

        // 3. Same birth year and month, compare days
        int ownDay = this.getBirthday().getDay();
        int comparedDay = compared.getBirthday().getDay();

        if (ownDay < comparedDay) {
            return true;
        }

        return false;
    }
}

Person muhammad = new Person("Muhammad ibn Musa al-Khwarizmi", 1, 1, 780);
Person pascal = new Person("Blaise Pascal", 19, 6, 1623);

if (muhammad.olderThan(pascal)) {  //  same as muhammad.olderThan(pascal)==true
    System.out.println(muhammad.getName() + " is older than " + pascal.getName());
} else {
    System.out.println(muhammad.getName() + " is not older than " + pascal.getName());
}
// output:
// Muhammad ibn Musa al-Khwarizmi is older than Blaise Pascal

/* Let's pause for a moment to consider abstraction, one of the principles of 
object-oriented programming. The idea behind abstraction is to conceptualize 
the programming code so that each concept has its own clear responsibilities. 
When viewing the solution above, however, we notice that the comparison 
functionality would be better placed inside the SimpleDate class instead of 
the Person class.

We'll create a method called public boolean before(SimpleDate compared) for the 
class SimpleDate. The method returns the value true if the date given as the 
parameter is after (or on the same day as) the date of the object whose 
method is called. */

public class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    // used to check if this date object (`this`) is before
    // the date object given as the parameter (`compared`)
    public boolean before(SimpleDate compared) {
        // first compare years
        if (this.year < compared.year) {
            return true;
        }

        if (this.year > compared.year) {
            return false;
        }

        // years are same, compare months
        if (this.month < compared.month) {
            return true;
        }

        if (this.month > compared.month) {
            return false;
        }

        // years and months are same, compare days
        if (this.day < compared.day) {
            return true;
        }

        return false;
    }
}

/* Even though the object variables year, month, and day are encapsulated 
(private) object variables, we can read their values by writing 
compared.*variableName*. This is because a private variable can be accessed 
from all the methods contained by that class. Notice that the syntax here 
matches calling some object method. Unlike when calling a method, we refer 
to a field of an object, so the parentheses that indicate a method call 
are not written.

// // 


//
// Comparing the equality of objects (equals)
//

/* With primitive variables such as int, comparing two variables can be done 
with two equality signs. This is because the value of a primitive variable is 
stored directly in the "variable's box". The value of reference variables, in 
contrast, is an address of the object that is referenced; so the "box" contains 
a reference to the memory location. Using two equality signs compares the 
equality of the values stored in the "boxes of the variables" — with reference 
variables, such comparisons would examine the equality of the memory references.

The method equals is similar to the method toString in the respect that it is 
available for use even if it has not been defined in the class. The default 
implementation of this method compares the equality of the references. Let's 
observe this with the help of the previously written SimpleDate class. */

SimpleDate first = new SimpleDate(1, 1, 2000);
SimpleDate second = new SimpleDate(1, 1, 2000);
SimpleDate third = new SimpleDate(12, 12, 2012);
SimpleDate fourth = first;

if (first.equals(first)) {
    System.out.println("Variables first and first are equal");
} else {
    System.out.println("Variables first and first are not equal");
}

if (first.equals(second)) {
    System.out.println("Variables first and second are equal");
} else {
    System.out.println("Variables first and second are not equal");
}

if (first.equals(third)) {
    System.out.println("Variables first and third are equal");
} else {
    System.out.println("Variables first and third are not equal");
}

if (first.equals(fourth)) {
    System.out.println("Variables first and fourth are equal");
} else {
    System.out.println("Variables first and fourth are not equal");
}
// output:
// Variables first and first are equal
// Variables first and second are not equal
// Variables first and third are not equal
// Variables first and fourth are equal

/* There is a problem with the program above. Even though two dates (first 
and second) have exactly the same values for object variables, they are 
different from each other from the point of view of the default equals method.

If we want to be able to compare two objects of our own design with the equals 
method, that method must be defined in the class. The method equals is defined 
as a method that returns a boolean type value — the return value indicates 
whether the objects are equal.

The equals method is implemented in such a way that it can be used to compare 
the current object with any other object. The method receives an Object-type 
object as its single parameter — all objects are Object-type, in addition to 
their own type. The equals method first compares if the addresses are equal: 
if so, the objects are equal. After this, we examine if the types of the 
objects are the same: if not, the objects are not equal. Next, the Object-type 
object passed as the parameter is converted to the type of the object that is 
being examined by using a type cast, so that the values of the object variables 
can be compared. Below the equality comparison has been implemented for the 
SimpleDate class. */

public class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public boolean equals(Object compared) {
        // if the variables are located in the same position (address), they are equal
        if (this == compared) {
            return true;
        }

        // if the type of the compared object is not SimpleDate, the objects are not equal
        if (!(compared instanceof SimpleDate)) {
            return false;
        }

        // convert the Object type compared object
        // into a SimpleDate type object called comparedSimpleDate
        SimpleDate comparedSimpleDate = (SimpleDate) compared;

        // if the values of the object variables are the same, the objects are equal
        if (this.day == comparedSimpleDate.day &&
            this.month == comparedSimpleDate.month &&
            this.year == comparedSimpleDate.year) {
            return true;
        }

        // otherwise the objects are not equal
        return false;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }
}

/* Building a similar comparison functionality is possible for Person objects 
too. Below, the comparison has been implemented for Person objects that don't 
have a separate SimpleDate object. Notice that the names of people are strings 
(i.e. objects), so we use the equals method for comparing them. */

public class Person {

    private String name;
    private int age;
    private int weight;
    private int height;

    // constructors and methods


    public boolean equals(Object compared) {
        // if the variables are located in the same position, they are equal
        if (this == compared) {
            return true;
        }

        // if the compared object is not of type Person, the objects are not equal
        if (!(compared instanceof Person)) {
            return false;
        }

        // convert the object into a Person object
        Person comparedPerson = (Person) compared;

        // if the values of the object variables are equal, the objects are equal
        if (this.name.equals(comparedPerson.name) &&
            this.age == comparedPerson.age &&
            this.weight == comparedPerson.weight &&
            this.height == comparedPerson.height) {
            return true;
        }

        // otherwise the objects are not equal
        return false;
    }

    // .. methods
}
// notice a generic Object passed to equals, not the Person type object
// this is why the third step casts the object to a Person object

// What is Object?

/* Every class we create (and every ready-made Java class) inherits the class 
Object, even though it is not specially visible in the program code. This is 
why an instance of any class can be passed as a parameter to a method that 
receives an Object type variable as its parameter. Inheriting the Object can 
be seen elsewhere, too: for instance, the toString method exists even if you 
have not implemented it yourself, just as the equals method does.

To illustrate, the following source code compiles successfully: equals method 
can be found in the Object class inherited by all classes. */

public class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }
}

Bird red = new Bird("Red");
System.out.println(red);

Bird chuck = new Bird("Chuck");
System.out.println(chuck);

if (red.equals(chuck)) {
    System.out.println(red + " equals " + chuck);
}

// //


//
// Object equality and lists
//

/* Let's examine how the equals method is used with lists. Let's assume we have 
the previously described class Bird without any equals method. */

public class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }
}

/* Let's create a list and add a bird to it. After this we'll check if that 
bird is contained in it. */

ArrayList<Bird> birds = new ArrayList<>()
Bird red = new Bird("Red");

if (birds.contains(red)) {
    System.out.println("Red is on the list.");
} else {
    System.out.println("Red is not on the list.");
} // Red is not on the list.

birds.add(red);
if (birds.contains(red)) {
    System.out.println("Red is on the list.");
} else {
    System.out.println("Red is not on the list.");
} // Red is on the list.


System.out.println("However!"); // However!

red = new Bird("Red");
if (birds.contains(red)) {
    System.out.println("Red is on the list.");
} else {
    System.out.println("Red is not on the list.");
} // Red is not on the list.

/* When the program switches the red object into a new object, with exactly the 
same contents as before, it is no longer equal to the object on the list, and 
therefore cannot be found on the list.

The contains method of a list uses the equals method that is defined for the 
objects in its search for objects. In the example above, the Bird class has no 
definition for that method, so a bird with exactly the same contents — but a 
different reference — cannot be found on the list. */

// //



//
// Object as a method's return value
//


/* In the next example we present a simple counter that has the method clone. 
The method can be used to create a clone of the counter; i.e. a new counter 
object that has the same value at the time of its creation as the counter that 
is being cloned. */

public class Counter {
    private int value;

    // example of using multiple constructors:
    // you can call another constructor from a constructor by calling this
    // notice that the this call must be on the first line of the constructor
    public Counter() {
        this(0);
    }

    public Counter(int initialValue) {
        this.value = initialValue;
    }

    public void increase() {
        this.value = this.value + 1;
    }

    public String toString() {
        return "value: " + value;
    }

    public Counter clone() {
        // create a new counter object that receives the value of the cloned 
        // counter as its initial value
        Counter clone = new Counter(this.value);

        // return the clone to the caller
        return clone;
    }
}

// An example of using counters follows:

Counter counter = new Counter();
counter.increase();
counter.increase();

System.out.println(counter);         // prints 2

Counter clone = counter.clone();

System.out.println(counter);         // prints 2
System.out.println(clone);          // prints 2

counter.increase();
counter.increase();
counter.increase();
counter.increase();

System.out.println(counter);         // prints 6
System.out.println(clone);          // prints 2

clone.increase();

System.out.println(counter);         // prints 6
System.out.println(clone);          // prints 3

/* Immediately after the cloning operation, the values contained by the clone 
and the cloned object are the same. However, they are two different objects, so 
increasing the value of one counter does not affect the value of the other in 
any way.

Similarly, a Factory object could also be used to create and return new Car 
objects. Below is a sketch of the outline of the factory — the factory also 
knows the makes of the cars that are created. */

public class Factory {
    private String make;

    public Factory(String make) {
        this.make = make;
    }

    public Car procuceCar() {
        return new Car(this.make);
    }
}


// //

//
// final variables
//

/* If a class has variables that contain the final keyword, these varaibles
cannot be changed after objects of this class have been constructed

If you want to change these variables, you must create a new object */

// Java Program to illustrate Use of Final Keyword
// With Primitive Datatypes
 
// Main class
class GFG {
 
    // Main driver method
    public static void main(String args[])
    {
 
        // Final primitive variable
        final int i = 10;
        i = 30;
 
        // Error will be generated above
    }
}

public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {
        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return euros;
    }

    public int cents() {
        return cents;
    }

    public String toString() {
        String zero = "";
        if (cents <= 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }
}
/* The word final used in the definition of object variables catches attention.

The result of this word is that the values of these object variables cannot be 
modified after they have been set in the constructor. 

The objects of Money class are unchangeable so immutable — if we want to 
e.g. increase the amount of money, we must create a new object to represent 
that new amount of money. */

/* Note: Non-primitive variables are always references to objects in Java, the 
members of the referred object can be changed. final for non-primitive variables
just means that they cannot be changed to refer to any other object. */

// Java Program to illustrate Use of Final Keyword
// With Non-primitive Datatypes

// Class 1
class Helper {
    int i = 10;
}

// Class 2
// main class
class GFG {

    // Main driver method
    public static void main(String args[])
    {

        final Helper t1 = new Helper();
        t1.i = 30; // Works

        // Print statement for successful execution of
        // Program
        System.out.print("Successfully executed");
    }
}
// output:
// Successfully executed