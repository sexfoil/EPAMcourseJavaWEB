
import java.util.Random;

public class MatrixRotationModel {

    private int[][] matrix;

    public MatrixRotationModel() {
    }

    public int[][] getMatrix() {
        return matrix;
    }

    private void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void createMatrix(int size) {
        matrix = new int[size][size];
        Random random = new Random();

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                matrix[y][x] = random.nextInt(200) - 99;
            }
        }
    }

    public void rotateMatrixCounterclockwise90C() {
        int size = matrix.length;
        int[][] newMatrix = new int[size][size];

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                newMatrix[size - 1 - x][y] = matrix[y][x];
            }
        }
        setMatrix(newMatrix);
    }

}
