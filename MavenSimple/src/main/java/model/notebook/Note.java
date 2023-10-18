package model.notebook;

public class Note {
    private String noteTitle;
    private String noteContent;

    public Note() {}

    public Note(String title, String content) {
        this.noteTitle = title;
        this.noteContent = content;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
}
