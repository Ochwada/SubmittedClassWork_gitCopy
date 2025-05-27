package com.digital_time_capsule;

import org.junit.jupiter.api.*;

import java.io.*;

import static com.digital_time_capsule.MessageReader.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * *******************************************************
 * Package: com.digital_time_capsule
 * File: MessageWriterTest.java
 * Author: Ochwada
 * Date: Monday, 26.May.2025, 2:59 PM
 * Description: Test for MessageWriter class
 * Objective:
 * *******************************************************
 */


public class MessageWriterTest {

    @BeforeAll // JUnit runs this once before any test method in this class.
    static void beforeAllTests() {
        System.out.println("\uD83E\uDDFF Stating MessageWriter Tests...  ");
    }

    @BeforeEach
    void setUp() {
        System.out.println("\uD83D\uDD38 New Setup: Create a new object.");

    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        File file = new File(testFilePath);
        if (file.exists()) {
            file.delete(); // Optional cleanup
        }
        System.out.println("✔️ Test Passed: 📃 " + testInfo.getDisplayName());
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("✅  MessageWriter ✨ Tests  Successfully Done ✨");
    }

    // -----------------------------------------------------
    // TESTS
    // -----------------------------------------------------
    public final String testFilePath = "test_message.txt";

    @Test
    @DisplayName("Should Write Message To File Correctly")
    void testWriteMessage() throws IOException {
        // Given: the message
        String message = "Hello from test!";

        // When: write message to file
        MessageWriter.writeMessage(testFilePath, message);

        // Then: read message from file
        String fileContent = readMessage(testFilePath);

        // Account for the System.lineSeparator() added in the reader
        assertEquals(message+ System.lineSeparator(), fileContent);
    }

}

