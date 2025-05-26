package com.restaurant.model;


import java.util.concurrent.Callable;

/**
 * *******************************************************
 * Package: com.restaurant.model
 * File: Order.java
 * Author: Ochwada
 * Date: Friday, 16.May.2025, 2:24 PM
 * <p>
 * Description: Represents a customer's order to be processed by the kitchen
 * This class implements the {@link Callable} interface, allowing it to be submitted to an {@code ExecutorService}
 * for asynchronous processing. When the task completes, it returns a status message
 * indicating the order is ready.
 * <p>
 * Objective:
 * Each thread will simulate cooking a dish
 * *******************************************************
 */


public class Order implements Callable<String> {

    private final String customerName;
    private final String dish;
    private final int prepTime;

    /**
     * Constructs a new {@code Order}.
     *
     * @param customerName the name of the customer placing the order
     * @param dish the name of the dish to be prepared
     * @param prepTime the preparation time in milliseconds
     */
    public Order(String customerName, String dish, int prepTime) {
        this.customerName = customerName;
        this.dish = dish;
        this.prepTime = prepTime;
    }


    /**
     * Simulates the preparation of a dish.
     * <p>
     * This method is executed when the order is processed in a separate thread.
     * It pauses for the specified preparation time using {@code Thread.sleep()},
     * and then returns a message indicating that the dish is ready.
     * </p>
     *
     * @return a status message indicating the completion of the order
     * @throws InterruptedException if the thread is interrupted during preparation
     */
    @Override
    public String call() throws Exception{
        System.out.printf("🧑‍🍳 %s's order for %s is being prepared...%n", customerName, dish);

        Thread.sleep(prepTime);

        return String.format("✅ %s's order for %s is ready!", customerName, dish);

    }

}

