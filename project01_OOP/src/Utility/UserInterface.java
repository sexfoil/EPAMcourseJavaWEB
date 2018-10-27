package Utility;

import Views.ToysView;

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
    public static int inputCommand(ToysView view) {

        int value;
        boolean isValid;

        view.printMessage(ToysView.MAIN_MENU);
        while (!(isValid = scanner.hasNextInt()) || !((value = scanner.nextInt()) >= 0 && value <= 8)) {
            view.printMessage(ToysView.WRONG_INPUT + ToysView.MAIN_MENU);
            if (!isValid) {
                scanner.next();
            }
        }
        scanner.nextLine();
        return value;
    }

    /**
     * Returns {@code int} number of user choice.
     *
     * @param view instance of View to output interface dialog.
     * @param msg message to user.
     *
     * @return number of user choice
     */
    public static String[] inputParameter(ToysView view, String msg) {
        view.printMessage(msg);
        String line = null;
        String[] inputsArray;

        do {
            if (line != null) {
                view.printMessage(ToysView.EMPTY_INPUT);
            }
            line = scanner.nextLine();
            inputsArray = line.trim().split(" ");
        } while (inputsArray[0].length() == 0);

        return inputsArray;
    }

    /**
     * Returns {@code double} budget of playroom inputted by user.
     *
     * @param view instance of View to output interface dialog.
     *
     * @return budget of playroom
     */
    public static double inputBudget(ToysView view) {
        double value;
        boolean isValid;

        view.printMessage(ToysView.INPUT_BUDGET);
        while (!(isValid = scanner.hasNextDouble()) || !((value = scanner.nextInt()) > 0 && value <= 10000.0)) {
            view.printMessage(ToysView.WRONG_INPUT + ToysView.INPUT_BUDGET);
            if (!isValid) {
                scanner.next();
            }
        }
        scanner.nextLine();
        return value;
    }
}
