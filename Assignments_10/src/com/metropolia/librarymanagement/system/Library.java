package com.metropolia.librarymanagement.system;

import com.metropolia.librarymanagement.model.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private ArrayList<Book> listedBooks = new ArrayList<>(),
    borrowedBooks = new ArrayList<>(),
    reservedBooks = new ArrayList<>();
    private ArrayList<LibraryMember> listedMembers = new ArrayList<>();

    public void addBook(Book newBook) {
        listedBooks.add(newBook);
    }

    public void addMember(LibraryMember newMember) {
        listedMembers.add(newMember);
    }

    /**
     * Borrow a book through this method or the borrowBookByID method
     * @param member the member who is borrowing {@code bookName}
     * @param bookName the book being borrowed
     */
    public void borrowBookByName(LibraryMember member, String bookName) {
        for (Book book : listedBooks) {
            if (book.getTitle().equals(bookName)) {
                if (!borrowedBooks.contains(book) && book.canBorrow(member)) {
                    borrowedBooks.add(book);
                    member.borrowBook(book);
                    System.out.println("Book \"" + bookName + "\" was borrowed");
                }
                else {
                    System.out.println("Book \"" + bookName + "\" could not be borrowed");
                }
            }
        }
    }

    /**
     * Borrow a book through this method or the borrowBookByName method
     * @param member the member who is borrowing {@code id}
     * @param id the ID of the book to be borrowed
     */
    public void borrowBookByID(LibraryMember member, String id) {
        for (Book book : listedBooks) {
            if (book.getISBN().equals(id)) {
                if (!borrowedBooks.contains(book) && book.canBorrow(member)) {
                    borrowedBooks.add(book);
                    member.borrowBook(book);
                    System.out.println("Book \"" + id + "\" was borrowed");
                }
                else {
                    System.out.println("Book \"" + id + "\" could not be borrowed");
                }
            }
        }
    }

    /**
     * Reserve a book through this method, using the book's name to find it
     * @param member the member making a reservation
     * @param bookName the name of the book being reserved
     */
    public void reserveBook(LibraryMember member, String bookName) {
        for (Book book : listedBooks) {
            if (book.getTitle().equals(bookName)) {
                if(book.setReservation(member.getMemberID())) {
                    member.reserveBook(book);
                    reservedBooks.add(book);
                    System.out.println(member.getName() + " made a reservation for \"" + bookName + "\"");
                }
                else {
                    System.out.println("Book \"" + bookName + "\" could not be reserved");
                }
            }
        }
    }

    /**
     cancel a book reservation through the Library Member class
     */
    public void cancelReservation(String bookName) {
        Book bookToCancel = null;
        for (Book book : reservedBooks) {
            if (book.getTitle().equals(bookName)) {
                bookToCancel = book;
            }
        }
        if(bookToCancel != null) {
            bookToCancel.setReservation(0);
            reservedBooks.remove(bookToCancel);
        }
    }

    /**
     return a book through the Library Member class
     */
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println("Returned \"" + book.getTitle() + "\"");
    }

    public List<Book> getListedBooks() {
        return listedBooks;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<LibraryMember> getListedMembers() {
        return listedMembers;
    }
}
