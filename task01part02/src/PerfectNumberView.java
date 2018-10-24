
import java.util.ArrayList;

public class PerfectNumberView {
    public static final String INPUT_NUMBER = "Input a positive integer: ";
    public static final String WRONG_NEGATIVE_NUMBER = "Wrong input. The number must be positive integer. ";

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printResultOfSearching(int maxNum, ArrayList<Integer> numbers) {
        System.out.println("Perfect numbers from 1 to " + maxNum + ":");
        for (Integer num : numbers) {
            System.out.println(num);
        }
    }
}
