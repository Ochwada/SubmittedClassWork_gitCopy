package com.digital_time_capsule;

import java.io.*;

/**
 * *******************************************************
 * Package: com.digital_time_capsule
 * File: BinaryFileCopier.java
 * Author: Ochwada
 * Date: Monday, 26.May.2025, 3:20 PM
 * Description: Copy an image (e.g. memory.jpg) using byte streams to a new file (memory_backup.jpg).
 * Objective:
 * *******************************************************
 */


public class BinaryFileCopier {

    /**
     * Copies a binary file from source to destination using buffered byte streams.
     *
     * @param sourcePath path to the original file
     * @param destPath   path for the backup copy
     * @throws IOException if copying fails
     */
    public static void copyFile(String sourcePath, String destPath) throws IOException {
        // Use BufferedInputStream and BufferedOutputStream for better I/O performance
        try (
                InputStream in = new BufferedInputStream(new FileInputStream(sourcePath));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(destPath))
        ) {
            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }
}
