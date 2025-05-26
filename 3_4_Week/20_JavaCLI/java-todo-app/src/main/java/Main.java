import com.example.todo.TaskManager;
/****************************************************
 * Main.java 
 * Author: Ochwada
 * Date: Friday, 11.Apr.2025, 12:25 hrs
 * Description: 
 * Objective:
 ***************************************************/


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to Java To-Do App!");

        while (true) {
            System.out.println("\nOptions: add | list | complete | exit");
            System.out.print("Choose an action: ");
            input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "add":
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    taskManager.addTask(title);
                    break;
                case "list":
                    taskManager.listTasks();
                    break;
                case "complete":
                    System.out.print("Enter task number to complete: ");
                    int number = Integer.parseInt(scanner.nextLine());
                    taskManager.completeTask(number);
                    break;
                case "exit":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}