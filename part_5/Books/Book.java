public class Book {
 
    private String name;
    private int publicationYear;
 
    public Book(String name, int publicationYear) {
        this.name = name;
        this.publicationYear = publicationYear;
    }
 
    public String getName() {
        return name;
    }
 
    public int getPublicationYear() {
        return publicationYear;
    }
 
    public boolean equals(Object compared) {
        // same memory address
        if (this == compared) {
            return true;
        }
 
        // same object type?
        if (!(compared instanceof Book)) {
            return false;
        }
 
        // convert Object to Book object
        Book comparedBook = (Book) compared;
 
        return this.name.equals(comparedBook.name) && this.publicationYear == comparedBook.publicationYear;
    }
 
}