package com.example.madt_lab2;

public class TextCounting {
    public int countCharacters(String inputText) {
        if (inputText == null) return 0;
        return inputText.length();
    }

    // Count words (split by space, comma, or dot)
    public int countWords(String inputText) {
        if (inputText == null || inputText.trim().isEmpty()) {
            return 0;
        }
        String[] words = inputText.trim().split("[^a-zA-Z0-9']+");
        return words.length;
    }
}
