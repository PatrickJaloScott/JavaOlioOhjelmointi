package com.metropolia.librarymanagement.model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int reservedMemberID = 0;

    /**
    * Create a new book with a title, author and ISBN-code
     * @param author name of the author of the book
     * @param title title of the book
     * @param isbn ISBN code of the book
    * */
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return isbn;
    }

    /**
     set the reserving member id and return a true/false value depending on the current book status
     */
    public boolean setReservation(int memberID) {
        boolean canReserve = true;
        if(reservedMemberID == 0) {
            reservedMemberID = memberID;
        }
        else {
           canReserve = false;
        }
        return canReserve;
    }

    public boolean canBorrow(LibraryMember member) {
        return (reservedMemberID == 0 || reservedMemberID == member.getMemberID());
    }

    @Override
    public String toString() {
        return title + ", " + author;
    }
}
