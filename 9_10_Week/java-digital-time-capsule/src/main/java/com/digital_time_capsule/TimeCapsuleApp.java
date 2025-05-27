package com.digital_time_capsule;

import java.io.*;

/**
 * *******************************************************
 * Package: com.digital_time_capsule
 * File: TimeCapsuleApp.java
 * Author: Ochwada
 * Date: Monday, 26.May.2025, 3:44 PM
 * Description: Tie It All Together
 * Objective:
 * *******************************************************
 */


public class TimeCapsuleApp {
    public static void main(String[] args) {
        String messagePath = "message.txt";
        String backupMessagePath = "message_backup.txt";
        String imagePath = "memory.jpg";
        String backupImagePath = "memory_backup.jpg";

        String message = "Hey Future Me," +
                "\nToday you started mastering Java Streams." +
                "\nRemember: With great buffers come great performance.\n";

        try {
            // Write message
            System.out.println("Writing your message...");
            MessageWriter.writeMessage(messagePath, message);

            // Read message
            System.out.println("\nReading your message...");
            String read = MessageReader.readMessage(messagePath);
            System.out.println("\uD83D\uDDE8\uFE0F Message read:\n" + read);

            // Copy (Backup)
            System.out.println("\nCopying your memory image...");
            BinaryFileCopier.copyFile(imagePath, backupImagePath);
            System.out.println("Image copied to: " + backupImagePath);

        } catch (IOException e) {
            System.err.println("Something went wrong: " + e.getMessage());
        }


    }
}
