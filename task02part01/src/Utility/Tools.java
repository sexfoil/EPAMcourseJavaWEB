package Utility;

import Models.BooksSet;
import Models.Entity.Book;
import Models.Entity.PublisherComparator;

import java.util.Arrays;

public class Tools {

    private BooksSet model;

    public Tools(BooksSet model) {
        this.model = model;
    }

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

    public Book[] sortByPublisher() {
        Book[] sorted = Arrays.copyOf(model.getBooks(), model.getBooks().length);
        PublisherComparator comparator = new PublisherComparator();
        Arrays.sort(sorted, comparator);
        return sorted;
    }

}
