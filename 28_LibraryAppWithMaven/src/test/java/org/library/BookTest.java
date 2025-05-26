package org.library;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Modifier;


/**
 * *******************************************************
 * Package: org.library
 * File: BookTest.java
 * Author: Ochwada
 * Date: Monday, 28.Apr.2025, 4:28 PM
 * Description:
 * Objective:
 * *******************************************************
 */

public class BookTest {
    private Book book;

    @BeforeAll // JUnit runs this once before any test method in this class.
    static void beforeAllTests(){
        System.out.println("\uD83E\uDDFF Stating Book test...  ");
    }
    @BeforeEach
    void setUp() {
        System.out.println("Creating new book Object ..");
        book = new Book("Effective Java", "Joshua Bloch", 45.99);
    }

    @AfterEach
    void tearDown(){
        System.out.println("✔\uFE0FTest completed");
    }
    // -----------------------------------------------------

    @Test
    @DisplayName("Book should have correct fields assigned")
    void testBookCreation() {
        assertEquals("Effective Java", book.getTitle());
        assertEquals("Joshua Bloch", book.getAuthor());
        assertEquals(45.99, book.getPrice(), 0.001);
    }

    @Test
    @DisplayName("Book fields must be final")
    void testFieldsAreFinal() throws NoSuchFieldException {
        Class<Book> bookClass = Book.class;

        assertTrue(Modifier.isFinal(bookClass.getDeclaredField("title").getModifiers()));
        assertTrue(Modifier.isFinal(bookClass.getDeclaredField("author").getModifiers()));
        assertTrue(Modifier.isFinal(bookClass.getDeclaredField("price").getModifiers()));
    }

    // -----------------------------------------------------
    @AfterAll
    static void afterAllTests(){
        System.out.println("✅ Book test done");
    }
}
