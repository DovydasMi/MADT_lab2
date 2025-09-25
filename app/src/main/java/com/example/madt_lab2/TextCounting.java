package com.example.madt_lab2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TextCounting {
    public int countCharacters(String inputText) {
        if (inputText == null) return 0;
        return inputText.length();
    }

    public int countWords(String inputText) {
        if (inputText == null || inputText.trim().isEmpty()) {
            return 0;
        }
        String[] words = inputText.trim().split("[^a-zA-Z0-9']+");
        return words.length;
    }

    public int countSentences(String inputText) {
        String text = inputText.trim();
        if (text.isEmpty()) return 0;

        Pattern pattern = Pattern.compile("[^.!?]+([.!?]|$)");
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }

    public int countNumbers(String inputText) {
        if (inputText == null || inputText.trim().isEmpty()) {
            return 0;
        }

        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(inputText);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
