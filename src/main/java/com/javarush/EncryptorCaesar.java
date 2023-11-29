package com.javarush;

public class EncryptorCaesar {
    private final int key;
    private final String content;

    public EncryptorCaesar(String content, int key) {
        this.content = content;
        this.key = key;
    }

    String encryptCaesar() {
        StringBuilder encryptContent = new StringBuilder();
        LanguageDetector languageDetector = new LanguageDetector();

        String alphabet;

        if (languageDetector.containsLatin(content)) {
            alphabet = "abcdefghijklmnopqrstuvwxyz";
        } else if (languageDetector.containsCyrillic(content)) {
            alphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
        } else {
            System.out.println("Мова не підтримується.");
            return null;
        }

        for (int i = 0; i < content.length(); i++) {
            char currentChar = content.charAt(i);
            int charIndex = alphabet.indexOf(Character.toLowerCase(currentChar));

            if (charIndex != -1) {
                char encryptedChar = alphabet.charAt((charIndex + key) % alphabet.length());

                if (Character.isUpperCase(currentChar)) {
                    encryptContent.append(Character.toUpperCase(encryptedChar));
                } else {
                    encryptContent.append(encryptedChar);
                }
            } else {
                encryptContent.append(currentChar);
            }
        }
        return encryptContent.toString();
    }
}
