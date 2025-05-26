package storage;


import exception.ExpiredItemException;
import model.Perishable;

import java.util.List;

/**
 * *******************************************************
 * Package: storage
 * File: StorageUtils.java
 * Author: Ochwada
 * Date: Thursday, 24.Apr.2025, 12:38 PM
 * Description: Utility Methods with Exception Handling
 * Objective: Working with Utility Methods with Exception Handling
 * *******************************************************
 */

public class StorageUtils {// Wildcard method

 public static void printItems(List<? extends Object> items) {
  for (Object item : items) {
   System.out.println("Stored item: " + item);
  }
 }

 // Generic method
 public static <T> void displayItem(T item) {
  System.out.println("Displaying item: " + item);
 }

 // Bounded type method with exception
 public static <T extends Perishable> void checkPerishable(T item, int currentDay) throws ExpiredItemException {
  if (item.isExpired(currentDay)) {
   throw new ExpiredItemException("This item is expired and cannot be stored.");
  }
 }

}
