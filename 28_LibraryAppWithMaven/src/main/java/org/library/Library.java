package org.library;


import java.util.*;

/**
 * *******************************************************
 * Package: org.library
 * File: Library.java
 * Author: Ochwada
 * Date: Monday, 28.Apr.2025, 2:52 PM
 * Description:
 * Objective:
 * *******************************************************
 */

public class Library {

    private final List<Book> books; //= new ArrayList<>();

    // Default constructor to initialize the books List as new ArrayList<>()
    public Library(){
        this.books = new ArrayList<>();
    }

    // Add book method
    public void addBook(Book book){
        books.add(book);
    }

    // method to get Number of books (the size of th Library)
    public int bookCount(){
        return books.size();
    }

    // Total Price method
    public double calculateTotalPrice(){
        double totalPrice = 0.0;
        for(Book book: this.books){
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }

    // get all books method: new reference to avoid interference
    public void printAllBooks(){
        System.out.println("\uD83D\uDCC3--- Available Books ---\uD83D\uDCC3 ");
        for (Book book : books){
            int index = books.indexOf(book);
            System.out.println((index+ 1) +". "+ book.getTitle());
        }
    }

}
