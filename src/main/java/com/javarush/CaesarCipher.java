package com.javarush;

public class CaesarCipher {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Raketa\\IdeaProjects\\ruslan.kiriienko.caesar_cipher\\src\\main\\java\\com\\javarush\\text.txt";
        FileService fileService = new FileService(filePath);
        String text = fileService.readFile();
        System.out.println(text);
        String writePath = "C:\\Users\\Raketa\\IdeaProjects\\ruslan.kiriienko.caesar_cipher\\src\\main\\java\\com\\javarush\\newtext.txt";
        fileService.writeFile(writePath, text);
    }
}
