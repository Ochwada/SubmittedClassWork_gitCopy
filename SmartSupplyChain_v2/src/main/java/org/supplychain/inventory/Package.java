package org.supplychain.inventory;

import org.supplychain.exception.InvalidInputException;

import java.util.*;

/**
 * *******************************************************
 * Package: org.supplychain.inventory
 * File: Package.java
 * Author: Ochwada
 * Date: Tuesday, 29.Apr.2025, 4:09 PM
 * Description:
 * The {@code Package<T>} class represents a container that groups multiple items of type {@code T}.
 * It is part of the inventory module in SmartSupplyChain and  is used to handle grouped product handling.
 * Objective:
 * - Demonstrate usage of Java Generics.
 * - Model real-world packaging in logistics.
 * - Support type-safe item grouping (e.g., Electronics, Documents).
 *
 * @param <T> the type of item this package holds
 *            *******************************************************
 */

public class Package<T> {

    // Internal list that holds the contents of the package
    private List<T> contents;

    /**
     * Constructs an empty package.
     * Initializes the contents list to store items of type T.
     */
    public Package() {
        this.contents = new ArrayList<>();
    }

    /**
     * Adds a non-null item to the package.
     *
     * @param item The item to be added.
     * @throws InvalidInputException if the item is null.
     */
    public void addItem(T item) throws InvalidInputException {
        if (item == null) {
            throw new InvalidInputException("Null item in the package");
        }
        contents.add(item);
    }

    /**
     * Returns an unmodifiable view of the contents in the package.
     * This ensures that the caller cannot modify the internal list directly.
     *
     * @return A read-only list of the package's contents.
     */
    public List<T> getItem() {
        return Collections.unmodifiableList(contents);
    }

    /**
     * Checks whether the package is empty.
     *
     * @return true if the package contains no items; false otherwise.
     */
    public boolean isEmpty() {
        return contents.isEmpty();
    }
}
