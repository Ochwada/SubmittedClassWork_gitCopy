package org.supplychain.exception;


/**
 * *******************************************************
 * Package: org.supplychain.exception
 * File: EmptyStorageException.java
 * Author: Ochwada
 * Date: Tuesday, 29.Apr.2025, 3:01 PM
 * Description: Custom unchecked exception used to handle scenarios where an operation is attempted on an empty storage
 *              unit (e.g., retrieving or removing an item when none exist).
 * Objective: To demonstrate robust exception handling in Java by using a custom exception to catch and report logic
 *             errors related to empty storage access. This improves code safety and clarity when working with collections or containers.
 *Example usage:
 * {@code
 *     if (storageUnit.isEmpty()) {
 *         throw new EmptyStorageException("Storage is empty.");
 *     }
 *  }
 * *******************************************************
 */

public class EmptyStorageException extends RuntimeException {
    /**
     * Constructs a new EmptyStorageException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */

    public EmptyStorageException(String message) {
        super(message);
    }
}
