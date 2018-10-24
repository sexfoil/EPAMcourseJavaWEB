package Views;

import Models.Entity.Book;


public class BooksView {

    public static final String TABLE_BORDER = String.format("+-%1$.15s-+-%1$s-+-%1$.10s-+-%1$.9s-+-%1$.11s-+-%1$.9s-+", "--------------------");
    public static final String MAKE_CHOISE = "Input command:\n" +
            "1 - search books by author;\n" +
            "2 - search books by publisher;\n" +
            "3 - search books by year;\n" +
            "4 - sort books by publisher;\n" +
            "5 - show all books;\n" +
            "0 - exit program.";
    public static final String START_INFO = "\nList of books";
    public static final String INPUT_AUTHOR = "Input author: ";
    public static final String BY_AUTHOR = " by author: ";
    public static final String INPUT_PUBLISHER = "Input publisher: ";
    public static final String BY_PUBLISHER = " by publisher: ";
    public static final String SORTED_BY_PUBLISHER = "sorted by publishers: ";
    public static final String INPUT_YEAR = "Input year: ";
    public static final String FROM_YEAR = " from year: ";
    public static final String WRONG_INPUT = "Wrong input. Try again...\n ";
    public static final String NO_RESULT = "No result found...\n ";

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printBooks(Book[] resultSet) {
        System.out.println(TABLE_BORDER);
        for (Book book : resultSet) {
            System.out.println(book);
        }
        System.out.println(TABLE_BORDER);
    }
}
