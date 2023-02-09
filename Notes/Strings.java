// Initialize & Print
String magicWord = "abracadabra";
System.out.println(magicWord);



// Read & Print
Scanner reader = new Scanner(System.in);

System.out.print("What's your name? ");
// reading a line from the user and assigning it to the name variable
String name = reader.nextLine();

System.out.println(name);



// Concatenate Strings
String greeting = "Hi ";
String name = "Lily";
String goodbye = " and see you later!";

String phrase = greeting + name + goodbye;

System.out.println(phrase);



// String Comparisons and "Equals"
String text = "course";

if (text.equals("marzipan")) {
    System.out.println("The text variable contains the text marzipan.");
} else {
    System.out.println("The text variable does not contain the text marzipan.");
}


    // the equals command is always appended to the end of the string that we
    // want to compare
String text = "course";
String anotherText = "horse";


// String comparison - compare
if (text.equals(anotherText)) {
    System.out.println("The two texts are equal!");
} else {
    System.out.println("The two texts are not equal!");
}

    // a boolean value can be inverted through negatiion - !
System.out.println("Make sure the text is not 'cake'");
String text = "pie";

if (!(text.equals("cake"))) {  // true if the condition text.equals("cake") is false
    System.out.println("it wasn't!");
} else {
    System.out.println("it was!");
}



// Splitting a String
// split method of the String class
// Splitting a string always produces an array of strings.
String text = "first second third fourth";
String[] pieces = text.split(" ");
System.out.println(pieces[0]);
System.out.println(pieces[1]);
System.out.println(pieces[2]);
System.out.println(pieces[3]);

System.out.println();

for (int i = 0; i < pieces.length; i++) {
    System.out.println(pieces[i]);
}



// Contains method
String text = "volcanologist";

if (text.contains("can")) {
    System.out.println("can was found");
}

if (!text.contains("tin")) {
    System.out.println("tin wasn't found");
}



// charAt method  
// get a character at a specified index
String text = "Hello world!";
char character = text.charAt(0);
System.out.println(character);



// Length of a string
// length() method
String word = "equisterian";
int length = word.length();
System.out.println("The length of the word" + word + " is " + length);