
public class ConverterView {
    public static final String INPUT_NUMBER = "Input a positive integer: ";
    public static final String WRONG_NEGATIVE_NUMBER = "Wrong input. The number must be positive integer. ";
    public static final String INPUT_NOTATION = "Input notation: ";
    public static final String WRONG_NOTATION = "Wrong input. The notation must be an 2, 8 or 16. ";

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printResultOfConvertation(int number, int notation, String result) {
        System.out.println("The number " + number + " in " + notation + "-notation is: " + result);
    }
}
