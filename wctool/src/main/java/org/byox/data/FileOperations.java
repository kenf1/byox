package org.byox.data;

import java.io.*;
import java.util.function.Consumer;

public class FileOperations {
    //assume large file
    private static void processFileLines(String filePath, Consumer<String> lineConsumer) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineConsumer.accept(line);
            }
        } catch (FileNotFoundException e) {
            System.err.printf("%s not found%n", filePath);
        } catch (IOException e) {
            System.err.printf("Error reading %s%n", filePath);
        }
    }

    public static void printFileContents(String filePath) {
        processFileLines(filePath, System.out::println);
    }

    public static int countTotalLines(String filePath) {
        final int[] lineCount = {0};
        processFileLines(filePath, line -> lineCount[0]++);
        return lineCount[0];
    }

    public static String getFileSizeBytes(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new RuntimeException(String.format("%s not found", filePath));
        }

        long sizeInBytes = file.length();
        return Long.toString(sizeInBytes);
    }

    //some repeats from processFileLines, branches out, keep separate
    private static int processFileWordCount(String filePath, Consumer<String> lineConsumer) {
        int wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineConsumer.accept(line);

                if (line.trim().isEmpty()) {
                    wordCount += 0;
                } else {
                    wordCount += line.trim().split("\\s+").length;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.printf("%s not found%n", filePath);
        } catch (IOException e) {
            System.err.printf("Error reading %s%n", filePath);
        }

        return wordCount;
    }

    public static int countTotalWords(String filePath) {
        return processFileWordCount(filePath, line -> {
        });
    }

    //todo: combine with processFileLines or processFileWordCount
    private static int processFileCharCount(String filePath, Consumer<String> lineConsumer) {
        int charCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineConsumer.accept(line);

                charCount += line.length(); //exclude line breaks
            }
        } catch (FileNotFoundException e) {
            System.err.printf("%s not found%n", filePath);
        } catch (IOException e) {
            System.err.printf("Error reading %s%n", filePath);
        }

        return charCount;
    }

    public static int countTotalChars(String filePath) {
        return processFileCharCount(filePath, line -> {
        });
    }
}
