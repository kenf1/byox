package org.byox;

import org.byox.data.FileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "./data/quote.txt";

        //assume large file
        //todo: pass filename as cli arg
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();

        String fileSize = FileOperations.getFileSizeBytes(fileName);
        System.out.printf("The file %s is %s bytes%n",fileName,fileSize);
    }
}