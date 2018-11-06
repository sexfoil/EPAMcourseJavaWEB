package controllers;

import models.RedBlackTree;
import utility.Tools;
import utility.UI.UserInterface;
import views.RBTview;

public class RBTcontroller {

    private RedBlackTree model;
    private RBTview view;
    private Tools tools;

    public RBTcontroller() {
        model = new RedBlackTree();
        view = new RBTview();
        tools = new Tools();
    }

    public void runController() {
        application:
        while (true) {
            String[] command = UserInterface.inputAction(view, "Input action:");
            switch (command[0]) {
                case "add":
                    int[] data = tools.getValidData(command);
                    if (data[0] > 0) {
                        view.printMessage("Data is valid.");
                        model.add(data[1]);
                    }
                    break;
                case "help":
                    view.printMessage("Print help message");
                    break;
                case "exit":
                    break application;
                    default:
                        view.printMessage("Unknown command or invalid data. Try again please...");
            }
        }
    }

}
