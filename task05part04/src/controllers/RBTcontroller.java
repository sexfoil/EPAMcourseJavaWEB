package controllers;

import models.RedBlackTree;
import utility.ExampleDataSet;
import utility.UI.UserInterface;
import views.RBTview;

import java.util.Arrays;

public class RBTcontroller {

    private RedBlackTree model;
    private RBTview view;

    public RBTcontroller() {
        model = new RedBlackTree();
        view = new RBTview();
    }

    public void runController() {
        application:
        while (true) {
            String[] command = UserInterface.inputAction(view, "Input action (input 'help' to usage guide):");
            int number;
            switch (command[0]) {
                case "add":
                    number = Integer.parseInt(command[1]);
                    view.printMessage(model.add(number) ? ("Added " + number) : "This number already exists...\n");
                    break;
                case "del":
                    number = Integer.parseInt(command[1]);
                    view.printMessage(model.delete(number) ? ("Deleted " + number) : "No such number...\n");
                    break;
                case "example":
                    for (int data : ExampleDataSet.UNSORTED_INT) {
                        model.add(data);
                    }
                    view.printMessage("Added numbers from array:\n" + Arrays.toString(ExampleDataSet.UNSORTED_INT));
                    break;
                case "example2":
                    for (int data : ExampleDataSet.SORTED_INT) {
                        model.add(data);
                    }
                    view.printMessage("Added numbers from sorted array:\n" + Arrays.toString(ExampleDataSet.SORTED_INT));
                    break;
                case "show":
                    view.printRedBlackTree(model);
                    break;
                case "help":
                    view.printMessage("Commands:\n" +
                            "\tadd 'number'     - to add number in RBtree;\n" +
                            "\tdel 'number'     - to delete number from RBtree;\n" +
                            "\texample          - to add numbers from example array;\n" +
                            "\texample2         - to add numbers from example sorted array;\n" +
                            "\tshow             - to print current state of RBtree;\n" +
                            "\texit             - to exit program.\n");
                    break;
                case "exit":
                    break application;
                default:
                    view.printMessage("\nUnknown command or invalid data. Try again please...\n");
            }
        }
    }

}
