package OOPS.Inheritance;

class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}

class Author extends Book {
    String authorName;
    String bio;

    Author(String title, int publicationYear, String authorName, String bio) {
        super(title, publicationYear);
        this.authorName = authorName;
        this.bio = bio;
    }

    void displayInfo() {
        System.out.println("Title: " + title + " (" + publicationYear + ")");
        System.out.println("Author: " + authorName + ", Bio: " + bio);
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        Author a = new Author("Java Basics", 2022, "John Doe", "Tech writer");
        a.displayInfo();
    }
}
