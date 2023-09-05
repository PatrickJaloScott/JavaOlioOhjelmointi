package com.metropolia.library;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void displayBooks() {
        System.out.println("Library Catalog:");
        for(Book b : books) {
            System.out.println(books.indexOf(b) + ". Title: " + b.getTitle() + ", Author" + b.getAuthor() + ", Year: " + b.getPublicationYear());
        }
    }

    void findBooksByAuthor(String author) {
        System.out.println("Books by Author " + author);
        for (Book b : books) {
            if (b.getAuthor().equals(author)) {
                System.out.println("Title: " + b.getTitle() + ", Year: " + b.getPublicationYear());
            }
        }
    }
}
