package org.byox.data;

import java.io.*;

public class FileOperations {
    //assume large file
    public static void printFileContents(String filePath) {
        //todo: refactor logic
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.printf("%s not found%n", filePath);
        } catch (IOException e) {
            //get warning on java 24
            System.err.println(String.format("Error reading %s", filePath));
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Error closing reader");
                }
            }
        }
    }

    public static String getFileSizeBytes(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new RuntimeException(String.format("%s not found", filePath));
        }

        long sizeInBytes = file.length();
        return Long.toString(sizeInBytes);
    }
}
