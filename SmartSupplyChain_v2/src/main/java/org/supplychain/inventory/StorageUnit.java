package org.supplychain.inventory;


import org.supplychain.exception.EmptyStorageException;
import org.supplychain.exception.InvalidInputException;

/**
 * *******************************************************
 * Package: org.supplychain.inventory
 * File: StorageUnit.java
 * Author: Ochwada
 * Date: Tuesday, 29.Apr.2025, 2:15 PM
 * Description: A generic class called {@code StorageUnit<T>} that can hold one item of any type {@code T}.
 * Objective: To demonstrate the use of Java Generics by creating a flexible and type-safe container
 * that stores a single item, regardless of its data type.
 *
 * @param <T> The type of the item to be stored.
 *            *******************************************************
 */

public class StorageUnit<T> {

    private T item;


//    /**
//     * Constructs a StorageUnit with the specified item.
//     *
//     * @param item The item to store.
//     */
//    public StorageUnit(T item) {
//        this.item = item;
//    }


    /**
     * Adds an item to the storage unit.
     * Throws an exception if the input item is null to prevent invalid storage state.
     *
     * @param item The item to be stored.
     * @throws InvalidInputException if the provided item is null.
     */
    public void addItem(T item) throws InvalidInputException {
        if (item == null) throw new InvalidInputException("Cannot store null item");

        this.item = item;
    }


    /**
     * Retrieves the item currently stored in the unit.
     *
     * @return The stored item.
     * @throws EmptyStorageException if the storage is empty (i.e., no item is stored).
     */
    public T getItem() throws EmptyStorageException {
        if (item == null) throw new EmptyStorageException("Storage is empty");

        return item;
    }

//    public void setItem(T item) {
//        this.item = item;
//    }


    /**
     * Returns a string representation of the StorageUnit and its contents.
     *
     * @return A string describing the stored item.
     */
    @Override
    public String toString() {
        return "StorageUnit contains: " + item;
    }
}
