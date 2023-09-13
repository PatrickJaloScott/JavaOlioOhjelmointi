package com.metropolia.librarymanagement;

import com.metropolia.librarymanagement.model.*;
import com.metropolia.librarymanagement.system.Library;

public class Main {
    public static void main(String[] args) {
        Library mainLibrary = new Library();

        Book book1 = new Book("Amazing book", "Best Author", "44-2255.33");
        Book book2 = new Book("Worst book", "Terrible Author", "55-2333.43");

        LibraryMember member1 = new LibraryMember("John Johnson");
        LibraryMember member2 = new LibraryMember("Jack Jackson");

        mainLibrary.addBook(book1);
        mainLibrary.addBook(book2);
        mainLibrary.addMember(member1);
        mainLibrary.addMember(member2);
        System.out.println("Books: " + mainLibrary.getListedBooks().size() + ", Library Members: " + mainLibrary.getListedMembers().size());

        mainLibrary.borrowBookByName(member1, "Amazing book");
        mainLibrary.borrowBookByID(member2, "55-2333.43");
        mainLibrary.borrowBookByName(member1, "Worst book");
        mainLibrary.borrowBookByID(member2, "44-2255.33");
        System.out.println("Borrowed books: " + mainLibrary.getBorrowedBooks().size());

        member1.returnBook(mainLibrary, "Amazing book");
        member2.returnBook(mainLibrary, "Worst book");
        System.out.println("Borrowed books: " + mainLibrary.getBorrowedBooks().size());
        System.out.println();
        mainLibrary.reserveBook(member1, "Worst book");
        mainLibrary.reserveBook(member2, "Worst book");
        member1.showReservedBooks();
        member1.cancelReservation(mainLibrary, "Worst book");
        mainLibrary.reserveBook(member1, "Amazing book");
        member1.showReservedBooks();
        mainLibrary.borrowBookByName(member1, "Amazing book");
    }
}
