
public class MatrixRotationView {

    public static final String INPUT_NUMBER = "Input size of matrix N: ";
    public static final String WRONG_NUMBER = "Wrong input. The size of matrix must be a positive integer: N > 1. ";

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int item : row) {
                System.out.print(String.format("%3d ", item));
            }
            System.out.println();
        }
    }

}
