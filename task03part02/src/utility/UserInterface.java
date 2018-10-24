package utility;

import view.ShopView;

import java.util.Scanner;

public class UserInterface {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputCommand(ShopView view, int maxCommands) {

        int value;
        boolean isValid;

        view.printMessage(ShopView.MAIN_MENU);
        while (!(isValid = scanner.hasNextInt()) || !((value = scanner.nextInt()) >= 0 && value <= maxCommands)) {
            view.printMessage(ShopView.WRONG_INPUT + ShopView.MAIN_MENU);
            if (!isValid) {
                scanner.next();
            }
        }
        scanner.nextLine();
        return value;
    }

    public static String[] inputParameters(ShopView view, String msg) {
        view.printMessage(msg);
        String line = null;
        String[] inputsArray;

        do {
            if (line != null) {
                view.printMessage(ShopView.EMPTY_INPUT);
            }
            line = scanner.nextLine();
            inputsArray = line.trim().split(" ");
        } while (inputsArray[0].length() == 0);

        return inputsArray;
    }

}
