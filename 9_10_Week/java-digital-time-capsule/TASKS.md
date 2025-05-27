# 🚀 New Java Assignment Alert: Digital Time Capsule!🕰️

Hey team 👋, @channel

Your next mission is ready — and it’s one that blends nostalgia with some powerful Java I/O skills. 
We're building a **Digital Time Capsule** where you'll store a message to your future self and back up a precious image 🗃️ 📷

### 📌Assignment Repo:

👉  [ https://github.com/FW-Zalando-Java-Backend-Engineer/Digital-Time-Capsule]  or [ https://github.com/Ochwada/java-digital-time-capsule/blob/main/README.md]
#### 🎯 What You'll Learn: 
- Writing & reading files with BufferedReader/Writer 
- Copying binary files using byte streams 
- Using try-with-resources and buffer management like a pro 💪
- Writing clean Java with solid structure and documentation

#### 🧪 Instructions are detailed:
- Step-by-step guide with explanations and starter code 
- Real-life use case to make it meaningful 
- Just clone the repo and follow the steps!

#### 🎯 No bonus tasks this time — just master the core.

Drop a comment or a PR when you're done. Let’s see who builds the best digital time capsule! 💾

Let’s get coding! 😜

---
---
## 📚 Java Assignment — *"Digital Time Capsule"*

### 🔗 GitHub Repo Title:

```
java-digital-time-capsule
```

---

## 🏷️ Background

Imagine it's the year 2025. You want to leave a note and a digital memory for your future self — kind of like a **"Time Capsule"**. But instead of burying a box in the ground, you're saving a message and an image file on your hard drive.

Your job is to:

* Write a heartfelt message to a text file.
* Read it back to display it on the console.
* Copy the message and a memorable image to a secure backup location using **Java streams**.

This simulates what many backend applications do: generating content, persisting it, and copying or backing it up for durability.

---

## 🎯 Objectives

* Learn to use **character streams** to read and write text files.
* Understand how **byte streams** handle binary data like images.
* Practice **buffered I/O** for performance.
* Write **clear Javadoc and inline comments**.
* Structure a small program using clean Java conventions.

---

## 🛠️ Technologies Used

* Java 8+
* BufferedReader, BufferedWriter, FileReader, FileWriter
* InputStream, OutputStream, BufferedInputStream, BufferedOutputStream
* Java IO APIs (`java.io.*`)

---

## 📝 Assignment Steps

### 🪜 Step 1: Create the Message Writer

**Goal:** Write a custom message to a file named `message.txt`.

📄 **File**: `MessageWriter.java`

```java
package org.example;

import java.io.*;

/**
 * Writes a personal message to a text file using character stream.
 * Uses BufferedWriter for performance.
 */
public class MessageWriter {

    /**
     * Writes the provided message to the specified file path.
     * 
     * @param filePath path of the file to write
     * @param message the content to write
     * @throws IOException if file writing fails
     */
    public static void writeMessage(String filePath, String message) throws IOException {
        // BufferedWriter adds buffering to reduce disk operations
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(message);
        }
    }
}
```

📌 **Explanation**:

* Use `BufferedWriter` over `FileWriter` alone for better performance.
* Stream is closed automatically using try-with-resources.

---

### 🪜 Step 2: Read Back the Message

**Goal:** Read the content from `message.txt` and print it to the console.

📄 **File**: `MessageReader.java`

```java
package org.example;

import java.io.*;

/**
 * Reads a message from a file using BufferedReader.
 */
public class MessageReader {

    /**
     * Reads and returns the content of a text file.
     * 
     * @param filePath path of the text file
     * @return the content of the file
     * @throws IOException if file reading fails
     */
    public static String readMessage(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        // BufferedReader improves efficiency by reading chunks of characters
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }
}
```

📌 **Explanation**:

* `BufferedReader.readLine()` is ideal for processing text line-by-line.
* Use `StringBuilder` to avoid inefficient string concatenation.

---

### 🪜 Step 3: Copy the Image File (Binary File Copy)

**Goal:** Copy an image (e.g. `memory.jpg`) using **byte streams** to a new file (`memory_backup.jpg`).

📄 **File**: `BinaryFileCopier.java`

```java
package org.example;

import java.io.*;

/**
 * Copies a binary file (e.g., image) using byte streams.
 */
public class BinaryFileCopier {

    /**
     * Copies a binary file from source to destination using buffered byte streams.
     *
     * @param sourcePath path to the original file
     * @param destPath path for the backup copy
     * @throws IOException if copying fails
     */
    public static void copyFile(String sourcePath, String destPath) throws IOException {
        // Use BufferedInputStream and BufferedOutputStream for better I/O performance
        try (InputStream in = new BufferedInputStream(new FileInputStream(sourcePath));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(destPath))) {
             
            byte[] buffer = new byte[1024]; // 1KB buffer
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }
}
```

📌 **Explanation**:

* `BufferedInputStream` and `BufferedOutputStream` speed up I/O by reducing syscall overhead.
* A `byte[]` buffer of 1KB is used for chunked reads and writes.

---

### 🪜 Step 4: Tie It All Together

📄 **File**: `TimeCapsuleApp.java`

```java
package org.example;

import java.io.*;

public class TimeCapsuleApp {
    public static void main(String[] args) {
        String messagePath = "message.txt";
        String backupMessagePath = "message_backup.txt";
        String imagePath = "memory.jpg"; // You provide this image
        String backupImagePath = "memory_backup.jpg";

        String message = "Hey Future Me,\nToday you started mastering Java Streams.\nRemember: With great buffers come great performance.\n";

        try {
            System.out.println("Writing your message...");
            MessageWriter.writeMessage(messagePath, message);

            System.out.println("Reading your message...");
            String read = MessageReader.readMessage(messagePath);
            System.out.println("Message read:\n" + read);

            System.out.println("Copying your memory image...");
            BinaryFileCopier.copyFile(imagePath, backupImagePath);
            System.out.println("Image copied to: " + backupImagePath);

        } catch (IOException e) {
            System.err.println("Something went wrong: " + e.getMessage());
        }
    }
}
```

📌 **Explanation**:

* This is your main orchestrator class.
* Each responsibility (read, write, copy) is delegated to a dedicated class.

---

## 📚 Resources

* [Java IO: Oracle Docs](https://docs.oracle.com/javase/tutorial/essential/io/)
* [BufferedReader vs Console vs Scanner in Java](https://www.baeldung.com/bufferedreader-vs-console-vs-scanner-in-java)
* [Try-with-Resources Explained](https://www.baeldung.com/java-try-with-resources)

---

## ✅ Deliverables

* Your completed `.java` files organized under `org.example`.
* Place a sample `memory.jpg` in your root directory.
* Commit and push to a public GitHub repo named `java-digital-time-capsule`.

---

## 😂 Java Joke (because you earned it)

> Why did the Java developer go broke?
> Because he used up all his cache ☕💸
