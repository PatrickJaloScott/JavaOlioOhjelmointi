package application.controller;

import model.Dictionary;
import view.DictionaryView;

public class DictionaryController {

    private final DictionaryView view;
    private final Dictionary dictionary = new Dictionary();

    public DictionaryController(DictionaryView view) {
        this.view = view;
    }

    public static void main(String[] args) {
        DictionaryView.launch(DictionaryView.class);
    }

    public void addEntry(String word, String definition) {
        if (!word.isEmpty() && !definition.isEmpty()) {
            dictionary.addWord(word, definition);
            view.clearEntryFields();
        } else {
            view.setEntryError();
        }
    }

    public void setDefinitionSearchGUI(String search) {
        String definition = dictionary.getDefinition(search);
        if (search.isEmpty()) {
            view.setDefinitionWarning();
        } else if(definition == null) {
            view.setDefinitionError(search);
        } else {
            view.setDefinitionText(search, definition);
        }
    }
}
