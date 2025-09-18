package ThisStaticFinalKeywords;

public class Book {
    static String libraryName = "City Library";
    final String isbn;
    String title, author;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println(libraryName);
    }

    void displayDetails() {
        if (this instanceof Book) {
            System.out.println(title + " " + author + " " + isbn);
        }
    }

    public static void main(String[] args) {
        Book b = new Book("Java", "James Gosling", "978123");
        displayLibraryName();
        b.displayDetails();
    }
}
