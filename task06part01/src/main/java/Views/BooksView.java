package Views;

import Models.Entity.Book;

/**
 * This class is the View in MVC Pattern - represents the visualization of the data that model contains.
 *
 * @author Slava Poliakov
 * @version 1.0
 */
public class BooksView {

    /**
     * String that represents border of data's table
     */
    public static final String TABLE_BORDER = String.format("+-%1$.15s-+-%1$s-+-%1$.10s-+-%1$.9s-+-%1$.11s-+-%1$.9s-+", "--------------------");

    /**
     * String that represents main menu
     */
    public static final String MAKE_CHOISE = "Input command:\n" +
            "1 - search books by author;\n" +
            "2 - search books by publisher;\n" +
            "3 - search books by year;\n" +
            "4 - sort books by publisher;\n" +
            "5 - show all books;\n" +
            "0 - exit program.";

    /**
     * String that represents message to user about data source
     */
    public static final String INPUT_PATH = "\nInput 'path and filename' to load data from file or empty string to load initial data:";

    /**
     * String that represents begin of message about list
     */
    public static final String START_INFO = "\nList of books";

    /**
     * String that represents message to user to input author
     */
    public static final String INPUT_AUTHOR = "Input author: ";

    /**
     * String that represents end of message about searching by author
     */
    public static final String BY_AUTHOR = " by author: ";

    /**
     * String that represents message to user to input publisher
     */
    public static final String INPUT_PUBLISHER = "Input publisher: ";

    /**
     * String that represents end of message about searching by publisher
     */
    public static final String BY_PUBLISHER = " by publisher: ";

    /**
     * String that represents end of message about sorted list
     */
    public static final String SORTED_BY_PUBLISHER = " sorted by publishers: ";

    /**
     * String that represents message to user to input year
     */
    public static final String INPUT_YEAR = "Input year: ";

    /**
     * String that represents end of message about searching by year
     */
    public static final String FROM_YEAR = " from year: ";

    /**
     * String that represents message to user about wrong input
     */
    public static final String WRONG_INPUT = "Wrong input. Try again...\n ";

    /**
     * String that represents message to user about saving of results
     */
    public static final String SAVE_RESULT = "\nInput 'path and filename' for saving results to file " +
                                                "or empty string to exit without saving:\n ";

    /**
     * String that represents message to user about no result
     */
    public static final String NO_RESULT = "No result found...\n ";


    /**
     * Output message to console.
     *
     * @param msg message to be outputted
     */
    public void printMessage(String msg) {
        System.out.println(msg);
    }

    /**
     * Outputs set of books as table.
     *
     * @param resultSet set of toys to be outputted
     */
    public void printBooks(Book[] resultSet) {
        System.out.println(TABLE_BORDER);
        for (Book book : resultSet) {
            System.out.println(book);
        }
        System.out.println(TABLE_BORDER);
    }
}
