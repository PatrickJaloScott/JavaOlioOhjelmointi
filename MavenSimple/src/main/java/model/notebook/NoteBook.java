package model.notebook;

import java.util.ArrayList;

public class NoteBook {
    private final ArrayList<Note> notes;

    public NoteBook() {
        this.notes = new ArrayList<>();
    }

    public void addNote(String noteTitle, String noteContent) {
        this.notes.add(new Note(noteTitle, noteContent));
    }

    public void addNote(Note newNote) {
        this.notes.add(newNote);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public Note getNote(int noteIndex) {
        return this.notes.get(noteIndex);
    }
}
