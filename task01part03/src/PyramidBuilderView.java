
public class PyramidBuilderView {
    public static final String INPUT_NUMBER = "Input an integer from 1 to 9: ";
    public static final String WRONG_NUMBER = "Wrong input. The number must be an integer from 1 to 9. ";

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printResultOfBuilding(int[][] pyramid) {
        for (int[] row : pyramid) {
            for (int item : row) {
                System.out.print(item == 0 ? " " : item);
            }
            System.out.println();
        }
    }
}
