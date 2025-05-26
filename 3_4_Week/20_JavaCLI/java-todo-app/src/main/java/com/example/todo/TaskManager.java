package com.example.todo;

/****************************************************
 * TaskManager.java 
 * Author: Ochwada
 * Date: Friday, 11.Apr.2025, 12:25 hrs
 * Description: 
 * Objective:
 ***************************************************/

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(String title) {
        Task task = new Task(title);
        tasks.add(task);
        System.out.println("Added: " + title);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Your Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, tasks.get(i));
        }
    }

    public void completeTask(int index) {
        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.get(index - 1).markDone();
        System.out.println("Task marked as complete.");
    }
}