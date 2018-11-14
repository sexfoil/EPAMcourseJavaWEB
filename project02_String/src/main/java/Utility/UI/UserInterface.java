package Utility.UI;

import Views.TextToolsView;

import java.util.Scanner;

public class UserInterface {


    /**
     * Scanner instance.
     */
    private static Scanner scanner = new Scanner(System.in);


    /**
     * Returns {@code String} user input from console.
     *
     * @param view instance of View to output interface dialog.
     * @param infoMessage information for showing to user
     * @return user input
     */
    public static String getUserInputString(TextToolsView view, String infoMessage) {
        view.printMessage(infoMessage);
        return scanner.nextLine();
    }
}
