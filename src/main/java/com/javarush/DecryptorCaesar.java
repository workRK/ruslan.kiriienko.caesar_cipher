package com.javarush;

public class DecryptorCaesar {
    private final int key; // Зберігає ключ для розшифровування
    private final String content; // Зберігає зашифрований текст

    public DecryptorCaesar(String content, int key) {
        this.content = content;
        this.key = key;
    }

    String decryptCaesar() {
        StringBuilder decryptedContent = new StringBuilder();
        LanguageDetector languageDetector = new LanguageDetector();

        String alphabet;

        // Визначаємо алфавіт відповідно до мови тексту
        if (languageDetector.containsLatin(content)) {
            alphabet = "abcdefghijklmnopqrstuvwxyz"; // Англійський алфавіт
        } else if (languageDetector.containsCyrillic(content)) {
            alphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя"; // Український алфавіт
        } else {
            System.out.println("Мова не підтримується.");
            return null; // Якщо мова не підтримується, повертаємо null
        }

        for (int i = 0; i < content.length(); i++) {
            char currentChar = content.charAt(i);
            int charIndex = alphabet.indexOf(Character.toLowerCase(currentChar));

            if (charIndex != -1) {
                // Розшифровуємо символ, використовуючи ключ і алфаві
                char decryptedChar = alphabet.charAt((charIndex - key + alphabet.length()) % alphabet.length());

                if (Character.isUpperCase(currentChar)) {
                    decryptedContent.append(Character.toUpperCase(decryptedChar));
                } else {
                    decryptedContent.append(decryptedChar);
                }
            } else {
                // Якщо символ не входить до алфавіту, залишаємо без змін
                decryptedContent.append(currentChar);
            }
        }
        return decryptedContent.toString(); // Повертаємо розшифрований текст
    }
}
