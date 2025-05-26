package org.supplychain.people;


import org.supplychain.exception.*;
import org.supplychain.inventory.Package;
import org.supplychain.items.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * *******************************************************
 * Package: org.supplychain.people
 * File: Supplier.java
 * Author: Ochwada
 * Date: Friday, 02.May.2025, 3:31 PM
 * Description:Represents a supplier who holds and manages packages of products.
 *             The supplier is a type of {@link Person} and is responsible for storing and preparing product packages for delivery.
 * Objective:
 * *******************************************************
 */

public class Supplier extends Person {

    /**
     * A list of packages containing various types of products.
     * <p>
     * Each package in the list can contain items of any subclass of {@code Product},
     * such as {@code Book}, {@code Perishable}, or any other valid product type.
     * This allows the inventory to store heterogeneous packages while ensuring that
     * all contained items are at least of type {@code Product}.
     * </p>
     *
     * <p>
     * Note: This list is read-safe (you can retrieve packages and safely assume they
     * contain {@code Product}s), but write-restricted due to the use of the wildcard.
     * You cannot add a {@code Package<Product>} directly unless it matches the exact wildcard type.
     * </p>
     */
    private List<Package<? extends Product>> packages;

    /**
     * Constructs a new Supplier with the given name.
     *
     * @param name The name of the supplier.
     * @throws InvalidInputException if the name is null or empty.
     */
    public Supplier(String name) throws InvalidInputException {
        super(name);

        this.packages = new ArrayList<>();
    }

    /**
     * Adds a package containing products to the supplier's inventory.
     *
     * @param pack The package to be added. Must contain a subtype of {@code Product}.
     */
    public void addPackage(Package<? extends Product> pack) {
        packages.add(pack);
    }

    /**
     * Returns an unmodifiable list of all packages held by the supplier.
     * <p>
     * This protects the internal state from being modified externally.
     * </p>
     *
     * @return A read-only list of packages.
     */
    public List<Package<? extends Product>> getPackages() {
        return Collections.unmodifiableList(packages);
    }

    /**
     * Defines the specific interaction behavior of a supplier.
     * Prints a message indicating the supplier is preparing packages for delivery.
     */
    @Override
    public void interact() {
        System.out.println(name + " is preparing packages for delivery... ");
    }
}
