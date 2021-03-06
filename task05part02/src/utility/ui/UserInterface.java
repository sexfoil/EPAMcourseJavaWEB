package utility.ui;

import view.View;

import java.util.Scanner;

public class UserInterface{

    private static Scanner scanner = new Scanner(System.in);

    public static int inputNumber(View view, int minValue, int maxValue, String message) {

        int value;
        boolean isValid;

        view.printMessage(message);
        while (!(isValid = scanner.hasNextInt()) || !((value = scanner.nextInt()) >= minValue && value <= maxValue)) {
            if (!isValid) {
                view.printMessage(View.WRONG_INPUT);
                scanner.next();
            } else {
                view.printMessage(View.INVALID_INPUT_VALUE);
            }
        }

        scanner.nextLine();
        return value;
    }

}
