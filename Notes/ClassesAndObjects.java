/** 
A class defines the attributes of objects, i.e., the information related to 
them (instance variables), and their commands, i.e., their methods. The values 
of instance (i.e., object) variables define the internal state of an individual 
object, whereas methods define the functionality it offers.
**/

/** 
 * A Method is a piece of source code written inside a class that's been named 
 * and has the ability to be called. A method is always part of some class and 
 * is often used to modify the internal state of an object instantiated from a 
 * class.
 **/


/** 
 * As an example, ArrayList is a class offered by Java, and we've made use of 
 * objects instantiated from it in our programs. Below, an ArrayList object 
 * named integers is created and some integers are added to it.
 **/

// we create an object from the ArrayList class named integers
ArrayList<Integer> integers = new ArrayList<>();

// let's add the values 15, 34, 65, 111 to the integers object
integers.add(15);
integers.add(34);
integers.add(65);
integers.add(111);

// we print the size of the integers object
System.out.println(integers.size()); // prints 4

// An object is always instantiated by calling a method that created an object, 
// i.e., a constructor by using the new keyword.


// CREATING CLASSES

/** 
 * A class specifies what the objects instantiated from it are like:

    The object's variables (instance variables) specify the internal state of
        the object

    The object's methods specify what the object does

We'll now familiarize ourselves with creating our own classes and defining the 
variable that belong to them.
**/

public class Person {
    private String name;
    private int age;
}

/** 
 * We specify above that each object created from the Person class has a name 
 * and an age. Variables defined inside a class are called instance variables, 
 * or object fields or object attributes. Other names also seem to exist.

Instance variables are written on the lines following the class definition 
public class Person {. Each variable is preceded by the keyword private. The 
keyword private means that the variables are "hidden" inside the object. This 
is known as encapsulation.
**/


// Defining a Constructor
// Objects are always created using a constructor.

public static void main(String[] args) {
    Person ada = new Person("Ada");
    // ...
}

public class Person {
    private String name;
    private int age;

    public Person(String initialName) {
        this.age = 0;
        this.name = initialName;
    }
}

// The constructor's name is always the same as the class name.

// Default Constructor
// If the programmer does not define a constructor for a class, Java 
// automatically creates a default one for it. A default constructor is a 
// constructor that doesn't do anything apart from creating the object. The 
// object's variables remain uninitialized (generally, the value of any object 
//     references will be null, meaning that they do not point to anything, and 
//     the values of primitives will be 0)

// For example, an object can be created from the class below by making the 
// call new Person()

public class Person {
    private String name;
    private int age;
}
// If a constructor has been defined for a class, no default constructor exists.
 // For the class below, calling new Person would cause an error, as Java cannot 
 // find a constructor in the class that has no parameters.

public class Person {
    private String name;
    private int age;

    public Person(String initialName) {
        this.age = 0;
        this.name = initialName;
    }
}

// Defining Methods for an Object

/** 
 * An object needs methods to be able to do anything
 * 
 * A method is a named section of source code inside a class which can
 * be invoked.
 * 
 * A method is written inside of the class beneath the constructor. The method
 * name is preceded by public void, since the method is intended to be visible
 * to the outside world (public), and it does not return a value (void)
**/

public class Person {
    private String name;
    private int age;

    public Person(String initialName) {
        this.age = 0;
        this.name = initialName;
    }

    // example method printPerson
    public void printPerson() { 
        System.out.println(this.name + ", age " + this.age + " years");
    }
}

// Returning a Value from a Method

/** 
 * If we want the method to return a value, we need to replace the void keyword
 * with the type of variable to be returned
 * 
 * In the following example, the Teacher class has a method grade that always
 * returns an integer-type (int) variable (in this case, the value 10)
 * 
 * The value is always returned with the return command:
**/

public class Teacher {
    public int grade() {
        return 10;
    }
}

// The method above returns an int type variable of 10 when called
// For the return value to be used, it needs to be assigned to a variable:

public static void main(String[] args) {
    Teacher teacher = new Teacher();

    int grading = teacher.grade();

    System.out.println("The grade received is " + grading);
    // prints The grade received is 10
}

// The method below returns a boolean:

public class Person {
    // ...

    public boolean isOfLegalAge() {
        if (this.age < 18) {
            return false;
        }

        return true;
    }

    
    // The method could have been written more succinctly in the following way:

    public boolean isOfLegalAge() {
        return this.age >= 18;
    }
}

/* 
    It is the convention in Java to name a method that returns an instance
        variable exactly this way:  getVariableName

    Such methods are often referred to as "getters"
*/



// toString Method
/* The method returning the string representation is always toString in Java */

public class Person {
    // ...

    public String toString() {
        return this.name + ", age " + this.age + " years";
    }
}

// The method is used in a somewhat surprising way:
public static void main(String[] args) {
    Person pekka = new Person("Pekka");
    Person antti = new Person("Antti");

    int i = 0;
    while (i < 30) {
        pekka.growOlder();
        i = i + 1;
    }

    antti.growOlder();

    System.out.println(antti); // same as System.out.println(antti.toString());
    System.out.println(pekka); // same as System.out.println(pekka.toString());
}

// The call to the toString method returning the string representation does not 
// have to be written explicitly, as Java adds it automatically.

// ==
System.out.println(antti);
// Java extends the above call at run time to the following form:
System.out.println(antti.toString());



// Method Parameters example:
public class Person {
    private String name;
    private int age;
    private int weight;
    private int height;

    public Person(String initialName) {
        this.age = 0;
        this.weight = 0;
        this.height = 0;
        this.name = initialName;
    }

    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    public void setWeight(int newWeight) {
        this.weight = newWeight;
    }

    public double bodyMassIndex() {
        double heigthPerHundred = this.height / 100.0;
        return this.weight / (heigthPerHundred * heigthPerHundred);
    }

    // ...
}

// In the above example Java's standard naming convention is used once again:
//   If the methods only purpose is to set a value to an instance variable,
//   then it's named as setVariableName
// Value-setting methods are often called "setters"


// A parameter and instance variable having the same name:
public class Person {
    private int height;

    public void setHeight(int height) {
        // DON'T DO THIS!!!
        height = height;
    }

    public void setHeight(int height) {
        // DO THIS INSTEAD!!!
        this.height = height;
    }
}

// Calling an internal method

public String toString() {
    return this.name + ", age " + this.age + " years, my BMI is " + this.bodyMassIndex();
}

// When an object calls an internal method, the name of the method and 
// this prefix suffice

// Alternatively:
public String toString() {
    return this.name + ", age " + this.age + " years, my BMI is " + bodyMassIndex();
} // no emphasis is placed on the fact that the object's own method is being called



/* Adding objects to a list: */

// Creating a list meant for storing Person type objects

ArrayList<Person> persons = new ArrayList<>();

// a person object can be created first
Person john = new Person("John");
// and then added to the list
persons.add(john);

// person objects can also be created "in the same sentence" that they are 
//   added to the list
persons.add(new Person("Matthew"));
persons.add(new Person("Martin"));

for (Person person: persons) {
    System.out.println(person);
}
// Output
// John, age 0 years
// Matthew, age 0 years
// Martin, age 0 years



/* Looping through list elements */

// several different repeat statements can be used to go through the list elements

// 1. while loop
int index = 0;
while (index < names.size()) {
    System.out.println(names.get(index));
    index = index + 1;
}

// 2. for loop with index
for (int i = 0; i < names.size(); i++) {
    System.out.println(names.get(i));
}

System.out.println();
// 3. for each loop (no index)
for (String name: names) {
    System.out.println(name);
}



/* Multiple constructor parameters */

public class Person {

    private String name;
    private int age;
    private int weight;
    private int height;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 0;
        this.height = 0;
    }

    // methods
}


// Reading input in a specific format:

Scanner scanner = new Scanner(System.in);
ArrayList<Person> persons = new ArrayList<>();

// Read person information from the user
System.out.println("Enter the person details separated by a comma, e.g.: Randall,2");
while (true) {
    System.out.print("Enter the details, empty will stop: ");
    String details = scanner.nextLine();
    if (details.isEmpty()) {
        break;
    }

    String[] parts = details.split(",");
    String name = parts[0];
    int age = Integer.valueOf(parts[1]);
    persons.add(new Person(name, age));
}

// Print the number of the entered persons, and the persons themselves
System.out.println();
System.out.println("Total number of persons: " + persons.size());
System.out.println("Persons: ");

for (Person person: persons) {
    System.out.println(person);
}



/* Filtered printing from the list: */

// Assume we have a 'persons' list that consists of person objects

System.out.print("What is the age limit? ");
int ageLimit = Integer.valueOf(scanner.nextLine());

for (Person person: persons) {
    if (person.getAge() >= ageLimit) {
        System.out.println(person);
    }
}
