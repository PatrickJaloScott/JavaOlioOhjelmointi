package model.library;

import java.util.ArrayList;

public class User {
    private String name;
    private int age, memberID;
    private static int lastMemberID = 1;
    ArrayList<Book> borrowedBooks, reservedBooks;

    public User(String username, int userAge) {
        this.name = username;
        this.age = userAge;
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

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        String title = book.getTitle();
        borrowedBooks.add(book);
        System.out.println(this.name + " borrowed " + title);
    }

    public void returnBook(Library library, String bookTitle) {
        Book bookToReturn = null;
        for (Book b : borrowedBooks) {
            if(b.getTitle().equals(bookTitle)) {
                bookToReturn = b;
            }
        }
        borrowedBooks.remove(bookToReturn);
        library.returnBook(bookToReturn);
    }

    public void reserveBook(Book book) {
        reservedBooks.add(book);
    }

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
}
