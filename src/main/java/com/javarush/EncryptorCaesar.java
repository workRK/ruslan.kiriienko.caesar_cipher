package com.javarush;

public class EncryptorCaesar {
    private int key;
    private String content;
    private String alphabet;

    public EncryptorCaesar(int key, String content) {
        this.key = key;
        this.content = content;
    }

    public String encryptCaesar() {
        StringBuilder encryptContent = new StringBuilder();
        LanguageDetector languageDetector = new LanguageDetector();

        if (languageDetector.containsLatin(content)) {
            alphabet = "abcdefghijklmnopqrstuvwxyz";
        } else if (languageDetector.containsCyrillic(content)) {
            alphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
        } else {
            System.out.println("Мова не підтримується.");
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
