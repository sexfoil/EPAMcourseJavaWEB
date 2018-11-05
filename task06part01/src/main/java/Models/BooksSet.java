package Models;

import Models.Entity.Book;

/**
 * This class is the Model in MVC Pattern - represents containing set of books.
 *
 * @author Slava Poliakov
 * @version 1.0
 */
public class BooksSet {
    /**
     * Set of books
     */
    private Book[] books;


    /**
     * Default constructor.
     */
    public BooksSet() {
        //setBooks(createBooksSet());
    }

    /**
     * Creates set of books by default
     */
    public void createBooksSet() {
        books = new Book[] {
                new Book("Thinking in Java", "B. Eckel", "Caravela", 2007, 1150, 999.99),
                new Book("Dr. No", "I. Fleming", "Komubook", 1958, 122, 105.11),
                new Book("To The Lighthouse", "V. Woolf", "New Time", 2000, 333, 50.00),
                new Book("Diamonds Are Forever", "I. Fleming", "Komubook", 1956, 104, 88.25),
                new Book("Core Java", "C. Horstmann", "Caravela", 2018, 864, 222.22),
                new Book("War and Peace", "L. Tolstoy", "Port-Royal", 1999, 1233, 122.35),
                new Book("A Byte of Python", "С. Swaroop", "Caravela", 2012, 151, 555.55),
                new Book("Great Expectations", "C. Dickens", "New Time", 2001, 100, 70.99),
                new Book("Casino Royale", "I. Fleming", "Komubook", 1953, 130, 99.99),
                new Book("The Spy Who Loved Me", "I. Fleming", "Komubook", 1962, 150, 100.00),
                new Book("Master and Margarita", "M. Bulgakov", "Caravela", 1967, 205, 500.00),
                new Book("Lolita", "V. Nabokov", "Discursus", 1993, 269, 21.60),
                new Book("Anna Karenina", "L. Tolstoy", "Port-Royal", 1993, 524, 76.88)
        };
    }

    /**
     * Returns set of books.
     *
     * @return set of books
     */
    public Book[] getBooks() {
        return books;
    }

    /**
     * Set books to array of books.
     *
     * @param books book's array
     */
    public void setBooks(Book[] books) {
        this.books = books;
    }
}
