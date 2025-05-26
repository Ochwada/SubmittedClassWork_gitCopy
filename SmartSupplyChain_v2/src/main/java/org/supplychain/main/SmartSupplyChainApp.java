package org.supplychain.main;


import org.supplychain.exception.*;
import org.supplychain.inventory.*;
import org.supplychain.inventory.Package;
import org.supplychain.items.*;

/**
 * *******************************************************
 * Package: org.supplychain.main
 * File: SmartSupplyChainApp.java
 * Author: Ochwada
 * Date: Monday, 28.Apr.2025, 5:20 PM
 * Description:
 * Objective:
 * *******************************************************
 */

public class SmartSupplyChainApp {
    public static void main(String[] args) {
        System.out.println("\uD83C\uDF9F️ === Welcome to Our Smart Supply Chain === \uD83C\uDF9F");

        try {
            /*

            // --- 3. Packages and Inventory
            System.out.println("\n📦 Packages and Inventory 📦");

            // Create packages
            Package<Perishable> perishablePkg = new Package<>();
            Package<Document> documentPkg = new Package<>();

            perishablePkg.addItem(new Perishable("PKG1", "Milk", 200));
            perishablePkg.addItem(new Perishable("PKG1", "Cheese", 290));
            documentPkg.addItem(new Document("PKG2", "Notebook"));
            documentPkg.addItem(new Document("PKG2", "Manual"));

            // Create inventories
            Inventory<Perishable> inventoryPer = new Inventory<>();
            Inventory<Document> inventoryDoc = new Inventory<>();

            String perishablePkgId = "PKG1";
            String documentPkgId = "PKG2";


            // Add package to inventory
            inventoryPer.addPackage(perishablePkgId, perishablePkg);
            inventoryDoc.addPackage(documentPkgId, documentPkg);

            // Validate: should throw ExpiredProductException
            inventoryPer.validatePackage(perishablePkgId);

            System.out.println("\n\uD83D\uDD38 Perishable Package Contents:");
            perishablePkg.getItems().forEach(System.out::println);
            System.out.println("\n\uD83D\uDD38 Document Package Contents:");
            documentPkg.getItems().forEach(System.out::println);
            // -----------------------------------------------------
            // -----------------------------------------------------

            // --- 2. Generic Storage Units

            System.out.println("\n\uD83D\uDC8E Generic Storage Units \uD83D\uDC8E");
            StorageUnit<String> docBox = new StorageUnit<>("How to Print in Java");
            StorageUnit<Integer> idBox = new StorageUnit<>(2);
            StorageUnit<String> unit = new StorageUnit<>("Book");
            System.out.println("Single Items");
            System.out.println("🔸" + unit.getItem());
            System.out.println("🔸" + docBox.getItem());
            System.out.println("🔸" + idBox.getItem());

            // --- Multi-Storage Unit
            MultiStorageUnit<String> names = new MultiStorageUnit<>();
            names.addItem("Milk");
            names.addItem("Phone");
            names.addItem("Book");

            if (names.getItems().isEmpty()) {
                throw new EmptyStorageException("MultiStorageUnit is empty.");
            }

            System.out.println(names);
            // -----------------------------------------------------
            // -----------------------------------------------------
            // 1. --- Model Products
            Product doc1 = new Document("DOC1", "Book");
            Product ele1 = new Electronic("ELE1", "Phone");
            Perishable per1 = new Perishable("PER1", "Milk", 344); // less than today - false

            System.out.println("\uD83D\uDCA0 Model Product \uD83D\uDCA0");
            System.out.println("Type: " + doc1.getType() + ", Name: " + doc1.getName());
            System.out.print("Type: " + per1.getType() + ", Name: " + per1.getName() + ", ");

            // This will throw ExpiredProductException if expired
            System.out.println("Expired? " + per1.isExpired());

            // -----------------------------------------------------
            // -----------------------------------------------------
       */

        } catch (InvalidInputException | EmptyStorageException | ExpiredProductException e) {
            System.out.println("❗ Error: " + e.getMessage());
        }
    }
}
