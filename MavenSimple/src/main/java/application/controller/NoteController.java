package application.controller;

import model.notebook.Note;
import model.notebook.NoteBook;

import java.util.ArrayList;

public class NoteController {
    private final NoteBook noteBook = new NoteBook();
    private final ArrayList<String> noteTitles;

    public NoteController() {
        noteTitles = new ArrayList<>();
        for (Note n : noteBook.getNotes()) {
            noteTitles.add(n.getNoteTitle());
        }
    }

    public ArrayList<String> getNoteTitles() {
        return noteTitles;
    }

    public void addNote(String noteTitle, String noteContent) {
        Note newNote = new Note();
        newNote.setNoteTitle(noteTitle);
        newNote.setNoteContent(noteContent);
        noteBook.addNote(newNote);
    }
}
