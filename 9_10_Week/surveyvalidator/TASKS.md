
### Today's assignment is live! 
We're building a **Mini Survey Validator** using **Java Reflections + Custom Annotations** — just like real frameworks do behind the scenes!

### What you'll learn:
- How to write and use custom annotations (@NotNull, @Min, @Length, @Email)
- How to use reflection to build a reusable validation engine 
- How to simulate real-world survey validation scenarios

### Assignment repo:
🔗 https://github.com/FW-Zalando-Java-Backend-Engineer/surveyvalidator
Make sure to read the full instructions in the README.md. Everything you need — background, steps, starter code, and test cases — is in there.
### Quick Tip (Regex for Email Validation)
In the assignment, you’ll see this line:
```Java
String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
``` 
### What does it do?
It checks if a string looks like a valid email.
#### In simple terms:
- Starts with letters/numbers/symbols (`+ _ . -`)
- Must contain an `@`
- Must have something after the `@` (like `domain.com`)
- Ends there (no extra junk)
  - ✅ Valid: john.doe@example.com, alice+promo@domain.org 
  - ❌ Invalid: @domain.com, bob@

This helps us **catch broken emails** before they sneak into our system 

Let me know if you get stuck or have questions — happy to help! 

---
---

# 📌 Assignment – Build a Mini Survey Validator with Java Reflections & Annotations

---

## 📖 Background

Imagine you're building a **survey collection system** for a research agency.

Participants fill out a form with:

* Name
* Age
* Email
* Feedback

As developers, your job is to ensure **data validation** before the system stores any response.

Instead of hardcoding validation for every field, you’ll use **Annotations + Reflection** to define rules and validate objects dynamically — the way frameworks like Spring or Hibernate do under the hood.

---

## 🎯 Objectives

By the end of this assignment, you will:

* Understand how to **write and use custom annotations**
* Learn how to use **Reflection** to process annotations at runtime
* Build a **reusable, flexible validation engine**
* Improve clean coding practices by separating metadata (rules) from logic

---

## 🧰 Technologies Used

* Java 8+ (for Reflection, Streams, Lambdas)
* JUnit 5 (for writing test cases)
* Maven (for project structure)

---

## 🔨 Step-by-Step Instructions

---

### ✅ Step 1: Setup the Project

🧱 Create a basic Maven project with package structure:

```
com/surveyvalidator/
```

Inside `pom.xml`, add JUnit 5 as a dependency.

---

### ✅ Step 2: Create the Data Model – `SurveyResponse.java`

**🎯 Goal:** Define a participant’s survey response.

```java
package com.surveyvalidator;

import com.surveyvalidator.annotations.Email;
import com.surveyvalidator.annotations.Length;
import com.surveyvalidator.annotations.Min;
import com.surveyvalidator.annotations.NotNull;

public class SurveyResponse {

  @NotNull
  @Length(min = 3, max = 50)
  private String name;

  @Min(18)
  private int age;

  @NotNull
  @Email
  private String email;

  @Length(max = 200)
  private String feedback;

  public SurveyResponse(String name, int age, String email, String feedback) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.feedback = feedback;
  }

  // Getters and setters (optional)
}
```

---

### ✅ Step 3: Define Custom Annotations

**🎯 Goal:** Create metadata rules

```java
package com.surveyvalidator;

import java.lang.annotation.*;

/**
 * Ensures that a field must not be null.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotNull {}
```

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Min {
    int value();
}
```

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Length {
    int min() default 0;
    int max() default Integer.MAX_VALUE;
}
```

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Email {}
```

---

### ✅ Step 4: Build the Validator Engine

**🎯 Goal:** Use Reflection to enforce annotation rules

```java
package com.surveyvalidator;

import com.surveyvalidator.annotations.Email;
import com.surveyvalidator.annotations.Length;
import com.surveyvalidator.annotations.Min;
import com.surveyvalidator.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

/**
 * Validator class uses reflection to validate any object with custom annotations.
 */
public class Validator {

  public static void validate(Object obj) throws IllegalAccessException {
    Class<?> clazz = obj.getClass();

    for (Field field : clazz.getDeclaredFields()) {
      field.setAccessible(true);
      Object value = field.get(obj);

      if (field.isAnnotationPresent(NotNull.class) && value == null) {
        throw new IllegalArgumentException("Field '" + field.getName() + "' must not be null.");
      }

      if (field.isAnnotationPresent(Min.class)) {
        int min = field.getAnnotation(Min.class).value();
        if ((Integer) value < min) {
          throw new IllegalArgumentException("Field '" + field.getName() + "' must be at least " + min);
        }
      }

      if (field.isAnnotationPresent(Length.class) && value instanceof String) {
        Length length = field.getAnnotation(Length.class);
        String str = (String) value;
        if (str.length() < length.min() || str.length() > length.max()) {
          throw new IllegalArgumentException("Field '" + field.getName() + "' must be between " +
                  length.min() + " and " + length.max() + " characters.");
        }
      }

      if (field.isAnnotationPresent(Email.class) && value instanceof String) {
        String email = (String) value;
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(regex, email)) {
          throw new IllegalArgumentException("Field '" + field.getName() + "' must be a valid email.");
        }
      }
    }
  }
}
```

---

### ✅ Step 5: Write a Demo Runner

**🎯 Goal:** Simulate real survey submissions and validation

```java
package com.surveyvalidator;

public class Demo {
    public static void main(String[] args) {
        SurveyResponse r1 = new SurveyResponse("John", 25, "john@example.com", "Great survey!");
        SurveyResponse r2 = new SurveyResponse(null, 17, "invalidemail", "Very informative.");

        try {
            Validator.validate(r1);
            System.out.println("✅ r1 is valid");
        } catch (Exception e) {
            System.out.println("❌ r1 Error: " + e.getMessage());
        }

        try {
            Validator.validate(r2);
            System.out.println("✅ r2 is valid");
        } catch (Exception e) {
            System.out.println("❌ r2 Error: " + e.getMessage());
        }
    }
}
```

---

### ✅ Step 6: Unit Test with JUnit 5

**🎯 Goal:** Write test cases for all validation rules

```java
package com.surveyvalidator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void validResponseShouldPass() {
        SurveyResponse res = new SurveyResponse("Alice", 20, "alice@example.com", "Awesome!");
        assertDoesNotThrow(() -> Validator.validate(res));
    }

    @Test
    void nullNameShouldFail() {
        SurveyResponse res = new SurveyResponse(null, 20, "x@example.com", "Nice.");
        Exception e = assertThrows(IllegalArgumentException.class, () -> Validator.validate(res));
        assertTrue(e.getMessage().contains("name"));
    }

    @Test
    void badEmailShouldFail() {
        SurveyResponse res = new SurveyResponse("Bob", 22, "bob.com", "Cool.");
        Exception e = assertThrows(IllegalArgumentException.class, () -> Validator.validate(res));
        assertTrue(e.getMessage().contains("email"));
    }

    @Test
    void shortAgeShouldFail() {
        SurveyResponse res = new SurveyResponse("Cara", 17, "cara@example.com", "Ok");
        Exception e = assertThrows(IllegalArgumentException.class, () -> Validator.validate(res));
        assertTrue(e.getMessage().contains("age"));
    }
}
```

---

## 📚 Resources

* [Java Reflection Tutorial – Oracle](https://docs.oracle.com/javase/tutorial/reflect/)
* [Baeldung: Custom Annotations in Java](https://www.baeldung.com/java-custom-annotation)
* [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

---

## 🧠 Summary

You’ve:

* Built a model
* Defined custom validation annotations
* Applied **reflection** to read them at runtime
* Wrote test cases to verify rules

This is the foundation of annotation-driven programming used in **real frameworks**!

---

## 😂 Java Joke (You earned it!)

> Why do Java developers wear glasses?
> Because they can’t **C#**!


