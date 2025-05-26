package org.supplychain.inventory;


import org.supplychain.exception.EmptyStorageException;
import org.supplychain.exception.InvalidInputException;

import java.util.*;


/**
 * *******************************************************
 * Package: org.supplychain.inventory
 * File: MultiStorageUnit.java
 * Author: Ochwada
 * Date: Tuesday, 29.Apr.2025, 2:49 PM
 * Description: A generic class called {@code MultiStorageUnit<T>} that can hold multiple items of any type {@code T}
 * using a {@code List<T>}.
 * Objective: To demonstrate the use of generics and collections in Java by storing and managing a dynamic list
 * of items of any specified type.
 *
 * @param <T> The type of items to be stored.
 *            *******************************************************
 */

public class MultiStorageUnit<T> {

    private List<T> items;

    // Constructs an empty MultiStorageUnit.
    public MultiStorageUnit() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a non-null item to the storage collection.
     * <p>
     * Ensures data integrity by rejecting null values.
     * </p>
     *
     * @param item The item to add to the storage.
     * @throws InvalidInputException if the provided item is null.
     */
    public void addItem(T item) throws InvalidInputException {
        if (item == null) throw new InvalidInputException("Cannot store null item");

        items.add(item);
    }

    /**
     * Retrieves all stored items as an unmodifiable list.
     * <p>
     * This method ensures that the storage is not empty before returning the items.
     * The returned list is read-only to prevent external modification of the internal data.
     * </p>
     *
     * @return An unmodifiable list of stored items.
     * @throws EmptyStorageException if the storage contains no items.
     */
    public List<T> getItems() throws EmptyStorageException {
        // option 1
        //return new ArrayList<>(); // creating new reference in returns

        // option 2

        if (items.isEmpty()) throw new EmptyStorageException("Storage is empty");
        return Collections.unmodifiableList(items); // Prevents external modifications

    }

    /**
     * Returns the number of items currently stored.
     *
     * @return The number of items.
     */
    public int size() {
        return items.size();
    }

    /**
     * Returns a string representation of the MultiStorageUnit and its contents.
     *
     * @return A string describing the stored items.
     */
    @Override
    public String toString() {
        return "MultiStorageUnit contains: " + items;
    }


}
