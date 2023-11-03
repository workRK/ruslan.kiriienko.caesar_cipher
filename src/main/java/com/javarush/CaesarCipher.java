package com.javarush;

public class CaesarCipher {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Raketa\\IdeaProjects\\ruslan.kiriienko.caesar_cipher\\src\\main\\java\\com\\javarush\\text.txt";
        FileService fileService = new FileService(filePath);
        String contentEncrypt = fileService.readFile();
        EncryptorCaesar encryptorCaesar = new EncryptorCaesar(7, contentEncrypt);
        String content = encryptorCaesar.encryptCaesar();
        BruteForceDecrypt bruteForceDecrypt = new BruteForceDecrypt(content);
        bruteForceDecrypt.bruteForceDecrypt();
        DecryptorCaesar decryptorCaesar = new DecryptorCaesar(7, content);
        System.out.println(decryptorCaesar.decryptCaesar());
    }
}
