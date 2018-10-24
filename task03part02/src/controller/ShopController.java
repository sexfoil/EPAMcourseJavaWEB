package controller;

import utility.ShopTools;
import model.ShopModel;
import utility.UserInterface;
import view.ShopView;

public class ShopController {

    private ShopModel model;
    private ShopView view;
    private ShopTools tools;

    public ShopController() {
        init();
    }

    private void init() {
        model = new ShopModel();
        view = new ShopView();
        tools = new ShopTools(model);
    }

    public void run() {
        view.printMessage("WELCOME TO SHOP!\n");

        mainMenuActivity();

        view.printMessage("\nHAVE A NICE DAY!");
    }

    private void mainMenuActivity() {
        int command;
        mainLoop:
        while (true) {
            view.printMessage(ShopView.MAIN_MENU);
            command = UserInterface.inputCommand(view, 5);
            switch (command) {
                case 1: //show all departments
                    break;
                case 2: //sort departments
                    break;
                case 3: //select department
                    String name = UserInterface.inputParameters(view, "Input name of department: ")[0];
                    departmentMenuActivity(name);
                    break;
                case 4: //create department
                    break;
                case 5: //delete department
                    break;
                case 0: //exit
                    break mainLoop;
            }
        }
    }

    private void departmentMenuActivity(String department) {
        int command;
        departmentLoop:
        while (true) {
            view.printMessage(department + ShopView.DEPARTMENT_MENU);
            command = UserInterface.inputCommand(view, 7);
            switch (command) {
                case 1: //show goods
                    break;
                case 2: //sort goods by id
                    break;
                case 3: //sort goods by name
                    break;
                case 4: //sort goods by price
                    break;
                case 5: //add good
                    break;
                case 6: //remove good
                    break;
                case 7: //replace good to another department
                    break;
                case 0: //back
                    break departmentLoop;
            }
        }
    }
}
