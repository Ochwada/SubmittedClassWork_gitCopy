package org.supplychain.system;


import org.supplychain.exception.InvalidInputException;
import org.supplychain.items.Perishable;

import java.util.ArrayList;
import java.util.List;

/**
 * *******************************************************
 * Package: org.supplychain.system
 * File: SupplyChainUtils.java
 * Author: Ochwada
 * Date: Friday, 02.May.2025, 3:50 PM
 * Description: A utility class providing generic operations for supply chain management,
 *              such as displaying items and filtering expired perishables.
 * Objective:
 * *******************************************************
 */

public class SupplyChainUtils {


    /**
     * Displays a single item by printing it to the console.
     *
     * @param item The item to display. Can be of any type.
     * @param <T>  The type of the item.
     */
    public static <T> void displayItem(T item){
        System.out.println("Item: "+  item);
    }


    /**
     * Filters and returns a list of perishable items that are expired.
     * <p>
     * This method iterates through the given list and adds items to the result
     * if their {@code isExpired()} method returns true.
     * </p>
     *
     * @param items A list of items that are instances of {@code Perishable} or its subclasses.
     * @return A list of expired perishable items.
     */
    public static List<Perishable> getExpired(List<? extends Perishable> items){
        List<Perishable> expiredItems  = new ArrayList<>();

        for(Perishable item: items){
            if(item.isExpired()){
                expiredItems.add(item);
            }
        }
        return  expiredItems;
    }

    /**
     * Validates that a given string input is not null or empty.
     * <p>
     * This method is typically used to enforce basic input integrity checks
     * before storing or processing string values.
     * </p>
     *
     * @param value The string value to validate.
     * @throws InvalidInputException if the input is null or an empty string.
     */
    public static void validateInput(String value) throws InvalidInputException {
        if (value == null ||  value.isEmpty()) throw new InvalidInputException("Invalid Input");
    }
}
