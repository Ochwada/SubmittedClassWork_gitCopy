package model;


/**
 * *******************************************************
 * Package: model
 * File: Snack.java
 * Author: Ochwada
 * Date: Thursday, 24.Apr.2025, 12:34 PM
 * Description: Snack (a Perishable)
 * Objective:
 * *******************************************************
 */

public class Snack extends Perishable{
    private String name;

    public Snack(String name, int expirationDay) {
        super(expirationDay);
        this.name = name;
    }

    public String toString() {
        return "Snack: " + name + " (expires on day " + getExpirationDay() + ")";
    }
}
