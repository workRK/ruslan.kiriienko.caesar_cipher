package com.javarush;

public class LanguageDetector {

    boolean containsLatin(String text) {
        for (char c : text.toCharArray()) {
            if (Character.UnicodeScript.of(c) == Character.UnicodeScript.LATIN) {
                return true;
            }
        }
        return false;
    }

    boolean containsCyrillic(String text) {
        for (char c : text.toCharArray()) {
            if (Character.UnicodeScript.of(c) == Character.UnicodeScript.CYRILLIC) {
                return true;
            }
        }
        return false;
    }
}
