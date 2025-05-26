package com.restaurant.main;


import com.restaurant.model.Order;

import java.util.*;
import java.util.concurrent.*;

/**
 * *******************************************************
 * Package: com.restaurant.main
 * File: RestaurantApp.java
 * Author: Ochwada
 * Date: Friday, 16.May.2025, 2:25 PM
 * <p>
 * Description:
 * RestaurantApp simulates a kitchen processing multiple orders in parallel using a thread pool.
 * Objective:
 * <p>
 * *******************************************************
 */


public class RestaurantApp {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService kitchen = Executors.newFixedThreadPool(3); // Max 3 chefs

        // List of orders to be prepared
        List<Order> orders = Arrays.asList(
                new Order("Alice", "Pizza", 2000),
                new Order("Bob", "Pasta", 1500),
                new Order("Charlie", "Burger", 2500),
                new Order("Diana", "Salad", 1000),
                new Order("Eli", "Steak", 3000)
        );

        // Submit all orders to kitchen
        List<Future<String>> results = kitchen.invokeAll(orders);

        System.out.println("🍽️ Waiting for all orders to be ready...\n");

        //  Wait for each result and print when done
        for (Future<String> result : results) {
            try {

                // Blocks until the corresponding order (Callable) is complete
                System.out.println(result.get());
            } catch (ExecutionException e) {

                // Handles any exceptions thrown inside the Callable
                System.err.println("❌ An order failed: " + e.getCause().getMessage());
            }
        }

        kitchen.shutdown();
        System.out.println("\n👨‍🍳 Kitchen is closed.");

    }
}
