package org.byox.cli;

import org.byox.data.FileOperations;

public class CliOptions {
    public static void parseArgs(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments passed into cli.");
            return;
        }

        if (!args[0].equals("help") && !args[0].equals("-h") && args.length < 2) {
            System.out.println("Not enough arguments passed into cli. At least 2 required.");
            return;
        }

        String fileName = args[1];

        switch (args[0]) {
            case "cat":
            case "-c":
                FileOperations.printFileContents(fileName);
                break;
            case "size":
            case "-s":
                String fileSize = FileOperations.getFileSizeBytes(fileName);
                printWrapper(fileName, "bytes", fileSize);
                break;
            case "lines":
            case "-l":
                int totalLines = FileOperations.countTotalLines(fileName);
                printWrapper(fileName, "lines", String.valueOf(totalLines));
                break;
            case "words":
            case "-w":
                int totalWords = FileOperations.countTotalWords(fileName);
                printWrapper(fileName, "words", String.valueOf(totalWords));
                break;
            case "chars":
            case "-m":
                int totalChars = FileOperations.countTotalChars(fileName);
                printWrapper(fileName, "chars", String.valueOf(totalChars));
                break;
            case "help":
            case "-h":
            default:
                System.out.println("Usage: <command> <fileName> [option]");
                System.out.println("Available options:");
                System.out.printf("  %-10s : %s%n", "cat, -c", "Print the contents of the file");
                System.out.printf("  %-10s : %s%n", "size, -s", "Display the size of the file in bytes");
                System.out.printf("  %-10s : %s%n", "lines, -l", "Count and display the number of lines in the file");
                System.out.printf("  %-10s : %s%n", "words, -w", "Count and display the number of words in the file");
                System.out.printf("  %-10s : %s%n", "chars, -m", "Count and display the number of characters in the file");
                System.out.printf("  %-10s : %s%n", "help, -h", "Show available options");
                break;
        }
    }

    private static void printWrapper(String fileName, String metric, String value) {
        System.out.printf("The file %s has %s %s%n", fileName, value, metric);
    }
}
