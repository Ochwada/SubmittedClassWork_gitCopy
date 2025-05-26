package exception;


/**
 * *******************************************************
 * Package: exception
 * File: ExpiredItemException.java
 * Author: Ochwada
 * Date: Thursday, 24.Apr.2025, 12:36 PM
 * Description: Custom Exception for Expired Items
 * Objective: Custom Exception
 *          When is it thrown? → When someone tries to store or validate an expired perishable item.
 * *******************************************************
 */

public class ExpiredItemException extends Exception {
    public ExpiredItemException(String message) {
        super(message);
    }
}
