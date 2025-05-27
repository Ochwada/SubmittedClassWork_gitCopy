package com.digital_time_capsule;

import java.io.*;

/**
 * *******************************************************
 * Package: com.digital_time_capsule
 * File: MessageWriter.java
 * Author: Ochwada
 * Date: Monday, 26.May.2025, 2:51 PM
 * Description: Writes a personal message to a text file using character stream.
 * Objective: Uses BufferedWriter for performance.
 * *******************************************************
 */


public class MessageWriter {
    /**
     * Write the provided message to the specified file path.
     *
     * @param filePath path of the file to write.
     * @param message  the content to write.
     * @throws IOException if the file writing fails.
     */
    public static void writeMessage(String filePath, String message) throws IOException {
        // BufferedWriter adds buffering to reduce disk operations
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))
        ) {
            writer.write(message);

        }

    }
}
