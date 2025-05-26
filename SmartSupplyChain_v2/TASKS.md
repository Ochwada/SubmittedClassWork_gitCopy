# SmartSupplyChain
## Tasks

## Objective:  Mastering Generics, OOP, Collections, Maven, and JUnit 5
### *Real-World Systems Engineering, the Modern Way*

### Project Overview
#### Description
You are tasked with building the core of SmartSupplyChain, a Java-powered logistics system that models the flow of products — 
from suppliers, through warehouses, to customers — safely, scalably, and fault-tolerantly.

Each module must follow:

- OOP (Encapsulation, Abstraction, Inheritance)
- Generics (Type Safety, Bounded Types, Wildcards)
- Exception Handling (Custom Exceptions, Validation)
- Collections (List, Map)
- Maven (Dependency Management)
- JUnit 5 (Professional Testing)
- System simulation (main() entrypoint)

### What to Implement (Tasks)

#### Task 1️⃣: Model Products

- Create Product (abstract) with `id`, `name`, and `abstract getType()`. 
- Create concrete products:
  - `Document` 
  - `Electronic` 
  - `Perishable` (add `expirationDay`, `isExpired(today)` method).
- Expired products must throw ExpiredProductException. 
- Use clean `toString()` overrides.


#### Task 2️⃣: Generic Storage Units

- Create `StorageUnit<T>` for single items. 
- Create `MultiStorageUnit<T>` for multiple `items (List<T>)`. 
- Handle null items and empty storage via custom exceptions.

#### Task 3️⃣: Packages and Inventory

- `Package<T>` groups multiple items.
- `Inventory<T>` maps package IDs to packages (`Map<String, Package<T>>`). 
- Add methods to:
  - Add and retrieve packages 
  - Validate contents 
  - Handle expired products using exceptions

#### Task 4️⃣: People (Supplier and Customer)

- `Person (abstract)` → common fields + methods.
  `Supplier` owns `List<Package<? extends Product>>`
- `Customer` can `receivePackage(Package<?>)`
- Handle invalid input with `InvalidInputException.`