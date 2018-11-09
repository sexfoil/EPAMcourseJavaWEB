package utility.UI;

import views.RBTview;

import java.util.Scanner;

public class UserInterface {

    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputAction(RBTview view, String infoMessage) {
        String[] input = null;
        do {
            if (input != null) {
                view.printMessage("\nINVALID INPUT!!!\n");
            }
            view.printMessage(infoMessage);
            input = scanner.nextLine().trim().toLowerCase().split(" ");
        } while (input.length > 1 && !input[1].matches("^[1-9][\\d]*$"));
        return input;
    }
}