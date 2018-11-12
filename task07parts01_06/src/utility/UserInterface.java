package utility;

import java.util.Scanner;

public class UserInterface {

    public static final String BORDER = "\n------------------------------------------------------\n";

    public static final String MENU = "Select number:\n" +
            "1 - Reflection vol.1;\n" +
            "2 - Reflection vol.2;\n" +
            "3 - Lambda vol.1;\n" +
            "4 - Lambda vol.2;\n" +
            "5 - Lambda and Functional Interface;\n" +
            "6 - Streams;\n" +
            "0 - exit program.\n";


    private static Scanner scanner = new Scanner(System.in);

    public static int inputCommand() {

        int value;
        boolean isValid;

        while (!(isValid = scanner.hasNextInt()) || !((value = scanner.nextInt()) >= 0 && value <= 6)) {
            System.out.println("\nWrong input!\n");
            if (!isValid) {
                scanner.next();
            }
        }
        scanner.nextLine();
        return value;
    }

    public static String getUserInputString() {
        return scanner.nextLine();
    }
}
