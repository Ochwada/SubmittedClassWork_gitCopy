package org.library;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        // Create a book
        Book book1 = new Book("The Art of Testing", "Jane Doe", 29.99);
        Book book2 = new Book("Effective Java", "Joshua Bloch", 45.50);
        Book book3 = new Book("Clean Code", "Robert C. Martin", 39.95);
        Book book4 = new Book("JUnit 5 in Action", "Sam Brannen", 42.00);
        //Book book5 = new Book("Test-Driven Development", "Kent Beck", 33.33);

        System.out.println(" --- Print book Info. ---");
        System.out.println("Author: " + book1.getAuthor() + ", Title: " + book1.getTitle() + ", Price: €" + book1.getPrice());


        // Create a ShoppingCart
        Library library = new Library();

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(new Book("Test-Driven Development", "Kent Beck", 33.33));

        // Print the number of books in the library
        System.out.println("There are " + library.bookCount() + " books in the library");

        // List all books in the library
        System.out.println();
        library.printAllBooks();


    }
}
