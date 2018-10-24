
import java.util.Scanner;

public class PyramidBuilderUtility {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputIntValueWithScanner(PyramidBuilderView view) {

        int value;
        boolean isValid;

        view.printMessage(PyramidBuilderView.INPUT_NUMBER);
        while (!(isValid = scanner.hasNextInt()) || !((value = scanner.nextInt()) >= 1 && value <= 9)) {
            view.printMessage(PyramidBuilderView.WRONG_NUMBER + PyramidBuilderView.INPUT_NUMBER);
            if (!isValid) {
                scanner.next();
            }
        }

        return value;
    }
}
