package controller;

import model.Model;
import utility.ui.UserInterface;
import view.View;
import utility.tools.Creator;
import utility.tools.Validator;

import java.util.Set;

public class Controller {

    private Model model;
    private View view;
    private Creator creator;
    private Validator validator;

    public Controller() {
        model = new Model();
        view = new View();
        creator = new Creator();
        validator = new Validator(view);
    }

    public void run() {
        view.printMessage("WELCOME!!!\n");

        createCollections();

        view.printMessage("LIST:");
        view.printCollection(model.getListOfElements());

        view.printMessage("\nSET:");
        view.printCollection(model.getSetOfElements());

        view.printMessage("\nHAVE A NICE DAY!!!");
    }

    private void createCollections() {
        int collectionSize = validator.getValidCollectionSize();
        int minValue = validator.getValidMinimumNumber(Integer.MIN_VALUE, Integer.MAX_VALUE, collectionSize);
        int maxValue = validator.getValidMaximumNumber(minValue, Integer.MAX_VALUE, collectionSize);

        model.setListOfElements(creator.getListOfElements(minValue, maxValue, collectionSize));
        model.setSetOfElements(creator.getSetOfElements(minValue, maxValue, collectionSize));
    }


}
