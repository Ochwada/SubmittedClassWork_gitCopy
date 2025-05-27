package com.digital_time_capsule;


import org.junit.jupiter.api.*;

import java.io.*;

import static com.digital_time_capsule.MessageReader.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * *******************************************************
 * Package: com.digital_time_capsule
 * File: MessageReaderTest.java
 * Author: Ochwada
 * Date: Monday, 26.May.2025, 3:23 PM
 * Description: MessageReader Test
 * Objective:
 * *******************************************************
 */


public class MessageReaderTest {
    private static final String testFilePath = "test_read_message.txt";


    @BeforeAll // JUnit runs this once before any test method in this class.
    static void beforeAllTests() {
        System.out.println("\uD83E\uDDFF Stating MessageReader Tests...  ");
    }

    @BeforeEach
    void setUp() throws IOException {
        System.out.println("\uD83D\uDD38 New Setup: Create a new object.");

        // Create a file with known content to read
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write("Line 1");
            writer.newLine();
            writer.write("Line 2");
        }

    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("✔\uFE0FTest Passed: 📃 " + testInfo.getDisplayName());

        File file = new File(testFilePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("✅  MessageReader ✨ Tests  Successfully Done ✨");
    }

    // -----------------------------------------------------
    // TESTS
    // -----------------------------------------------------
    @Test
    @DisplayName("Should read content from file with line separators")
    void testReadMessage() throws IOException {
        // When
        String actualContent = readMessage(testFilePath);

        // Then
        String expectedContent = "Line 1" + System.lineSeparator() +
                "Line 2" + System.lineSeparator();

        assertEquals(expectedContent, actualContent);
    }

}
