
import java.util.Scanner;

public class ConverterUtility {
    private static Scanner scanner = new Scanner(System.in);

    public static int[] inputIntValuesWithScanner(ConverterView view) {

        int[] data = new int[2];
        int value;
        boolean isValid;

        view.printMessage(ConverterView.INPUT_NUMBER);
        while (!(isValid = scanner.hasNextInt()) || (value = scanner.nextInt()) <= 0) {
            view.printMessage(ConverterView.WRONG_NEGATIVE_NUMBER + ConverterView.INPUT_NUMBER);
            if (!isValid) {
                scanner.next();
            }
        }
        data[0] = value;

        view.printMessage(ConverterView.INPUT_NOTATION);
        while (!(isValid = scanner.hasNextInt()) || ((value = scanner.nextInt()) != 2 && value != 8 && value != 16)) {
            view.printMessage(ConverterView.WRONG_NOTATION + ConverterView.INPUT_NOTATION);
            if (!isValid) {
                scanner.next();
            }
        }
        data[1] = value;

        return data;
    }
}
