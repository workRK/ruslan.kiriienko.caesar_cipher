package com.javarush;

import java.io.*;
import java.util.Scanner;

public class FileService {
    private String filePath;

    public FileService(String filePath) {
        this.filePath = filePath;
    }

    public String readFile() {
        StringBuilder content = new StringBuilder();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public void writeFile(String writeFilePath, String content) {
        try (FileWriter fileWriter = new FileWriter(writeFilePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
