package com.javarush;

public class DecryptorCaesar {
    private int key;
    private String content;
    private String alphabet;

    public DecryptorCaesar(int key, String content) {
        this.key = key;
        this.content = content;
    }

    public String decryptCaesar() {
        StringBuilder decryptedContent = new StringBuilder();
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
                char decryptedChar = alphabet.charAt((charIndex - key + alphabet.length()) % alphabet.length());

                if (Character.isUpperCase(currentChar)) {
                    decryptedContent.append(Character.toUpperCase(decryptedChar));
                } else {
                    decryptedContent.append(decryptedChar);
                }
            } else {
                decryptedContent.append(currentChar);
            }
        }
        return decryptedContent.toString();
    }
}
