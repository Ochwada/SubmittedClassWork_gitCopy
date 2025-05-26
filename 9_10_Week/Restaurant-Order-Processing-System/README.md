# 🍽️ **Restaurant Order Processing System**

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
