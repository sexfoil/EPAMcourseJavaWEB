package utility.UI;

import views.RBTview;

import java.util.Scanner;

public class UserInterface {

    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputAction(RBTview view, String infoMessage) {
        view.printMessage(infoMessage);
        return scanner.nextLine().trim().toLowerCase().split(" ");
    }
}