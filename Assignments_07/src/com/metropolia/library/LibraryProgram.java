package com.metropolia.library;

public class LibraryProgram {
    public static void main(String[] args) {
        Book introToJava = new Book("Introduction to Java Programming", "John Smith",2020),
                dataStructure = new Book("Data Structures and Algorithms", "Jane Doe",2018),
                artOfFiction = new Book("The Art of Fiction","Alice Johnson",2019);
        Library oodi = new Library();
        oodi.addBook(introToJava);
        oodi.addBook(dataStructure);
        oodi.addBook(artOfFiction);
        oodi.displayBooks();
        oodi.findBooksByAuthor("Jane Doe");
    }
}
