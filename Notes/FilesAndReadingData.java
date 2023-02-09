/* FILES AND READING DATA */

// Reading from the keyboard
Scanner scanner = new Scanner(System.in);

while (true) {
    String line = scanner.nextLine();

    if (line.equals("end")) {
        break;
    }

    // add the read line to a list for later
    // handling or handle the line immediately

}

// Reading From a File

/* 
Reading a file is done using the Scanner-class. When we want to read a file 
using the Scanner-class, we give the path for the file we want to read as a 
parameter to the constructor of the class. The path to the file can be acquired 
using Java's Paths.get command, which is given the file's name in string format 
as a parameter: Paths.get("filename.extension") 

When the Scanner-object that reads the file has been created, the file can be 
read using a while-loop. The reading proceeds until all the lines of the file 
have been read, i.e., until the scanner finds no more lines to read. Reading a 
file may result in an error, and it's for this reason that the process requires 
separate blocks - one for the try, and another to catch potential errors.
*/

// first
import java.util.Scanner;
import java.nio.file.Paths;

// in the program:

// we create a scanner for reading the file
try (Scanner scanner = new Scanner(Paths.get("file.txt"))) {

    // we read the file until all lines have been read
    while (scanner.hasNextLine()) {
        // we read one line
        String row = scanner.nextLine();
        // we print the line that we read
        System.out.println(row);
    }
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}


// An Empty Line in a File

/* 
Sometimes an empty line finds it way into a file. Skipping an empty line can 
be done using the command continue and the isEmpty-method of the string.

In the example below, we read from a file

Reading data is straightforward.
*/




// Reading Data of a Specific Format From a File

// csv format
Scanner scanner = new Scanner(System.in);

while (true) {
    System.out.print("Enter name and age separated by a comma: ");
    String line = scanner.nextLine();

    if (line.equals("")) {
        break;
    }
}

String[] parts = line.split(",");
String name = parts[0];
int age = Integer.valueOf(parts[1]);

System.out.println("Name: " + name);
System.out.println("Age: " + age);
}




// Reading Objects from a File


ArrayList<Person> people = new ArrayList<>();

try (Scanner scanner = new Scanner(Paths.get("records.txt"))) {

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();

        String[] parts = line.split(",");
        String name = parts[0];
        int age = Integer.valueOf(parts[1]);

        people.add(new Person(name, age));
    }
}

System.out.println("Total amount of people read: " + people.size());

/* Reading objects from a file is a clear responsibility in and of iteself, and
should for that reason be isolated into a method */

ublic class StoringRecords {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Filename:");
        String file = scan.nextLine();

        ArrayList<Person> records = readRecordsFromFile(file);
        System.out.println("Persons: " + records.size());
        System.out.println("Persons:");
        for (Person person : records) {
            System.out.println(person);

        }
    }

    public static ArrayList<Person> readRecordsFromFile(String file) {
        ArrayList<Person> persons = new ArrayList<>();

        // Write here the code for reading from file
        // and printing the read records
        try (Scanner reader = new Scanner(Paths.get(file))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(",");

                String name = parts[0];
                int age = Integer.valueOf(parts[1]);

                persons.add(new Person(name, age));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return persons;

    }
}