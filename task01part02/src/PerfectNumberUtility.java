
import java.util.Scanner;

public class PerfectNumberUtility {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputIntValueWithScanner(PerfectNumberView view) {

        int value;
        boolean isValid;

        view.printMessage(PerfectNumberView.INPUT_NUMBER);
        while (!(isValid = scanner.hasNextInt()) || !((value = scanner.nextInt()) >= 1)) {
            view.printMessage(PerfectNumberView.WRONG_NEGATIVE_NUMBER + PerfectNumberView.INPUT_NUMBER);
            if (!isValid) {
                scanner.next();
            }
        }

        return value;
    }
}
