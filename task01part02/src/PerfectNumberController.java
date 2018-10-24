
public class PerfectNumberController {

    private PerfectNumberModel model;
    private PerfectNumberView view;

    public PerfectNumberController() {
        init();
    }

    private void init() {
        this.model = new PerfectNumberModel();
        this.view = new PerfectNumberView();
    }

    public void run() {
        int data = PerfectNumberUtility.inputIntValueWithScanner(view);
        model.searchingOfAllPerfectNumbers(data);
        view.printResultOfSearching(data, model.getNumbersList());
    }

}
