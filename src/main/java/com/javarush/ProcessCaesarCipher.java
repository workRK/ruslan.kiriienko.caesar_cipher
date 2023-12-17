package com.javarush;

public class ProcessCaesarCipher {
    void processEncryptDecrypt(String[] args) {
        String command = args[0];
        String filePath = args[1];
        int key = Integer.parseInt(args[2]);

        FileService fileService = new FileService();
        String content = fileService.readFile(filePath);

        if(command.equals("ENCRYPT")) {
            processEncryption(fileService, filePath, key, content);
        } else if (command.equals("DECRYPT")) {
            processDecryption(fileService, filePath, key, content);
        }
    }

    void processEncryption(FileService fileService, String filePath, int key, String content) {
        EncryptorCaesar encryptorCaesar = new EncryptorCaesar(content, key);
        String encryptedContent = encryptorCaesar.encryptCaesar();
        writeToFile(fileService, filePath, "ENCRYPT", encryptedContent);
    }

    void processDecryption(FileService fileService, String filePath, int key, String content) {
        DecryptorCaesar decryptorCaesar = new DecryptorCaesar(content, key);
        String decryptedContent = decryptorCaesar.decryptCaesar();
        writeToFile(fileService, filePath, "DECRYPT", decryptedContent);
    }

    void processBruteForce(String[] args) {
        String filePath = args[1];
        FileService fileService = new FileService();
        String content = fileService.readFile(filePath);

        BruteForceDecrypt bruteForceDecrypt = new BruteForceDecrypt(content);
        bruteForceDecrypt.bruteForceDecrypt();
    }

    void processInteractive() {
        CLI cli = new CLI();
        String command = cli.promptForCommand();
        String filePath = cli.promptForFilePath();
        int key = (command.equals("ENCRYPT") || command.equals("DECRYPT")) ? cli.promptForKey() : 0;
        cli.close();

        FileService fileService = new FileService();
        String content = fileService.readFile(filePath);

        switch (command) {
            case "ENCRYPT" -> processEncryption(fileService, filePath, key, content);
            case "DECRYPT" -> processDecryption(fileService, filePath, key, content);
            case "BRUTE_FORCE" -> processBruteForce(new String[]{"BRUTE_FORCE", filePath});
        }
    }

    void writeToFile(FileService fileService, String filePath, String command, String fileContent) {
        int lastDotIndex = filePath.lastIndexOf(".");
        String writeFilePath = filePath.substring(0, lastDotIndex) + "[" + command + "]" + filePath.substring(lastDotIndex);
        fileService.writeFile(writeFilePath, fileContent);
    }

}
