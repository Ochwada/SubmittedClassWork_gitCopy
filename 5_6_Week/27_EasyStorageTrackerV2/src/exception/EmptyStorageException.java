package exception;


/**
 * *******************************************************
 * Package: exception
 * File: EmptyStorageException.java
 * Author: Ochwada
 * Date: Thursday, 24.Apr.2025, 12:29 PM
 * Description: Custom Exception – EmptyStorageException
 * Objective: Working with Exceptions
 *          When is it thrown? → When someone tries to get an item, but nothing is stored.
 * *******************************************************
 */

public class EmptyStorageException extends Exception {
    public EmptyStorageException(String message) {
        super(message);
    }
}
