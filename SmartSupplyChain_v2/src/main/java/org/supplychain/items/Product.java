package org.supplychain.items;


/**
 * *********************,**********************************
 * Package: org.supplychain
 * File: Product.java
 * Author: Ochwada
 * Date: Monday, 28.Apr.2025, 5:14 PM
 * Description: An abstract class representing a generic product with a unique ID and name.
 * Subclasses must define the product type via the abstract getType() method.
 * Objective:
 * *******************************************************
 */

public abstract class Product {
    protected String id; // Unique identifier for the product
    protected String name;  // Name or title of the product


    /**
     * Constructor to initialize the product's ID and name.
     *
     * @param id   The internal ID of the product (without prefix).
     * @param name The name of the product.
     */
    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Abstract method that must be implemented by subclasses
     * to return the specific type of the product.
     *
     * @return A string representing the product type.
     */
    public abstract String getType();

    /**
     * Returns the name of the product.
     *
     * @return The product's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the product ID prefixed with "PRO-".
     *
     * @return A formatted product ID.
     */
    public String getId() {
        return "PRO-" + id;
    }


    /**
     * Returns a string representation of the product,
     * including its raw ID and name.
     *
     * @return A string describing the product.
     */
    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
