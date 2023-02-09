/* OBJECT ORIENTED PROGRAMMING */

public class ClockHand {
    private int value;
    private int limit;

    public ClockHand(int limit) {
        this.limit = limit;
        this.value = 0;
    }

    public void advance() {
        this.value = this.value + 1;

        if (this.value >= this.limit) {
            this.value = 0;
        }
    }

    public int value() {
        return this.value;
    }

    public String toString() {
        if (this.value < 10) {
            return "0" + this.value;
        }

        return "" + this.value;
    }
}


public class Clock {
    private ClockHand hours;
    private ClockHand minutes;
    private ClockHand seconds;

    public Clock() {
        this.hours = new ClockHand(24);
        this.minutes = new ClockHand(60);
        this.seconds = new ClockHand(60);
    }

    public void advance() {
        this.seconds.advance();

        if (this.seconds.value() == 0) {
            this.minutes.advance();

            if (this.minutes.value() == 0) {
                this.hours.advance();
            }
        }
    }

    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
}

Clock clock = new Clock();

while (true) {
    System.out.println(clock);
    clock.advance();
}

/* 
The clock we implemented above is an object whose functionality is based on 
"simpler" objects, i.e., its hands. This is precisely the great idea behind 
object-oriented programming: a program is built from small and distinct objects 
that work together 
*/

/*
Object oriented programming is primarily about isolating concepts into their
own entities or, in other words, creating abstractions

Separating a concept into its own class is a good idea for many reasons:

Firstly, certain details can be hidden inside the class (i.e., abstracted)

Another massive advantage is that since the details of the implementation are
not visible to its user, they can be changed if desired.
*/


/** OBJECT **/

/*
An Object refers to an independent entity that contains both data (instance
variables) and behavior (methods). Objects interact with one another through
method calls -- these methods calls are used to both request information from
objects and give instructions to them.

Examples of different forms of objects:
*problem-domain concepts
*coordinate the iteraction between objects

Generally, each object has clearly defined boundaries and behaviors and is only 
aware of the objects that it needs to perform its task. In other words, the 
object hides its internal operations, providing access to its functionality 
through clearly defined methods. Moreover, the object is independent of any 
other object that it doesn't require to accomplish its task.

A Class contains the blueprint needed to create objects, and also defines the 
objects' variables and methods. An object is created on the basis of the class 
constructor.

When building an application that deals with objects, the functionality and 
features related to a person are gathered based on the application's use case

The state of an object is the value of its internal variables at any given 
point in time.

*/



/** CLASS **/

/*
A class defines the types of objects that can be created from it. It contains
instance variables describing the object's data, a constructor or constructors
used to create it, and methods that define its behavior.

Some methods in the rectangle class below do not return a value (methods that
have the keyword void in their definition), while others do (methods that 
specify the type of variable to be returned). The class below also defines the
toString method, which returns the string used to print the object.
*/
// class
public class Rectangle {

    // instance variables
    private int width;
    private int height;

    // constructor
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // methods
    public void widen() {
        this.width = this.width + 1;
    }

    public void narrow() {
        if (this.width > 0) {
            this.width = this.width - 1;
        }
    }

    public int surfaceArea() {
        return this.width * this.height;
    }

    public String toString() {
        return "(" + this.width + ", " + this.height + ")";
    }
}
// Objects are created from the class through constructors by using the new 
// command:
Rectangle first = new Rectangle(40, 80);
Rectangle rectangle = new Rectangle(10, 10);
System.out.println(first);
System.out.println(rectangle);