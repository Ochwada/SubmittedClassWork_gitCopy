package org.supplychain.inventory;

import org.supplychain.exception.*;
import org.supplychain.items.*;

import java.util.*;

/**
 * *******************************************************
 * Package: org.supplychain.inventory
 * File: inventory.java
 * Author: Ochwada
 * Date: Tuesday, 29.Apr.2025, 4:17 PM
 * Description: The {@code Inventory<T>} class models a container for managing  multiple {@code Package<T>} instances. Each package is uniquely identified by a string ID, allowing for efficient storage and retrieval.
 * Objective:  Demonstrate use of Generics with bounded types,  Showcase Java Collections (Map), Handle business logic through custom exceptions
 * *******************************************************
 */

public class Inventory<T> {

    private Map<String, Package<T>> packages;

    /**
     * Constructs an empty inventory.
     */
    public Inventory() {
        this.packages = new HashMap<>();
    }


    /**
     * Adds a package to the inventory.
     *
     * @param packageId The unique identifier for the package.
     * @param pkg       The package to be added to the inventory.
     * @throws InvalidInputException if the package ID is null, or the package is null or empty.
     */
    public void addPackage(String packageId, Package<T> pkg) throws InvalidInputException {
        if (packageId == null || pkg == null || pkg.isEmpty()) {
            throw new InvalidInputException("Invalid inventory input: package must not be null or empty");
        }
        packages.put(packageId, pkg);
    }


    public Package<T> getPackage(String packageId) {
        return packages.get(packageId);
    }
    // -----------------------OTHER CODES--------------

    /**
     * Validates the contents of the specified package.
     * <p>
     * If the package contains any {@code Perishable} item that is expired,
     * an {@code ExpiredProductException} is thrown.
     *
     * @param packageId the ID of the package to validate
     * @throws IllegalArgumentException if the package does not exist
     * @throws ExpiredProductException  if an expired product is found
     */

    public void validatePackage(String packageId) { // It takes a String packageId, the unique identifier of the package to validate.
        Package<T> pkg = packages.get(packageId); // Retrieve the package associated with the given packageId.

        if (pkg == null) {
            throw new IllegalArgumentException("Package ID not found: " + packageId);
        }

        for (T item : pkg.getItem()) {
            if (item instanceof Perishable) { //  If the item is actually a Perishable product (e.g., Milk, Fruits).
                Perishable p = (Perishable) item; // If the item is perishable, cast it to Perishable so  isExpired() method can be called.
                if (p.isExpired()) {
                    throw new ExpiredProductException("Package " + packageId +
                            " contains expired product: " + p.getName());
                }
            }

        }
    }
}
