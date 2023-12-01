package com.javarush;

public class CaesarCipher {
    public static void main(String[] args) {
        ProcessCaesarCipher processCaesarCipher = new ProcessCaesarCipher();

        if (args.length == 3 && (args[0].equals("ENCRYPT") || args[0].equals("DECRYPT"))) {
            processCaesarCipher.processEncryptDecrypt(args);
        } else if (args.length == 2 && args[0].equals("BRUTE_FORCE")) {
            processCaesarCipher.processBruteForce(args);
        } else if (args.length == 0) {
            processCaesarCipher.processInteractive();
        } else {
            System.out.println("Перевірте правильність введеної інформації, і повторіть спробу!");
        }
    }
}
