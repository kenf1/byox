package org.byox.cli;

import org.byox.data.FileOperations;

public class CliOptions {
    public static void parseArgs(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments passed into cli");
        }

        String fileName = args[1];

        switch (args[0]) {
            case "help":
            case "-h":
                System.out.println("Help");
                break;
            case "cat":
            case "-c":
                FileOperations.printFileContents(fileName);
            case "size":
            case "-s":
                String fileSize = FileOperations.getFileSizeBytes(fileName);
                System.out.printf("The file %s is %s bytes%n", fileName, fileSize);
            default:
                System.out.println("Help1");
        }
    }
}
