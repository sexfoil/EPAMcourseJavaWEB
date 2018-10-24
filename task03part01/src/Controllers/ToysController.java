package Controllers;

import Models.Entity.Comparators.MaterialComparator;
import Models.Entity.Comparators.PriceComparator;
import Models.Entity.Comparators.TypeComparator;
import Models.Entity.Comparators.WeightComparator;
import Models.Entity.Toy;
import Models.ToysSet;
import Utility.Tools;
import Utility.UserInterface;
import Views.ToysView;

import java.util.ArrayList;
import java.util.Arrays;

public class ToysController<T extends Toy> {

    private ToysSet<T> model;
    private ToysView<T> view;
    private Tools tools;

    public ToysController() {
        init();
    }

    private void init() {
        model = new ToysSet<>();
        view = new ToysView<>();
        tools = new Tools(model);
    }

    public void run() {

        view.printMessage("WELCOME TO TOYS ROOM!!!\n");
        application:
        while (true) {
            int command = UserInterface.inputCommand(view);
            String[] inputParams;
            ArrayList<T> resultSet = null;
            switch (command) {
                case 1:
                    view.printMessage(ToysView.START_INFO + ":");
                    view.printToys(model.getToys());
                    break ;
                case 2:
                    view.printMessage(ToysView.SUM_OF_PRICES);
                    view.printMessage(String.format("$ %.2f", tools.calculatePrices()));
                    break;
                case 3:
                    inputParams = UserInterface.inputParameter(view, ToysView.SORT_MENU);
                    if (!inputParams[0].equals("back")){
                        switch (inputParams[0]) {
                            case "type":
                                resultSet = tools.sortToys(new TypeComparator());
                                break;
                            case "price":
                                resultSet = tools.sortToys(new PriceComparator());
                                break;
                            case "weight":
                                resultSet = tools.sortToys(new WeightComparator());
                                break;
                            case "material":
                                resultSet = tools.sortToys(new MaterialComparator());
                                break;
                            default:
                                view.printMessage("Unknown or wrong parameter to sorting...");
                        }
                        if (resultSet != null) {
                            view.printMessage(ToysView.START_INFO + ToysView.SORTED_BY + "'" + inputParams[0] + "':");
                            view.printToys(resultSet);
                        }
                    }
                    break;
                case 4:
                    inputParams = UserInterface.inputParameter(view, ToysView.SELECT_MENU);
                    if (!inputParams[0].equals("back")){
                        resultSet = tools.selectToys(inputParams);
                        if (resultSet.size() != 0) {
                            view.printMessage(ToysView.START_INFO + ToysView.SELECTED_BY + "'" + Arrays.toString(inputParams) + "':");
                            view.printToys(resultSet);
                        } else {
                            view.printMessage("Unknown or wrong parameters to selecting...");
                        }
                    }
                    break;
                case 0:
                    view.printMessage("\nSEE YOU AND HAVE A NICE DAY!!!");
                    break application;
            }
        }

    }
}
