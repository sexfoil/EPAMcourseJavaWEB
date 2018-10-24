
import java.util.Scanner;

public class MatrixRotationUtility {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputIntValueWithScanner(MatrixRotationView view) {

        int value;
        boolean isValid;

        view.printMessage(MatrixRotationView.INPUT_NUMBER);
        while (!(isValid = scanner.hasNextInt()) || !((value = scanner.nextInt()) >= 2 && value <= Integer.MAX_VALUE)) {
            view.printMessage(MatrixRotationView.WRONG_NUMBER + MatrixRotationView.INPUT_NUMBER);
            if (!isValid) {
                scanner.next();
            }
        }

        return value;
    }
}
