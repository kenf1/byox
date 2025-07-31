package org.byox.data;

import java.io.File;

public class FileOperations {
    public static String getFileSizeBytes(String filePath){
        File file = new File(filePath);
        if (file.exists()){
            long sizeInBytes = file.length();
            return Long.toString(sizeInBytes);
        }else{
            System.out.println("Unable to find file");
            return "";
        }
    }
}
