
public class PyramidBuilderController {

    private PyramidBuilderModel model;
    private PyramidBuilderView view;

    public PyramidBuilderController() {
        init();
    }

    private void init() {
        this.model = new PyramidBuilderModel();
        this.view = new PyramidBuilderView();
    }

    public void run() {
        int data = PyramidBuilderUtility.inputIntValueWithScanner(view);
        model.createPyramid(data);
        view.printResultOfBuilding(model.getPyramid());
    }

}
