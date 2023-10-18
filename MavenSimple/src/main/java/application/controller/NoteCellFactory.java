package application.controller;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.notebook.Note;

public class NoteCellFactory implements Callback<ListView<Note>, ListCell<Note>> {
    @Override
    public ListCell<Note> call(ListView<Note> param) {
        return new ListCell<>() {
            @Override
            protected void updateItem(Note item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNoteTitle());
                }
            }
        };
    }
}
