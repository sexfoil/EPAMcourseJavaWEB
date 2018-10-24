
import java.util.ArrayList;

public class PerfectNumberModel {

    ArrayList<Integer> numbersList;

    public PerfectNumberModel() {
    }

    public ArrayList<Integer> getNumbersList() {
        return numbersList;
    }

    private void setNumbersList(ArrayList<Integer> numbersList) {
        this.numbersList = numbersList;
    }

    public void searchingOfAllPerfectNumbers(int maxNumber) {

        ArrayList<Integer> numbersList = new ArrayList();

        for (int number = 4; number <= maxNumber; number++) {
            if (isPerfectNumber(number)) {
                numbersList.add(number);
            }
        }
        setNumbersList(numbersList);
    }

    private boolean isPerfectNumber(int number) {
        int sum = 0;
        for (int divider = 1; divider <= number / 2; divider++) {
            if (number % divider == 0) {
                sum += divider;
            }
        }
        return sum == number;
    }
}
