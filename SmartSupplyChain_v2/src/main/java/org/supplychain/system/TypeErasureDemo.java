package org.supplychain.system;


import org.supplychain.inventory.StorageUnit;
import org.supplychain.items.Document;
import org.supplychain.items.Electronic;

/**
 * *******************************************************
 * Package: org.supplychain.system
 * File: TypeErasureDemo.java
 * Author: Ochwada
 * Date: Friday, 02.May.2025, 4:07 PM
 * Description:Demonstrates type erasure in Java by using StorageUnit with different generic types.
 *             It also uses reflection to confirm that both instances share the same runtime class.
 * Objective:
 * *******************************************************
 */

public class TypeErasureDemo {

    /**
     * Runs the type erasure demonstration.
     * <p>
     * Steps:
     * <ol>
     *   <li>Creates {@code StorageUnit<Electronic>} and {@code StorageUnit<Document>} instances.</li>
     *   <li>Adds sample items to each storage unit.</li>
     *   <li>Prints the contents of each unit.</li>
     *   <li>Uses reflection to confirm that both instances share the same class at runtime.</li>
     * </ol>
     * </p>
     * Any exceptions encountered are caught and printed to standard error.
     */

    public static void runDemo() {
        try {
            // Step 1: Create generic StorageUnits
            StorageUnit<Electronic> electronicsUnit = new StorageUnit<>();
            StorageUnit<Document> documentsUnit = new StorageUnit<>();

            electronicsUnit.addItem(new Electronic("xxx", "Smartphone"));
            documentsUnit.addItem(new Document("xx1", "Report.pdf"));

            // Step 2: Print contents
            System.out.println(electronicsUnit);
            System.out.println(documentsUnit);

            // Step 3: Use reflection to demonstrate type erasure
            Class<?> electronicsClass = electronicsUnit.getClass();
            Class<?> documentsClass = documentsUnit.getClass();

            System.out.println("\nReflection:");
            System.out.println("Class of electronicsUnit: " + electronicsClass.getName());
            System.out.println("Class of documentsUnit:  " + documentsClass.getName());

            if (electronicsClass.equals(documentsClass)) {
                System.out.println("→ Type erasure confirmed: Both are " + electronicsClass.getSimpleName() + " at runtime.");
            }

        } catch (Exception e) {
            System.err.println("An error occurred during the demo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Optional entry point to execute the demo directly.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        runDemo();
    }

}

