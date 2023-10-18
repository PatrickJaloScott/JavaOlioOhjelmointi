package application.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Note;
import model.NoteBook;
import view.NoteBookView;

import java.util.ArrayList;

public class NoteController {
    private final NoteBook noteBook = new NoteBook();
    private final ObservableList<String> noteTitles;
    private final ObservableList<String> noteListContent;

    @FXML
    private ListView<String> noteList = new ListView<>();

    public NoteController() {
        ArrayList<String> notebookTitles = new ArrayList<>();
        for (Note n : noteBook.getNotes()) {
            notebookTitles.add(n.getNoteTitle());
        }
        noteTitles = FXCollections.observableArrayList(notebookTitles);
        noteListContent = FXCollections.observableArrayList();
        noteList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private TextField noteTitleField;

    @FXML
    private TextArea noteContentArea;

    @FXML
    private Button addNoteButton;

    @FXML
    private void addNote() {
        Note newNote = new Note();
        String noteTitle = noteTitleField.getText();
        String noteContent = noteContentArea.getText();

        System.out.println("Making note\n\tnoteTitle\n\tnoteContent");

        if(!noteTitle.isEmpty()) {
            newNote.setNoteTitle(noteTitle);
            newNote.setNoteContent(noteContent);
            noteBook.addNote(newNote);
            noteTitles.addAll(noteTitle);
            noteListContent.addAll(noteContent);
        }
        noteList.setItems(noteTitles);
    }

    public static void main(String[] args) {
        NoteBookView.launch(NoteBookView.class);
    }
}
