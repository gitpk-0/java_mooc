/* Programming Paradigms */

/*

A programming paradigm is a way of thinking about and structuring a program's
functionality. Programming paradigms differ from one another, for example in
how the program's execution and control are defined and what components the
programs consist of.

Most programming languages ​​that are currently in use support multiple
programming paradigms. Part of a programmer's growth involves the ability,
through experience, to choose the appropriate programming language and
paradigm; there currently is no single ubiquitous programming language and
programming paradigm.

The most common programming paradigms today are object-oriented programming,
procedural programming, and functional programming. The first two of these are
briefly discussed in what follows.

Object-Oriented Programming 

In object-oriented programming, information is
represented as classes that describe the concepts of the problem domain and the
logic of the application. Classes define the methods that determine how
information is handled. During program execution, objects are instantiated from
classes that contain runtime information and that also have an effect on
program execution: program execution typically proceeds through a series of
method calls related to the objects. As mentioned a few weeks ago, "the program
is built from small, clear, and cooperative entities."

The basic ideas of object-oriented programming, i.e., the representation of
information and its processing methods with he help of classes and objects,
first appeared in Simula 67, which was designed for developing simulations and
the Smalltalk programming language. Its breakthrough came in the 1980s through
the C++ programming language and Java has made it one of the most widely used
programming paradigms in the world.

One of the major benefits of object-oriented programming is how problem-domain
concepts are modeled through classes and objects, which makes programs easier
to understand. In addition, structuring the problem domain into classes
facilitates the construction and maintenance of programs. However,
object-oriented programming is not inherently suited to all problems: for
example, scientific computing and statistics applications typically make use of
languages, such as R and Python.


Procedural programming 

Whereas in object-oriented programming, the structure of
a program is formed by the data it processes, in procedural programming, the
structure of the program is formed by functionality desired for the program:
the program acts as a step-by-step guide for the functionality to be performed.
The program is executed one step at a time, and subroutines (methods) are
called whenever necessary.

In procedural programming, the state of the program is maintained in variables
and tables, and any methods handle only the values provided to them as
parameters. The program tells the computer what should happen. As an example,
the code below demonstrates the swapping of values for two variables a and b

*/

int a = 10;
int b = 15;

// let's swap the values of variables a and b
int c = b;
b = a;
a = c;

/*
When comparing object-oriented programming with procedural programming, a few
essential differences emerge. In object-oriented programming, the state of an
object can, in principle, change with any object method, and that change of
state can also affect the working of the methods of other objects. As a
consequence, other aspects of a program's execution may also be affected since
objects can be used in multiple places within the program.

The difference between object-oriented programming and procedural programming
are shown concretely in the clock example presented at the beginning of Part
Five. The solution below depicts a procedural style where the printing of the
time is transferred to a method.
*/

int hours = 0;
int minutes = 0;
int seconds = 0;

while (true) {
    // 1. printing the time
    print(hours, minutes, seconds);
    System.out.println();

    // 2. advancing the second hand
    seconds = seconds + 1;

    // 3. advancing the other hands when necessary
    if (seconds > 59) {
        minutes = minutes + 1;
        seconds = 0;

        if (minutes > 59) {
            hours = hours + 1;
            minutes = 0;

            if (hours > 23) {
                hours = 0;
            }
        }
    }
}
public static void print(int hours, int minutes, int seconds) {
    print(hours);
    print(minutes);
    print(seconds);
}

public static void print(int value) {
    if (value < 10) {
        System.out.print("0");

    System.out.print(value);
}

// The same implemented in an object-oriented way:

public class Hand {
    private int value;
    private int upperBound;

    public Hand(int upperBound) {
        this.upperBound = upperBound;
        this.value = 0;
    }

    public void advance() {
        this.value = this.value + 1;

        if (this.value >= this.upperBound) {
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

public class Clock() {
    private Hand hours;
    private Hand minutes;
    private Hand seconds;

    public Clock() {
        this.hours = new Hand(24);
        this.minutes = new Hand(60);
        this.seconds = new Hand(60);
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