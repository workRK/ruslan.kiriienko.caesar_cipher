package com.javarush;

public class BruteForceDecrypt {
    private String content;
    private String alphabet;

    public BruteForceDecrypt(String content) {
        this.content = content;
    }

    public void bruteForceDecrypt() {
        LanguageDetector languageDetector = new LanguageDetector();

        if (languageDetector.containsLatin(content)) {
            alphabet = "abcdefghijklmnopqrstuvwxyz";
        } else if (languageDetector.containsCyrillic(content)) {
            alphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
        } else {
            System.out.println("Мова не підтримується.");
            return;
        }

        for (int key = 0; key < alphabet.length(); key++) {
            DecryptorCaesar decryptorCaesar = new DecryptorCaesar(key, content);
            String decryptedText = decryptorCaesar.decryptCaesar();

            System.out.println("Ключ: " + key + " - розшифрований текст: " + decryptedText);
        }
    }
}
