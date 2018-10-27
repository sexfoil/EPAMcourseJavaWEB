package Controllers;

import Utility.Comparators.*;
import Models.Entity.Toy;
import Models.PlayRoom;
import Utility.Tools;
import Utility.UserInterface;
import Views.ToysView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is the Controller in MVC Pattern - controls the data flow into {@code PlayRoom<T extends Toy>}
 * object and updates the {@code ToysView<T extends Toy>} whenever data changes.
 *
 * @author Slava Poliakov
 * @version 1.0
 */
public class ToysController<T extends Toy> {

    /**
     * Model object.
     */
    private PlayRoom<T> model;

    /**
     * View object.
     */
    private ToysView<T> view;

    /**
     * Set of tools to controls the data flow.
     */
    private Tools<T> tools;

    /**
     * Constructs a controller to controls the data flow.
     */
    public ToysController() {
        init();
    }


    /**
     * Initializes model, view and tools objects.
     */
    private void init() {
        model = new PlayRoom<>();
        view = new ToysView<>();
        tools = new Tools<>(model);
    }

    /**
     * Starts work of controller.
     */
    public void run() {
        view.printMessage("WELCOME TO PLAYROOM!!!\n");

        double playroomBudget = UserInterface.inputBudget(view);

        tools.setToysInPlayRoom(playroomBudget);
        view.printMessage(String.format("Playroom created accordance with your budget: $%.2f", playroomBudget));

        application:
        while (true) {
            int command = UserInterface.inputCommand(view);
            String[] inputParams;
            ArrayList<T> resultSet = null;
            switch (command) {
                case 1:
                    view.printMessage(ToysView.START_INFO + ":");
                    view.printToys(model.getToys());
                    break;
                case 2:
                    view.printMessage(ToysView.SUM_OF_PRICES);
                    view.printMessage(String.format("$ %.2f", tools.calculatePrices()));
                    break;
                case 3:
                    inputParams = UserInterface.inputParameter(view, ToysView.SORT_MENU);
                    if (!inputParams[0].toLowerCase().equals("back")) {
                        switch (inputParams[0].toLowerCase()) {
                            case "type":
                                resultSet = tools.sortToys(new TypeComparator());
                                break;
                            case "price":
                                resultSet = tools.sortToys(new PriceComparator());
                                break;
                            case "name":
                                resultSet = tools.sortToys(new NameComparator());
                                break;
                            case "material":
                                resultSet = tools.sortToys(new MaterialComparator());
                                break;
                            case "age":
                                resultSet = tools.sortToys(new AgeComparator());
                                break;
                            case "madden":
                                resultSet = tools.sortToys(new OriginComparator());
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
                    if (!inputParams[0].toLowerCase().equals("back")) {
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
