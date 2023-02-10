/* PROCESSING FILES */

/*We have already learned some strategies to read text files. If your memories of
the subject are hazy, take a look at the relevant parts of Part 4 of the course
material.

Next, let's take a look at writing data to files. The PrintWriter class offers
the functionality to write to files. The constructor of the PrintWriter class
receives as its parameter a string that represents the location of the target
file.*/

PrintWriter writer = new PrintWriter("file.txt");
writer.println("Hello file!"); //writes the string "Hello file!" and line change to the file
writer.println("More text");
writer.print("And a little extra"); // writes the string "And a little extra" to the file without a line change
writer.close(); //closes the file and ensures that the written text is saved to the file

/*In the example above, we write to the file "file.txt" the string "Hello file!",
followed by a line change and some additional text. Take notice that when
writing to the file the method print does not add line changes, and you have to
add them yourself. In contrast, the method println adds a new line change at
the end of the parameter string it receives.

The constructor of the PrintWriter class might throw an exception that must be
either handled or thrown so that it is the responsibility of the calling
method. Here is what a method that receives as its parameters a file name and
the text contents to write into it could look like.*/

public class Storer {

    public void writeToFile(String fileName, String text) throws Exception {
        PrintWriter writer = new PrintWriter(fileName);
        writer.println(text);
        writer.close();
    }
}

/*In the writeToFile method above we begin by creating a PrintWriter object. It
writes data to the the file that is located at the path that the string
fileName indicates. After this, we write the text to the file by calling the
println method. The possible exception that the constructor throws has to be
handled with a try-catch block or the handling responsibility has to be
transferred elsewhere. In the writeToFile method, the responsibility to handle
the exception is placed on the method that calls writeToFile.

Let's create a main method that calls the writeToFile of a Storer object. There
is nothing to force the main method to handle the exception — it, too, can
state that it might throw an exception by adding throws Exception to the method
definition.*/

public static void main(String[] args) throws Exception {
    Storer storer = new Storer();
    storer.writeToFile("diary.txt", "Dear diary, today was a good day.");
}

/*By calling the method above we create a file called "diary.txt" and write the
text "Dear diary, today was a good day." into it. If the file already exists,
the earlier contents are erased when we store the new text.

It is also possible to handle files in a way that adds the new text after the
existing content. In that case, you might want to use the FileWriter class.*/

// //