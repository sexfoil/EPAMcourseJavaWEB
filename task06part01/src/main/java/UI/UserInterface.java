package UI;

import Views.BooksView;

import java.util.Scanner;

/**
 * Service class to get user's inputs.
 * Contains only static methods. Uses class {@code Scanner} to get input from user.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Scanner
 */
public class UserInterface {

    /**
     * Scanner instance.
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Returns {@code int} number of user choice.
     *
     * @param view instance of View to output interface dialog.
     *
     * @return number of user choice
     */
    public static int inputCommand(BooksView view) {

        int value;
        boolean isValid;

        view.printMessage(BooksView.MAKE_CHOISE);
        while (!(isValid = scanner.hasNextInt()) || !((value = scanner.nextInt()) >= 0 && value <= 5)) {
            view.printMessage(BooksView.WRONG_INPUT + BooksView.MAKE_CHOISE);
            if (!isValid) {
                scanner.next();
            }
        }
        scanner.nextLine();
        return value;
    }

    /**
     * Returns {@code int} year of book's publication.
     *
     * @param view instance of View to output interface dialog
     *
     * @return year of book's publication
     */
    public static int inputYear(BooksView view) {

        int value;
        boolean isValid;

        view.printMessage(BooksView.INPUT_YEAR);
        while (!(isValid = scanner.hasNextInt()) || !((value = scanner.nextInt()) > 0)) {
            view.printMessage(BooksView.WRONG_INPUT);
            if (!isValid) {
                scanner.next();
            }
        }
        scanner.nextLine();
        return value;
    }

    /**
     * Returns {@code String} user input from console.
     *
     * @param view instance of View to output interface dialog.
     * @param searchingParam parameter for searching
     * @return user input
     */
    public static String inputName(BooksView view, String searchingParam) {

        view.printMessage(searchingParam);
        String data = scanner.nextLine();

        return data;
    }
}
