package application.controller;

import model.library.Dictionary;

public class DictionaryController {

    private final Dictionary dictionary;

    public DictionaryController() {
        dictionary = new Dictionary();
    }

    public void addEntry(String word, String definition) {
        dictionary.addWord(word, definition);
    }

    public String getDefinition(String search) {
        return dictionary.getDefinition(search);
    }
}
