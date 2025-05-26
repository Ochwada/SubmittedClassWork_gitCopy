# 🍽️ **Assignment: Restaurant Order Processing System**

## 🎯 Problem Background

In a busy restaurant, multiple customers place food orders simultaneously. Each order takes some time to prepare, and kitchen staff (threads) work in parallel to fulfill these orders. The restaurant must:

* Handle multiple orders concurrently
* Track which order is complete (and when)
* Ensure shared resources (like stock or kitchen equipment) are not overused (e.g., oven/microwave)

---

## 🧠 Algorithmic Thinking (What, Why, How)

| Step | What?                        | Why?                                     | How?                                                     |
| ---- | ---------------------------- | ---------------------------------------- | -------------------------------------------------------- |
| 1.   | Model an order               | Each thread will simulate cooking a dish | Create a `Callable<String>` to return completion message |
| 2.   | Run tasks concurrently       | To simulate multiple dishes being cooked | Use `ExecutorService` with a fixed thread pool           |
| 3.   | Track task completion        | To notify when each order is ready       | Use `Future<String>` and print result when done          |
| 4.   | Synchronize shared equipment | Prevent clashes (e.g. only 1 oven)       | Use `synchronized` or `Semaphore` (optional challenge)   |

---

## 📦 Steps + Starter Code

### 1️⃣ `Order.java` – Represents a food order

```java
package com.example.restaurant;

import java.util.concurrent.Callable;

/**
 * Represents a customer order to be processed by a kitchen thread.
 * Implements Callable so it can return a result when done.
 */
public class Order implements Callable<String> {

    private final String customerName;
    private final String dish;
    private final int prepTime;

    /**
     * Constructs a new Order.
     *
     * @param customerName The name of the customer
     * @param dish The name of the dish to prepare
     * @param prepTime Time to simulate cooking (in milliseconds)
     */
    public Order(String customerName, String dish, int prepTime) {
        this.customerName = customerName;
        this.dish = dish;
        this.prepTime = prepTime;
    }

    /**
     * The call method simulates cooking the dish.
     * It's like the thread's 'run' method but returns a value.
     */
    @Override
    public String call() throws Exception {
        System.out.printf("🧑‍🍳 %s's order for %s is being prepared...%n", customerName, dish);

        // TODO: Simulate time taken to prepare the dish
        Thread.sleep(prepTime);

        return String.format("✅ %s's order for %s is ready!", customerName, dish);
    }
}
```

---

### 2️⃣ `RestaurantApp.java` – Main runner with ExecutorService

```java
package com.example.restaurant;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * RestaurantApp simulates a kitchen processing multiple orders in parallel
 * using a thread pool.
 */
public class RestaurantApp {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService kitchen = Executors.newFixedThreadPool(3); // Max 3 chefs

        // TODO: List of orders to be prepared
        List<Order> orders = Arrays.asList(
            new Order("Alice", "Pizza", 2000),
            new Order("Bob", "Pasta", 1500),
            new Order("Charlie", "Burger", 2500),
            new Order("Diana", "Salad", 1000),
            new Order("Eli", "Steak", 3000)
        );

        // TODO: Submit all orders to kitchen
        List<Future<String>> results = kitchen.invokeAll(orders);

        System.out.println("🍽️ Waiting for all orders to be ready...\n");

        // TODO: Wait for each result and print when done
        for (Future<String> result : results) {
            try {
                System.out.println(result.get());
            } catch (ExecutionException e) {
                System.err.println("❌ An order failed: " + e.getCause().getMessage());
            }
        }

        kitchen.shutdown();
        System.out.println("\n👨‍🍳 Kitchen is closed.");
    }
}
```

---

## 📄 Summary

| Concept Used        | Demonstrated By                              |
| ------------------- | -------------------------------------------- |
| Callable            | `Order` returning the result of cooking      |
| ExecutorService     | Thread pool in `RestaurantApp`               |
| Future              | Track and retrieve cooking result            |
| synchronized / lock | Control access to a shared kitchen equipment |
| Timeout & Exception | `Future.get()` with error handling           |

---

## 📌 Tasks for Students

> Read this assignment and ask question 💡


