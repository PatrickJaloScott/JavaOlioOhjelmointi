package model;

import java.util.HashMap;

public class Dictionary {
    private final HashMap<String, String> wordList;

    public Dictionary() {
        wordList = new HashMap<>();
        wordList.put("Hello", "A greeting");
        wordList.put("Goodbye", "A farewell");
        wordList.put("Java", "A programming language");
        wordList.put("Computer", "A machine that can be instructed to carry out sequences of arithmetic or logical operations automatically via computer programming");
        wordList.put("Sewing", "The craft of fastening or attaching objects using stitches made with a needle and thread");
    }

    public void addWord(String word, String definition) {
        wordList.put(word, definition);
    }

    public String getDefinition(String word) {
        return wordList.get(word);
    }
}
