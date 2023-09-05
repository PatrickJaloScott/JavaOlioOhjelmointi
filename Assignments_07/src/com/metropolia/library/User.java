package com.metropolia.library;

import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(String username, int userAge) {
        this.name = username;
        this.age = userAge;
    }

    void borrowBook(Library library, String title) {
        if(library.isBookAvailable(title)) {
            borrowedBooks.add(library.borrowBook(title));
            System.out.println(this.name + " borrowed " + title);
        }
        else {
            System.out.println(this.name + " couldn't find \"" + title + "\"");
        }
    }

    void returnBook(Library library, String title) {
        Book book = new Book();
        for (Book b : borrowedBooks) {
            if(b.getTitle().equals(title)) {
                book = b;
            }
        }
        borrowedBooks.remove(book);
        library.returnBook(book);
    }
}
