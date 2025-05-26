package org.supplychain.people;


import org.supplychain.exception.InvalidInputException;
import org.supplychain.inventory.Package;

/**
 * *******************************************************
 * Package: org.supplychain.people
 * File: Customer.java
 * Author: Ochwada
 * Date: Friday, 02.May.2025, 3:44 PM
 * Description: Represents a customer who can receive and interact with packages.
 *              This class extends {@link Person} and implements specific behavior
 *              for receiving and inspecting packages.
 * Objective:
 * *******************************************************
 */

public class Customer extends Person{


    /**
     * Constructs a new Customer with the given name.
     *
     * @param name The name of the customer.
     * @throws InvalidInputException if the name is null or empty.
     */
    public Customer(String name) throws InvalidInputException {
        super(name);
    }

    /**
     * Simulates the customer receiving a package.
     * Prints out the number of items in the received package.
     *
     * @param pack The package being received. Can contain any type of items.
     */
    public void receivePackage(Package<?> pack) {
        System.out.println(name + " received package with " + pack.getItem().size() + " item(s)");
    }

    /**
     * Defines how the customer interacts.
     * Prints a message indicating that the customer is receiving and inspecting a package.
     */
    @Override
    public void interact() {
        System.out.println(name + " is receiving and inspecting package");
    }
}
