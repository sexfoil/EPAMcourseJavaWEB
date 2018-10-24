package UI;

import Views.BooksView;

import java.util.Scanner;


public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

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

    public static String inputName(BooksView view, String searchingParam) {

        view.printMessage(searchingParam);
        String data = scanner.nextLine();

        return data;
    }
}
