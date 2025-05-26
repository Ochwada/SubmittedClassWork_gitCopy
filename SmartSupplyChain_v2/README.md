# 🚚 SmartSupplyChain-v2


## 🎯 Objective 
Master core Java concepts including  **Generics**, **OOP**, **Collections**, **Maven**, and **JUnit 5**

> Real-World Systems Engineering, the Modern Way

### 📦 Project Overview
#### Description
SmartSupplyChain is a modular, Java-powered logistics system that models the safe and scalable flow of 
products — from suppliers, through warehouses, to end customers. It reflects real-world supply chain 
operations with strong emphasis on:

Each module must follow:

- Object-Oriented Programming (Encapsulation, Abstraction, Inheritance)
- Generics (Type Safety, Bounded Types, Wildcards)
- Exception Handling (Custom Exceptions, Validation)
- Java Collections (List, Map)
- Maven for Build & Dependency Management 
- JUnit 5 for Clean, Maintainable Unit Testing
- A system simulation via a `main()` entrypoint)

### Project Structure


Build this structure inside `src/main/java/`:

``` bash

SmartSupplyChain/
 ├── main/
 │    └── SmartSupplyChainApp.java              # Main simulation entrypoint
 ├── items/
 │    ├── Product.java
 │    ├── Perishable.java
 │    ├── Document.java
 │    └── Electronic.java
 ├── inventory/
 │    ├── StorageUnit.java
 │    ├── MultiStorageUnit.java
 │    ├── Package.java
 │    └── Inventory.java
 ├── people/
 │    ├── Person.java
 │    ├── Supplier.java
 │    └── Customer.java
 ├── system/
 │    └── SupplyChainUtils.java
 └── exception/
      ├── ExpiredProductException.java
      ├── EmptyStorageException.java
      └── InvalidInputException.java

```

### Implementation Guidelines
- Organize classes using meaningful **Java packages**

(e.g., `org.supplychain.items`, `org.supplychain.inventory`, etc.)

- Follow **SOLID** principles and **best OOP practices**. 
- Write `SmartSupplyChainApp.java` as your main simulation class, modeling:
  - Creating suppliers and customers 
  - Initializing inventory and moving products 
  - Handling exceptions gracefully


### Testing
- Use JUnit 5 for unit testing each core component. 
- Place your tests under src/test/java/ following the same package structure. 
- Aim for clean, isolated, and descriptive test cases.

### 🌱 Learning Goals
By the end of this project, you will confidently demonstrate:
1. Proficiency in advanced Java programming 
2. Building and structuring real-world applications 
3. Writing clean, testable, and maintainable code 
4. Using Maven and JUnit like a professional developer





