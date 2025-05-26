# 📚 **Building a Library App with Maven and JUnit 5**

---

## 🎯 **Exercise Goal**

- Create a **Maven project** in IntelliJ IDEA.
- Correctly replace **old JUnit 3.8** with **new JUnit 5** in `pom.xml`.
- Build two simple Java classes:
    - `Book`
    - `Library`
- Write **JUnit 5 tests** for both.

✅ Practice professional **project setup**, **Java class design**, **unit testing**, and **dependency management**.

---

# 🛠️ **STEP-BY-STEP GUIDE**

---

# 1️⃣ **Create a New Maven Project in IntelliJ IDEA**

Follow these steps:

- Open **IntelliJ IDEA**.
- Click **New Project** → **Maven**.
- Uncheck **Create from archetype** if it's checked.
- Click **Next**.

Fill project information:

| Field | Value |
|:------|:------|
| GroupId | `org.library` |
| ArtifactId | `library-app` |
| Version | leave as default |

Click **Finish** → Wait for the project to load.

✅ You should see structure:

```
library-app
 └── src
     ├── main
     │   └── java
     └── test
         └── java
```

---

# 2️⃣ **Fix the JUnit Version in `pom.xml`**

**Very important**:  
By default, Maven might generate an old JUnit 3.8 dependency:

```xml
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>3.8.1</version>
  <scope>test</scope>
</dependency>
```

🛑 **This is old, and will NOT work with JUnit 5 annotations like `@Test`.**

---

### ✍️ Students Must Replace It With:

```xml
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter-engine</artifactId>
  <version>5.9.1</version>
  <scope>test</scope>
</dependency>
```

✅ Steps:

- Open `pom.xml`
- Find the `<dependencies>` section
- Delete the old JUnit dependency block
- Paste the **new JUnit 5 dependency** inside `<dependencies>`

✅ Now, Maven will download **JUnit 5** automatically when you build the project!

---

# 3️⃣ **Create the `Book` Class**

Inside `src/main/java/org/library/`:

Create a **new Java class**: `Book.java`

```java
package org.library;

public class Book {
    // private final Fields: title, author  and price
    
    // Constructor 
    

    // Getters ONLY
   
}
```

✅ `Book` is **immutable** — no setters, only getters, final fields.

---

# 4️⃣ **Create the `Library` Class**

Inside the same package `org.library`:

Create **`Library.java`**:

```java
package org.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // private final List of <Book>'s 

    // Default constructor to initialize the books List as new ArrayList<>()
   
    // Add book mthod
   
   // method to get Number of books (the size of th Library)
   
    // calculateTotalPrice method
   
    // get all books method: new reference to avoid interference
   
}
```

✅ Library uses a **List<Book>**.
✅ Adds books, counts them, calculates the total price.

---

# 5️⃣ **Create the `BookTest` Class**

Inside `src/test/java/org/library/`:

Create a **new test class**: `BookTest.java`

```java
package org.library;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Modifier;

class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("Effective Java", "Joshua Bloch", 45.99);
    }

    @Test
    @DisplayName("Book should have correct fields assigned")
    void testBookCreation() {
        assertEquals("Effective Java", book.getTitle());
        assertEquals("Joshua Bloch", book.getAuthor());
        assertEquals(45.99, book.getPrice(), 0.001);
    }

    @Test
    @DisplayName("Book fields must be final")
    void testFieldsAreFinal() throws NoSuchFieldException {
        var bookClass = Book.class;

        assertTrue(Modifier.isFinal(bookClass.getDeclaredField("title").getModifiers()));
        assertTrue(Modifier.isFinal(bookClass.getDeclaredField("author").getModifiers()));
        assertTrue(Modifier.isFinal(bookClass.getDeclaredField("price").getModifiers()));
    }
}
```

---

# 6️⃣ **Create the `LibraryTest` Class**

Inside `src/test/java/org/library/`:

Create **`LibraryTest.java`**:

```java
package org.library;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    @DisplayName("Library should start empty")
    void testLibraryStartsEmpty() {
        assertEquals(0, library.totalBooks());
    }

    @Test
    @DisplayName("Adding books should increase total")
    void testAddingBooks() {
        library.addBook(new Book("Clean Code", "Robert C. Martin", 37.95));
        library.addBook(new Book("The Pragmatic Programmer", "Andy Hunt", 42.00));

        assertEquals(2, library.totalBooks());
    }

    @Test
    @DisplayName("Library should calculate total price of books")
    void testCalculateTotalPrice() {
        library.addBook(new Book("Book 1", "Author 1", 15.50));
        library.addBook(new Book("Book 2", "Author 2", 24.50));

        assertEquals(40.00, library.calculateTotalPrice(), 0.001);
    }
}
```

---

# 7️⃣ **Run the Tests**

✅ Right-click on `BookTest` → **Run 'BookTest'**.  
✅ Right-click on `LibraryTest` → **Run 'LibraryTest'**.

All tests should pass! ✅✅

✅ IntelliJ should show a **green bar** for success.

---

# 📚 Students Learn to Practice:

| Skill | Why Important |
|:------|:--------------|
| Creating Maven projects | Real-world project setup |
| Replacing dependencies | Upgrading libraries properly |
| Writing immutable classes | Professional Java object modeling |
| Writing unit tests | Ensuring code quality |
| Using Reflection | Advanced testing techniques |
