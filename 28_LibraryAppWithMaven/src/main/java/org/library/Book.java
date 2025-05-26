package org.library;


/**
 * *******************************************************
 * Package: org.library
 * File: Book.java
 * Author: Ochwada
 * Date: Monday, 28.Apr.2025, 2:48 PM
 * Description:
 * Objective:
 * *******************************************************
 */

public class Book {
    private final String title;
    private final String author;
    private final double price;


    public Book(String title, String author, double price){
        this.author = author;
        this.title = title;
        this.price = price;
    }

    // Getters

    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }
    public double getPrice(){
        return price;
    }

}
