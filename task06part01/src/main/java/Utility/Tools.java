package Utility;

import Models.BooksSet;
import Models.Entity.Book;
import Models.Entity.PublisherComparator;
import UI.UserInterface;
import Views.BooksView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service class to controls the data flow in model.
 *
 * @author Slava Poliakov
 * @version 2.0
 */
public class Tools {

    /**
     * Books set model
     */
    private BooksSet model;

    /**
     * Books view
     */
    private BooksView view;

    /**
     * File manager
     */
    private FileManager fileManager;


    /**
     * Constructs tools instance to interact with model.
     *
     * @param model books set
     */
    public Tools(BooksSet model, BooksView view) {
        this.model = model;
        this.view = view;
        fileManager = new FileManager(view);
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

    /**
     * Loads data to model from file
     */
    public void loadDataToModel() {
        boolean isLoadFromFile = false;
        while (!isLoadFromFile) {
            String dataFilePath = UserInterface.getUserInputString(view, BooksView.INPUT_PATH).trim();
            if (dataFilePath.length() == 0) {
                model.createBooksSet();
                view.printMessage( "Book's set was created from initial data...\n");
                break;
            }

            List<String> booksData = fileManager.getDataFromTextFile(dataFilePath);
            if (booksData != null) {
                int size = booksData.size();
                Book[] books = new Book[size];
                for (int i = 0; i < size; i++) {
                    String[] data = parseDataStringToArray(booksData.get(i));
                    Book book = new Book(
                            data[0], // name
                            data[1], // author
                            data[2], // publisher
                            Integer.parseInt(data[3]), // year
                            Integer.parseInt(data[4]), // pages
                            Double.parseDouble(data[5]) //price
                    );
                    books[i] = book;
                }
                model.setBooks(books);
                isLoadFromFile = true;
            }
        }
    }

    public void saveDataToFile(Book[] data) {
        boolean isSave = false;
        while (!isSave) {
            String dataFilePath = UserInterface.getUserInputString(view, BooksView.SAVE_RESULT).trim();
            if (dataFilePath.length() == 0) {
                break;
            }

            List<String> booksData = new ArrayList<>();
            for (Book book : data) {
                StringBuilder bookStr = new StringBuilder();
                bookStr.append("\"").append(book.getName()).append("\", ");
                bookStr.append(book.getAuthor()).append(", ");
                bookStr.append(book.getPublisher()).append(", ");
                bookStr.append("y.").append(book.getYear()).append(", ");
                bookStr.append("p.").append(book.getPages()).append(", ");
                bookStr.append("$").append(book.getPrice()).append("\n");

                booksData.add(bookStr.toString());
            }

            isSave = fileManager.saveDataToTextFile(dataFilePath, booksData);
        }

    }


    private String[] parseDataStringToArray(String str) {
        String[] array = str.split(", ");
        array[0] = array[0].substring(1, array[0].length() - 1);
        array[3] = array[3].substring(2);
        array[4] = array[4].substring(2);
        array[5] = array[5].substring(1); //, array[0].length() - 1);
        return array;
    }
}
