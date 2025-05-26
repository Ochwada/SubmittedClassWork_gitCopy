package org.supplychain.people;


import org.supplychain.exception.InvalidInputException;

/**
 * *******************************************************
 * Package: org.supplychain.people
 * File: Person.java
 * Author: Ochwada
 * Date: Friday, 02.May.2025, 3:23 PM
 * Description:An abstract representation of a person with a validated name.
 * This class serves as a base for specific person types that must implement their own interaction behavior.
 * Objective:
 * *******************************************************
 */

public abstract class Person {

    protected String name;

    /**
     * Constructs a new Person with the given name.
     *
     * @param name The name of the person. Must not be null or empty.
     * @throws InvalidInputException if the name is null or an empty string.
     */
    public Person(String name) throws InvalidInputException {
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Name is Invalid or NULL");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Abstract method to define how the person interacts.
     * <p>
     * Subclasses must implement this to provide specific behavior.
     * </p>
     */
    public abstract void interact();
}
