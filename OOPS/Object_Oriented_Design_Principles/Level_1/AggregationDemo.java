import java.util.*;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void displayBook() {
        System.out.println("Book: " + title + " by " + author);
    }
}

class Library {
    // Aggregation: Library has Books, but Books can exist without Library
    List<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void showBooks() {
        System.out.println("Library contains:");
        for (Book b : books) {
            b.displayBook();
        }
    }
}

public class AggregationDemo {
    public static void main(String[] args) {
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("The Hobbit", "J.R.R. Tolkien");

        Library lib = new Library();
        lib.addBook(b1);
        lib.addBook(b2);

        lib.showBooks();
    }
}
