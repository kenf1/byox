package org.byox;

import org.byox.cli.CliOptions;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CliOptions.parseArgs(args);
    }
}