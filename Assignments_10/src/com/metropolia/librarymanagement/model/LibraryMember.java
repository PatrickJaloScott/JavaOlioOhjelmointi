package com.metropolia.librarymanagement.model;

import com.metropolia.librarymanagement.system.Library;
import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private String name;
    private int memberID;
    private static int lastMemberID = 1;
    private List<Book> borrowedBooks, reservedBooks;

    public LibraryMember(String name) {
        this.name = name;
        this.memberID = lastMemberID++;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMemberID() {
        return memberID;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    /**
     borrow a book through the Library class
     */
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    /**
     reserve a book through the Library class
     */
    public void reserveBook(Book book) {
        reservedBooks.add(book);
    }

    /**
     * Use this method to cancel the reservation of a book by name
     * @param library the library where this book is reserved from
     * @param bookName the name of the reserved book that is to be cancelled
     */
    public void cancelReservation(Library library, String bookName) {
        Book bookToCancel = null;
        for (Book book : reservedBooks) {
            if (book.getTitle().equals(bookName)) {
                bookToCancel = book;
            }
        }
        if (bookToCancel != null) {
            library.cancelReservation(bookName);
            reservedBooks.remove(bookToCancel);
            System.out.println("Reservation for \"" + bookName + "\" was cancelled");
        }
        else {
            System.out.println("Could not find book \"" + bookName + "\" in reserved books");
        }
    }

    public void showReservedBooks() {
        System.out.println(name + "'s reserved books:");
        for (int i = 0; i < reservedBooks.size(); i++) {
            System.out.println("\t" + (i+1) + " " + reservedBooks.get(i));
        }
    }

    /**
     * Use this method to return a borrowed book back to the library
     * @param library the library to return the book to
     * @param bookName the name of the borrowed book
     */
    public void returnBook(Library library, String bookName) {
        Book bookToReturn = null;
        for (Book book : borrowedBooks) {
            if (book.getTitle().equals(bookName)) {
                bookToReturn = book;
                library.returnBook(book);
            }
        }
        borrowedBooks.remove(bookToReturn);
    }
}
