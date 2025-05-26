package org.library;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
/**
 * *******************************************************
 * Package: org.library
 * File: LibraryTest.java
 * Author: Ochwada
 * Date: Monday, 28.Apr.2025, 4:38 PM
 * Description:
 * Objective:
 * *******************************************************
 */

public class LibraryTest {
    private Library library;


    @BeforeAll // JUnit runs this once before any test method in this class.
    static void beforeAllTests(){
        System.out.println("\uD83E\uDDFF Starting Library Test...  ");
    }

    //  Creating a new Library object each time before a test runs
    @BeforeEach
    void setUp() {
        System.out.println("Create a new Library Object");
        library = new Library();
    }

    @AfterEach
    void tearDown(){
        System.out.println("✔\uFE0FTest completed");
    }
    // -----------------------------------------------------

    @Test
    @DisplayName("Library should start empty")
    void testLibraryStartsEmpty() {
        assertEquals(0, library.bookCount());
    }

    @Test
    @DisplayName("Adding books should increase total")
    void testAddingBooks() {
        library.addBook(new Book("Clean Code", "Robert C. Martin", 37.95));
        library.addBook(new Book("The Pragmatic Programmer", "Andy Hunt", 42.00));

        assertEquals(2, library.bookCount());
    }

    @Test
    @DisplayName("Library should calculate total price of books")
    void testCalculateTotalPrice() {
        library.addBook(new Book("Book 1", "Author 1", 15.50));
        library.addBook(new Book("Book 2", "Author 2", 24.50));

        assertEquals(40.00, library.calculateTotalPrice(), 0.001);
    }
}
