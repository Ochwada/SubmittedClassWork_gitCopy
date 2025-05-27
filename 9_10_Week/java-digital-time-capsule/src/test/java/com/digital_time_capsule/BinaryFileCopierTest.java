package com.digital_time_capsule;

import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.Files;

import static com.digital_time_capsule.BinaryFileCopier.copyFile;
import static org.junit.jupiter.api.Assertions.*;

/**
 * *******************************************************
 * Package: com.digital_time_capsule
 * File: BinaryFileCopierTest.java
 * Author: Ochwada
 * Date: Monday, 26.May.2025, 3:39 PM
 * Description: Test for BinaryFileCopier
 * Objective:
 * *******************************************************
 */


public class BinaryFileCopierTest {
    private static final String sourceFile = "test_source.bin";
    private static final String copiedFile = "test_copy.bin";


    @BeforeAll // JUnit runs this once before any test method in this class.
    static void beforeAllTests() {
        System.out.println("\uD83E\uDDFF Stating BinaryFileCopier Tests...  ");
    }

    @BeforeEach
    void setUp() throws IOException{
        System.out.println("\uD83D\uDD38 New Setup: Create a new object.");
        // Create a test binary file
        try (OutputStream out = new FileOutputStream(sourceFile)) {
            byte[] data = {0x01, 0x02, 0x03, 0x04, 0x05};
            out.write(data);
        }
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("✔\uFE0FTest Passed: 📃 " + testInfo.getDisplayName());
        // Delete both files
        new File(sourceFile).delete();
        new File(copiedFile).delete();
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("✅  BinaryFileCopier ✨ Tests  Successfully Done ✨");
    }

    // -----------------------------------------------------
    // TESTS
    // -----------------------------------------------------
    @Test
    @DisplayName("Should copy binary file correctly")
    void testCopyFile() throws IOException {
        // When
        copyFile(sourceFile, copiedFile);

        // Then
        byte[] originalBytes = Files.readAllBytes(new File(sourceFile).toPath());
        byte[] copiedBytes = Files.readAllBytes(new File(copiedFile).toPath());

        assertArrayEquals(originalBytes, copiedBytes, "Copied file content should match original");
    }

}
