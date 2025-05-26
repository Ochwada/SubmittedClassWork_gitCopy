package org.supplychain.exception;


/**
 * *******************************************************
 * Package: org.supplychain.exception
 * File: InvalidInputException.java
 * Author: Ochwada
 * Date: Tuesday, 29.Apr.2025, 3:02 PM
 * Description: Custom unchecked exception used to handle cases where a null or invalid item
 *              is passed to a method or constructor that requires a non-null value.
 * Objective: To demonstrate the use of custom exceptions in Java for input validation,
 *             and to improve code robustness by providing meaningful error messages
 *             when null or invalid data is encountered.
 * -
 * Example usage:
 *  {@code
 *    if (item == null) {
 *         throw new InvalidInputException("Item cannot be null.");
 *     }
 *   }
 * *******************************************************
 */

public class InvalidInputException extends RuntimeException {

    /**
     * Constructs a new InvalidInputException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public InvalidInputException(String message) {
        super(message);
    }
}
