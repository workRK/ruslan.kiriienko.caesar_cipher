package com.javarush;

public class BruteForceDecrypt {
    private final String content;

    public BruteForceDecrypt(String content) {
        this.content = content;
    }

    void bruteForceDecrypt() {
        LanguageDetector languageDetector = new LanguageDetector();

        String alphabet;

        if (languageDetector.containsLatin(content)) {
            alphabet = "abcdefghijklmnopqrstuvwxyz";
        } else if (languageDetector.containsCyrillic(content)) {
            alphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
        } else {
            System.out.println("Мова не підтримується.");
            return;
        }

        for (int key = 0; key < alphabet.length(); key++) {
            DecryptorCaesar decryptorCaesar = new DecryptorCaesar(content, key);
            String decryptedText = decryptorCaesar.decryptCaesar();

            System.out.println("Ключ: " + key + " - розшифрований текст: " + decryptedText);
        }
    }
}
