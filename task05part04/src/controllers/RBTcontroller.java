package controllers;

import models.RedBlackTree;
import utility.ExampleDataSet;
import utility.Tools;
import utility.UI.UserInterface;
import views.RBTview;

import java.util.Arrays;

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
            String[] command = UserInterface.inputAction(view, "Input action (input 'help' to usage guide):");
            int number;
            switch (command[0]) {
                case "add":
                    number = Integer.parseInt(command[1]);
                    view.printMessage(model.add(number) ? ("Added " + number) : "This number already exists...");
                    break;
                case "del":
                    number = Integer.parseInt(command[1]);
                    view.printMessage(model.remove(number) ? ("Deleted " + number) : "No such number...");
                    break;
                case "example":
                    for (int data : ExampleDataSet.UNSORTED_INT) {
                        model.add(data);
                    }
                    view.printMessage("Added numbers from array:\n" + Arrays.toString(ExampleDataSet.UNSORTED_INT));
                    break;
                case "show":
                    view.printRedBlackTree(model);
                    break;
                case "help":
                    view.printMessage("Commands:\n" +
                            "\tadd 'number'     - to add number in RBtree;\n" +
                            "\tdel 'number'     - to delete number from RBtree;\n" +
                            "\texample          - to add numbers from example array;\n" +
                            "\tshow             - to print current state of RBtree;\n" +
                            "\texit             - to exit program.\n");
                    break;
                case "exit":
                    break application;
                default:
                    view.printMessage("Unknown command or invalid data. Try again please...");
            }
        }
    }

}
