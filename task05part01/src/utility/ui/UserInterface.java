package utility.ui;

import view.TeacherBookView;

import java.util.Scanner;

public class UserInterface {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputCommand(TeacherBookView view) {

        int value;
        boolean isValid;

        view.printMessage(TeacherBookView.MAIN_MENU);
        while (!(isValid = scanner.hasNextInt()) || !((value = scanner.nextInt()) >= 0 && value <= 2)) {
            view.printMessage(TeacherBookView.WRONG_INPUT + TeacherBookView.MAIN_MENU);
            if (!isValid) {
                scanner.next();
            }
        }
        scanner.nextLine();
        return value;
    }

    public static String inputData(TeacherBookView view, String msg) {
        view.printMessage(msg);
        String line = null;

        do {
            if (line != null) {
                view.printMessage(TeacherBookView.EMPTY_INPUT);
            }
            line = scanner.nextLine();
        } while (line.trim().length() == 0);

        return line;
    }
}
