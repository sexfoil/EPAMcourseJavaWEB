package UI;

import Views.ShapesView;

import java.util.Scanner;


public class UserInterface {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputCommand(ShapesView view) {

        int value;
        boolean isValid;

        view.printMessage(ShapesView.MAKE_CHOISE);
        while (!(isValid = scanner.hasNextInt()) || !((value = scanner.nextInt()) >= 0 && value <= 8)) {
            view.printMessage(ShapesView.WRONG_INPUT + ShapesView.MAKE_CHOISE);
            if (!isValid) {
                scanner.next();
            }
        }
        scanner.nextLine();
        return value;
    }

}
