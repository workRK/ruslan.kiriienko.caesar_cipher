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
            int lastDotindex = filePath.lastIndexOf(".");
            String writeFilePath = filePath.substring(0, lastDotindex) + "[" + command + "]" + filePath.substring(lastDotindex);
            fileService.writeFile(writeFilePath, encryptedContent);
        } else if (args.length == 3 && args[0].equals("DECRYPT")) {
            String command = args[0];
            String filePath = args[1];
            int key = Integer.parseInt(args[2]);

            FileService fileService = new FileService();
            String content = fileService.readFile(filePath);
            DecryptorCaesar decryptorCaesar = new DecryptorCaesar(content, key);
            String decryptedContent = decryptorCaesar.decryptCaesar();
            int lastDotindex = filePath.lastIndexOf(".");
            String writeFilePath = filePath.substring(0, lastDotindex) + "[" + command + "]" + filePath.substring(lastDotindex);
            fileService.writeFile(writeFilePath, decryptedContent);
        } else if (args.length == 2 && args[0].equals("BRUTE_FORCE")) {
            String filePath = args[1];

            FileService fileService = new FileService();
            String content = fileService.readFile(filePath);
            BruteForceDecrypt bruteForceDecrypt = new BruteForceDecrypt(content);
            bruteForceDecrypt.bruteForceDecrypt();
        } else if (args.length == 0) {
            CLI cli = new CLI();
            String command = cli.promptForCommand();
            if (command.equals("ENCRYPT")) {
                String filePath = cli.promptForFilePath();
                int key = cli.promptForKey();
                cli.close();
                FileService fileService = new FileService();
                String content = fileService.readFile(filePath);
                EncryptorCaesar encryptorCaesar = new EncryptorCaesar(content, key);
                String encryptedContent = encryptorCaesar.encryptCaesar();
                int lastDotindex = filePath.lastIndexOf(".");
                String writeFilePath = filePath.substring(0, lastDotindex) + "[" + command + "]" + filePath.substring(lastDotindex);
                fileService.writeFile(writeFilePath, encryptedContent);
            } else if (command.equals("DECRYPT")) {
                String filePath = cli.promptForFilePath();
                int key = cli.promptForKey();
                cli.close();
                FileService fileService = new FileService();
                String content = fileService.readFile(filePath);
                DecryptorCaesar decryptorCaesar = new DecryptorCaesar(content, key);
                String decryptedContent = decryptorCaesar.decryptCaesar();
                int lastDotindex = filePath.lastIndexOf(".");
                String writeFilePath = filePath.substring(0, lastDotindex) + "[" + command + "]" + filePath.substring(lastDotindex);
                fileService.writeFile(writeFilePath, decryptedContent);
            } else if (command.equals("BRUTE_FORCE")) {
                String filePath = cli.promptForFilePath();
                cli.close();
                FileService fileService = new FileService();
                String content = fileService.readFile(filePath);
                BruteForceDecrypt bruteForceDecrypt = new BruteForceDecrypt(content);
                bruteForceDecrypt.bruteForceDecrypt();
            }

        } else {
            System.out.println("Перевірте правильність введеної інформації, і повторіть спробу!");
        }
    }
}
