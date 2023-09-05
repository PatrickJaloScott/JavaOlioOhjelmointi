package com.metropolia.library;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void addUser(User u) {
        users.add(u);
    }

    void displayBooks() {
        System.out.println("\nLibrary Catalog:");
        for(Book b : books) {
            System.out.println(books.indexOf(b)+1 + ". Title: " + b.getTitle() + ", Author: " + b.getAuthor() + ", Year: " + b.getPublicationYear());
        }
    }

    void findBooksByAuthor(String author) {
        System.out.println("\nBooks by Author " + author);
        for (Book b : books) {
            if (b.getAuthor().equals(author)) {
                System.out.println("Title: " + b.getTitle() + ", Year: " + b.getPublicationYear());
            }
        }
    }

    Book borrowBook(String title) {
        Book bookToBorrow = null;
        for (Book b : books) {
            if (b.getTitle().equals(title) && bookToBorrow == null) {
                bookToBorrow = b;
            }
        }
        if (bookToBorrow != null) {
            books.remove(bookToBorrow);
            System.out.println("\nTitle: " + title + " was borrowed");
        }
        else {
            System.out.println("\nCould not find book: " + title);
        }
        return bookToBorrow;
    }

    void returnBook(Book book) {
        books.add(book);
        System.out.println("\nReturned book: " + book.getTitle());
    }

    boolean isBookAvailable(String title) {
        boolean isAvailable = false;
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                isAvailable = true;
            }
        }
        return isAvailable;
    }

    double getAverageBookRating() {
        double averageRating = 0;
        for (Book b : books) {
            averageRating += b.getRating();
        }
        averageRating /= books.size();
        return averageRating;
    }

    Book getMostReviewedBook() {
        Book bestBook = books.get(0);
        for (Book b : books) {
            if(b.getReviewAmount() > bestBook.getReviewAmount()) {
                bestBook = b;
            }
        }
        return bestBook;
    }
}
