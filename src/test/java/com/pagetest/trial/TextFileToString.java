package com.pagetest.trial;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileToString {
    public static String readFileToString(String filePath) throws IOException {
        byte[] encodedBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(encodedBytes, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        String filePath = "D:\\WorkSpace_05_23\\Sel_Dk\\dummy.txt";
        try {
            String fileContent = readFileToString(filePath);
            System.out.println(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
