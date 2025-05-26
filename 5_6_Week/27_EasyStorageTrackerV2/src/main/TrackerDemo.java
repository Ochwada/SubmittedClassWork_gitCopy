package main;


import exception.EmptyStorageException;
import exception.ExpiredItemException;
import model.Snack;
import storage.*;


/**
 * *******************************************************
 * Package: main
 * File: TrackerDemo.java
 * Author: Ochwada
 * Date: Thursday, 24.Apr.2025, 12:40 PM
 * Description: Bring All together
 * Objective:
 * *******************************************************
 */

public class TrackerDemo {
    public static void main(String[] args) {
        StorageUnit<Snack> snackStorage = new StorageUnit<>();

        // Set current day of system (for simulation)
        int today = 12;

        Snack milk = new Snack("Milk", 10); // expired
        Snack chips = new Snack("Chips", 15); // fresh

        // Track events using System.out
        System.out.println("[INFO] Trying to store milk...");

        try {
            StorageUtils.checkPerishable(milk, today); // Throws exception
            snackStorage.addItem(milk);
        } catch (ExpiredItemException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        System.out.println("[INFO] Trying to store chips...");

        try {
            StorageUtils.checkPerishable(chips, today); // Should pass
            snackStorage.addItem(chips);
        } catch (ExpiredItemException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        // Try to get item from storage
        try {
            Snack item = snackStorage.getItem(); // Safe
            System.out.println("[INFO] Got item: " + item);
        } catch (EmptyStorageException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        // Simulate input validation error
        try {
            String userInput = null;
            if (userInput == null || userInput.isEmpty()) {
                throw new IllegalArgumentException("Invalid input! Item name cannot be null or empty.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[WARNING] " + e.getMessage());
        } finally {
            System.out.println("[INFO] Thank you for using EasyStorageTracker!");
        }
    }
}
