package Utility;

import Views.ToysView;

import java.util.Scanner;

public class UserInterface {

    private static Scanner scanner = new Scanner(System.in);

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

}
