/* Separating User Interface from Program Logic */

public class UserInterface {
    private Scanner scanner;
    private ArrayList<String> words;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.words = new ArrayList<String>();
    }

    public void start() {

        while (true) {
            System.out.print("Enter a word: ");
            String word = scanner.nextLine();

            if (alreadyEntered(word)) {
                break;
            }

            // adding the word to the list of previous words
            this.words.add(word);

        }

        System.out.println("You gave the same word twice!");
    }

    public boolean alreadyEntered(String word) {
        return this.words.contains(word);
    }
}

/* From the point of view of the user interface, the support variable 'words' is
 just a detail. The main thing is that the user interface remembers the set of 
 words that have been entered before. The set is a clear distinct "concept" or 
 an abstraction. Distinct concepts like this are all potential objects: when we 
 notice that we have an abstraction like this in our code, we can think about 
 separating the concept into a class of its own. */


import java.util.ArrayList;
public class WordSet {
    private ArrayList<String> words

    public WordSet() {
        this.words = new ArrayList<>();
    }

    public void add(String word) {
        this.words.add(word);
    }

    public boolean contains(String word) {
        return this.words.contains(word);
    }
}

/* Now our solution is quite elegant. We have separated a distinct concept into 
a class of its own, and our user interface looks clean. All the "dirty details" 
have been encapsulated neatly inside an object. */

public class UserInterface {
    private WordSet wordSet;
    private Scanner scanner;

    public userInterface(WordSet wordSet, Scanner scanner) {
        this.wordSet = wordSet;
        this.scanner = scanner;
    }

    public void start() {

        while (true) {
            System.out.print("Enter a word: ");
            String word = scanner.nextLine();

            if (this.wordSet.contains(word)) {
                break;
            }

            this.wordSet.add(word);
        }

        System.out.println("You gave the same word twice!");
    }
}

// Starting the program is now done as follows:

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    WordSet set = new WordSet();

    UserInterface userInterface = new UserInterface(set, scanner);
    userInterface.start();
}

/* We have arrived at a situation where the class 'WordSet' "encapsulates" an 
ArrayList. Is this reasonable? Perhaps. This is because we can make other 
changes to the class if we so desire, and before long we might arrive at a 
situation where the word set has to be, for example, saved into a file. If we 
make all these changes inside the class WordSet without changing the names of 
the methods that the user interface uses, we don't have to modify the actual 
user interface at all.

The main point here is that changes made inside the class WordSet don't affect 
the class UserInterface. This is because the user interface uses WordSet 
through the methods that it provides — these are called its public interfaces.*/


// Recycling

/* When concepts have been separated into different classes in the code, 
recycling them and reusing them in other projects becomes easy. For example, 
the class 'WordSet' could be used in a graphical user interface, and it could 
also be part of a mobile phone application. In addition, testing the program is 
much easier when it has been divided into several concepts, each of which has 
its own separate logic and can function alone as a unit. */

// //

// Programming Tips

/* In the larger example above, we were following the advice given here.

Proceed with small steps

- Try to separate the program into several sub-problems and work on only one 
sub-problem at a time

- Always test that the program code is advancing in the right direction, in 
other words: test that the solution to the sub-problem is correct

- Recognize the conditions that require the program to work differently. In the 
example above, we needed a different functionality to test whether a word had 
been already entered before.

Write as "clean" code as possible

- Indent your code
- Use descriptive method and variable names
- Don't make your methods too long, not even the main method
- Do only one thing inside one method
- Remove all copy-paste code
- Replace the "bad" and unclean parts of your code with clean code

If needed, take a step back and assess the program as a whole. If it doesn't 
work, it might be a good idea to return into a previous state where the code 
still worked. As a corollary, we might say that a program that's broken is 
rarely fixed by adding more code to it.

Programmers follow these conventions so that programming can be made easier. 
Following them also makes it easier to read programs, to keep them up, and to 
edit them in teams. */

// //

/* 

Program logic

Program logic includes parts that are crucial for the execution of the program, 
like functionalities that store information. 

Separating the program logic is a major benefit for the maintenance of the 
program.

*/


// //

/*

User Interface

Typically each program has its own user interface.