/* REGULAR EXPRESSIONS */

/*
// Regular Expressions
A regular expression defines a set of strings in a compact form. Regular
expressions are used, among other things, to verify the correctness of strings.
We can assess whether or not a string is in the desired form by using a regular
expression that defines the strings considered correct.

Let's look at a problem where we need to check if a student number entered by
the user is in the correct format. A student number should begin with "01"
followed by 7 digits between 0–9.

You could verify the format of the student number, for instance, by going
through the character string representing the student number using the charAt
method. Another way would be to check that the first character is "0" and call
the Integer.valueOf method to convert the string to a number. You could then
check that the number returned by the Integer.valueOf method is less than
20000000.

Checking correctness with the help of regular expressions is done by first
defining a suitable regular expression. We can then use the matches method of
the String class, which checks whether the string matches the regular
expression given as a parameter. For the student number, the appropriate
regular expression is "01[0-9]{7}", and checking the student number entered by
a user is done as follows:*/

System.out.print("Provide a student number: ");
String number = scanner.nextLine();

if (number.matches("01[0-9]{7}")) {
    System.out.println("Correct format.");
} else {
    System.out.println("Incorrect format.");
}

/*Let's go through the most common characters used in regular expressions.

// Alternation (Vertical Line)
A vertical line indicates that parts of a regular expressions are optional. For
example, 00|111|0000 defines the strings 00, 111 and 0000. The respond method
returnstrue if the string matches any one of the specified group of
alternatives.*/

String string = "00";

if (string.matches("00|111|0000")) {
    System.out.println("The string contained one of the three alternatives");
} else {
    System.out.println("The string contained none of the alternatives");
}
// Sample output
// The string contained one of the three alternatives

/*The regular expression 00|111|0000 demands that the string is exactly it
specifies it to be - there is no "contains" functionality.
*/
String string = "1111";

if (string.matches("00|111|0000")) {
    System.out.println("The string contained one of the three alternatives");
} else {
    System.out.println("The string contained none of the three alternatives");
}
// Sample output
// The string contained none of the three alternatives

/*// Affecting Part of a String (Parentheses)
You can use parentheses to determine which part of a regular expression is
affected by the rules inside the parentheses. Say we want to allow the strings
00000 and 00001. We can do that by placing a vertical bar in between them this
way 00000|00001. Parentheses allow us to limit the option to a specific part of
the string. The expression 0000(0|1) specifies the strings 00000 and 00001.

Similarly, the regular expression car(|s|) defines the singular (car) and
plural (cars) forms of the word car.

// Quantifiers
What is often desired is that a particular sub-string is repeated in a string.
The following expressions are available in regular expressions:*/

// The quantifier * repeats 0 ... times, for example;
String string = "trolololololo";

if (string.matches("trolo(lo)*")) {
    System.out.println("Correct form.");
} else {
    System.out.println("Incorrect form.");
}
// Sample output
// Correct form.

// The quantifier + repeats 1 ... times, for example;
String string = "trolololololo";

if (string.matches("tro(lo)+")) {
    System.out.println("Correct form.");
} else {
    System.out.println("Incorrect form.");
}
// Sample output
// Correct form.

String string = "nananananananana Batmaan!";

if (string.matches("(na)+ Batmaan!")) {
    System.out.println("Correct form.");
} else {
    System.out.println("Incorrect form.");
}
// Sample output
// Correct form.

// The quantifier ? repeats 0 or 1 times, for example:
String string = "You have to accidentally the whole meme";

if (string.matches("You have to accidentally (delete )?the whole meme")) {
    System.out.println("Correct form.");
} else {
    System.out.println("Incorrect form.");
}
// Sample output
// Correct form.

// The quantifier {a} repeats a times, for example:
String string = "1010";

if (string.matches("(10){2}")) {
    System.out.println("Correct form.");
} else {
    System.out.println("Incorrect form.");
}
// Sample output
// Correct form.

// The quantifier {a,b} repeats a ... b times, for example:
String string = "1";

if (string.matches("1{2,4}")) {
    System.out.println("Correct form.");
} else {
    System.out.println("Incorrect form.");
}
// Sample output
// Incorrect form.

// The quantifier {a,} repeats a ... times, for example:
String string = "11111";

if (string.matches("1{2,}")) {
    System.out.println("Correct form.");
} else {
    System.out.println("Incorrect form.");
}
// Sample output
// Correct form.

/*You can use more than one quantifier in a single regular expression. For
example, the regular expression 5{3}(1|0)*5{3} defines strings that begin and
end with three fives. An unlimited number of ones and zeros are allowed in
between.

// Character Classes (Square Brackets)
A character class can be used to specify a set of characters in a compact way.
Characters are enclosed in square brackets, and a range is indicated with a
dash. For example, [145] means (1|4|5) and [2-36-9] means
(2|3|6|7|8|9). Similarly, the entry [a-c]* defines a regular expression that
requires the string to contain only a, b and c.

Almost all programming languages support regular expressions nowadays. The
theory of regular expressions is one of the topics considered in the course
Computational Models (TKT-20005). You can find more regular expressions by
googling regular expressions java, for instance. */