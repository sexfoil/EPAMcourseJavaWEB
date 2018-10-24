
public class ConverterController {

    private ConverterModel model;
    private ConverterView view;

    public ConverterController() {
        init();
    }

    private void init() {
        this.model = new ConverterModel();
        this.view = new ConverterView();
    }

    public void run() {
        int[] data = ConverterUtility.inputIntValuesWithScanner(view);
        model.convertNumber(data[0], data[1]);
        view.printResultOfConvertation(data[0], data[1], model.getConvertedNumber());
    }
}
