package utility.ui;

import views.View;

import java.util.Scanner;

public class UserInterface {

    private static Scanner scanner = new Scanner(System.in);

    public static String inputText(View view, String msg) {
        view.printMessage(msg);
        return scanner.nextLine();
    }
}
