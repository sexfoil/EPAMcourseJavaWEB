package Utility;

import Models.BooksSet;
import Models.Entity.Book;
import Models.Entity.PublisherComparator;

import java.util.Arrays;

/**
 * Service class to controls the data flow in model.
 *
 * @author Slava Poliakov
 * @version 1.0
 */
public class Tools {

    /**
     * Books set model
     */
    private BooksSet model;


    /**
     * Constructs tools instance to interact with model.
     *
     * @param model books set
     */
    public Tools(BooksSet model) {
        this.model = model;
    }

    /**
     * Returns list of books of author provided.
     *
     * @param author name of author
     * @return list of books
     */
    public Book[] searchByAuthor(String author) {
        Book[] result = new Book[model.getBooks().length];
        int index = 0;
        for (Book book : model.getBooks()) {
            if (book.getAuthor().equals(author)) {
                result[index++] = book;
            }
        }
        return Arrays.copyOf(result, index);
    }

    /**
     * Returns list of books from year of publication.
     *
     * @param year year of publication
     * @return list of books
     */
    public Book[] searchByYear(int year) {
        Book[] result = new Book[model.getBooks().length];
        int index = 0;
        for (Book book : model.getBooks()) {
            if (book.getYear() >= year) {
                result[index++] = book;
            }
        }
        return Arrays.copyOf(result, index);
    }

    /**
     * Returns list of books of publisher provided.
     *
     * @param publisher name of publisher
     * @return list of books
     */
    public Book[] searchByPublisher(String publisher) {
        Book[] result = new Book[model.getBooks().length];
        int index = 0;
        for (Book book : model.getBooks()) {
            if (book.getPublisher().equals(publisher)) {
                result[index++] = book;
            }
        }
        return Arrays.copyOf(result, index);
    }

    /**
     * Returns list of all books sorted by publisher.
     *
     * @return list of sorted books
     */
    public Book[] sortByPublisher() {
        Book[] sorted = Arrays.copyOf(model.getBooks(), model.getBooks().length);
        PublisherComparator comparator = new PublisherComparator();
        Arrays.sort(sorted, comparator);
        return sorted;
    }

}
