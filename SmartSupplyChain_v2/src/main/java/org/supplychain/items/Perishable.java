package org.supplychain.items;


import org.supplychain.exception.ExpiredProductException;

import java.time.LocalDate;

/**
 * *******************************************************
 * Package: org.supplychain.items
 * File: Perishable.java
 * Author: Ochwada
 * Date: Monday, 28.Apr.2025, 5:24 PM
 * Description: Represents a perishable product that has an expiration day.
 * Inherits from the abstract Product class and implements the required getType() method.
 * Objective:
 * *******************************************************
 */

public class Perishable extends Product {

    private int expirationDay; // Day of the year (1–365 or 1–366) when the product expires


    /**
     * Constructor to create a perishable product with an ID, name, and expiration day.
     *
     * @param id            Unique identifier for the product.
     * @param name          Name of the product.
     * @param expirationDay The day of the year the product expires.
     */
    public Perishable(String id, String name, int expirationDay) {
        super(id, name);
        this.expirationDay = expirationDay;
    }


    /**
     * Returns the type of this product.
     *
     * @return A string representing the product type: "Perishable".
     */
    @Override
    public String getType() {
        return "Perishable";
    }


    // ---------- Expiration Day Logic ----------

    /**
     * Checks whether the product has expired based on the current day of the year.
     *
     * @return true if the product is expired; false otherwise.
     */
    public boolean isExpired() {
        int today = LocalDate.now().getDayOfYear(); //Day of the Year
        return today > getExpirationDay();
    }

    /**
     * Validates the expiration status of the product.
     * Throws an ExpiredProductException if the product is expired.
     */
    public void validateExpiration() {
        if (isExpired()) {
            throw new ExpiredProductException("Product expired: " + toString());
        }

    }
    // --------------------------------

    // --- Getter and Setter ---

    /**
     * Returns the expiration day of the product.
     *
     * @return An integer representing the day of the year the product expires.
     */
    public int getExpirationDay() {
        return expirationDay;
    }

//    public void setExpirationDay(int expirationDay) {
//        this.expirationDay = expirationDay;
//    }

    /**
     * Returns a human-readable string representation of the product,
     * including its name and expiration day.
     *
     * @return A formatted string with product details.
     */
    @Override
    public String toString() {
        return getName() + " (Expires on day " + expirationDay + ")";
    }

}
