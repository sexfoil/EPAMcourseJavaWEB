
public class MatrixRotationController {

    private MatrixRotationModel model;
    private MatrixRotationView view;

    public MatrixRotationController() {
        init();
    }

    private void init() {
        this.model = new MatrixRotationModel();
        this.view = new MatrixRotationView();
        createMatrix();
    }

    private void createMatrix() {
        int data = MatrixRotationUtility.inputIntValueWithScanner(view);
        model.createMatrix(data);
        view.printMessage("Matrix created...");
        view.printMatrix(model.getMatrix());
    }

    public void run() {
        model.rotateMatrixCounterclockwise90C();
        view.printMessage("Matrix rotated 90 degree counterclockwise...");
        view.printMatrix(model.getMatrix());
    }


}
