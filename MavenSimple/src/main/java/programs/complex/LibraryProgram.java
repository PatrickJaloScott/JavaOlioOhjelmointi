package programs.complex;

import model.library.*;

public class LibraryProgram {
    public static void main(String[] args) {
        Library oodi = new Library();

        Book introToJava = new Book("Introduction to Java Programming", "John Smith",2020, "12-345678-9"),
                dataStructure = new Book("Data Structures and Algorithms", "Jane Doe",2018, "13-456789-0"),
                artOfFiction = new Book("The Art of Fiction","Alice Johnson",2019, "14-567890-1"),
                amazingBook = new Book("The BEST book ever", "Amazing Author", 2013, "15-678901-2"),
                worstBook = new Book("Worst book", "Terrible Author", 2015, "16-789012-3");

        User john = new User("John", 25),
                james = new User("James", 21),
                jack = new User("Jack", 15),
                jill = new User("Jill", 27);

        introToJava.setRating(4);
        dataStructure.setRating(3);
        artOfFiction.setRating(2);
        amazingBook.setRating(5);
        worstBook.setRating(1);

        oodi.addBook(introToJava);
        oodi.addBook(dataStructure);
        oodi.addBook(artOfFiction);
        oodi.addBook(amazingBook);

        oodi.addUser(john);
        oodi.addUser(james);
        oodi.addUser(jack);
        oodi.addUser(jill);

        oodi.displayBooks();
        oodi.findBooksByAuthor("Jane Doe");

        oodi.borrowBookByTitle(john, "Introduction to Java Programming");
        oodi.borrowBookByTitle(jack,"Introduction to Java Programming");
        john.returnBook(oodi, "Introduction to Java Programming");
        oodi.borrowBookByTitle(james, "Introduction to Java Programming");

        String bookName = "How to write a book";
        if (oodi.isBookAvailable(bookName)) {
            System.out.println("\nBook: " + bookName + " found");
        }
        else {
            System.out.println("\nBook: \"" + bookName + "\" not found");
        }
        oodi.borrowBookByTitle(jack, bookName);

        oodi.reserveBook(jill, "Introduction to Java Programming");
        oodi.reserveBook(james, "Introduction to Java Programming");
        jill.showReservedBooks();
        jill.cancelReservation(oodi, "Introduction to Java Programming");
        oodi.reserveBook(jill, "The Art of Fiction");
        jill.showReservedBooks();

        amazingBook.addReview("Awesome!");
        amazingBook.addReview("The best!!");
        amazingBook.addReview("Can't wait for the sequel!");

        System.out.printf("\nThe average book rating is %.2f\n", oodi.getAverageBookRating());
        System.out.println("The most reviewed book is: " + oodi.getMostReviewedBook().getTitle());
    }
}
