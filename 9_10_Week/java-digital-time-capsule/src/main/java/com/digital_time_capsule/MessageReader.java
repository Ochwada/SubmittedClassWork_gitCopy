package com.digital_time_capsule;

import java.io.*;

/**
 * *******************************************************
 * Package: com.digital_time_capsule
 * File: MessageReader.java
 * Author: Ochwada
 * Date: Monday, 26.May.2025, 3:06 PM
 * Description: Read the content from message.txt and print it to the console.
 * Objective: Reads a message from a file using BufferedReader.
 * *******************************************************
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
        // StringBuilder to efficiently collect text line by line.
        StringBuilder content = new StringBuilder();

        // BufferedReader improves efficiency by reading chunks of characters
        try (
                BufferedReader reader = new BufferedReader(new FileReader(filePath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }
}
