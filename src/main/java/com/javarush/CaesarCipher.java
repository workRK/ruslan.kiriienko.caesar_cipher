package com.javarush;

public class CaesarCipher {
    public static void main(String[] args) {

        if (args.length == 3 && args[0].equals("ENCRYPT")) {
            String command = args[0];
            String filePath = args[1];
            int key = Integer.parseInt(args[2]);

            FileService fileService = new FileService();
            String content = fileService.readFile(filePath);
            EncryptorCaesar encryptorCaesar = new EncryptorCaesar(content, key);
            String encryptedContent = encryptorCaesar.encryptCaesar();

            fileService.writeFile(filePath, encryptedContent);
        }
    }
}
