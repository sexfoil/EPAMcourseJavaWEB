package controller;

import utility.Comparators.GoodIdComparator;
import utility.Comparators.GoodNameComparator;
import utility.Comparators.GoodPriceComparator;
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
        view.printMessage("WELCOME TO SHOP!");

        mainMenuActivity();

        view.printMessage("\nHAVE A NICE DAY!");
    }

    private void mainMenuActivity() {
        int command;
        mainLoop:
        while (true) {
            view.printMessage(ShopView.MAIN_MENU);
            command = UserInterface.inputCommand(view, 6);
            String name;
            String[] data;
            switch (command) {
                case 1: //show all departments
                    view.printMessage(view.SHOP_INFO);
                    view.printDepartments(model.getListOfDepartments(false));
                    break;
                case 2: //sort departments
                    view.printMessage(view.SHOP_INFO);
                    view.printDepartments(model.getListOfDepartments(true));
                    break;
                case 3: //swap departments
                    data = UserInterface.inputParameters(view, "Input space separated names of departments to swap: ");
                    if (tools.swapDepartments(data)) {
                        view.printMessage("\nDepartments successfully swapped.\n");
                    } else {
                        view.printMessage("\nCan't swap departments. Wrong name(s) of department(s).\n");
                    }
                    break;
                case 4: //select department
                    name = UserInterface.inputParameters(view, "Input name of department: ")[0];
                    if (tools.isDepartmentExist(name)) {
                        departmentMenuActivity(name);
                    } else {
                        view.printMessage("\nDepartment with name '" + name + "' doesn't exist.\n");
                    }
                    break;
                case 5: //create department
                    data = UserInterface.inputParameters(view, "Input space separated name and capacity(integer) of department: ");
                    if (!model.isFull()) {
                        if (tools.createDepartment(data)) {
                            view.printMessage("\nDepartment successfully created.\n");
                        } else {
                            view.printMessage("\nCan't create department. Department with name '" + data[0] + "' already exist.\n");
                        }
                    } else {
                        view.printMessage("\nThe shop is full. There is no empty place for new department.\n");
                    }
                    break;
                case 6: //delete department
                    name = UserInterface.inputParameters(view, "Input name of department to delete: ")[0];
                    if (!model.isEmpty()) {
                        if (tools.deleteDepartment(name)) {
                            view.printMessage("\nDepartment '" + name + "'successfully deleted from shop.\n");
                        } else {
                            view.printMessage("\nCan't delete department. Department with name '" + name + "' doesn't exist.\n");
                        }
                    } else {
                        view.printMessage("\nThe shop is empty. There is no one department in shop.\n");
                    }
                    break;
                case 0: //exit
                    break mainLoop;
            }
        }
    }

    private void departmentMenuActivity(String departmentName) {
        int command;
        departmentLoop:
        while (true) {
            view.printMessage("'" + departmentName + "'" + ShopView.DEPARTMENT_MENU);
            command = UserInterface.inputCommand(view, 7);
            String[] data;
            switch (command) {
                case 1: //show goods
                    view.printMessage(view.DEPARTMENT_GOODS);
                    view.printGoods(model.getGoodsOfDepartment(departmentName));
                    break;
                case 2: //sort goods by id
                    view.printMessage(view.DEPARTMENT_GOODS);
                    view.printGoods(model.getSortedGoodsOfDepartment(departmentName, new GoodIdComparator()));
                    break;
                case 3: //sort goods by name
                    view.printMessage(view.DEPARTMENT_GOODS);
                    view.printGoods(model.getSortedGoodsOfDepartment(departmentName, new GoodNameComparator()));
                    break;
                case 4: //sort goods by price
                    view.printMessage(view.DEPARTMENT_GOODS);
                    view.printGoods(model.getSortedGoodsOfDepartment(departmentName, new GoodPriceComparator()));
                    break;
                case 5: //add good
                    data = UserInterface.inputParameters(view, "Input space separated name and price of good: ");
                    if (model.addGoodToDepartment(departmentName, data)) {
                        view.printMessage("\nGood successfully added to department.\n");
                    } else {
                        view.printMessage("\nCan't add the good. Department is full.\n");
                    }
                    break;
                case 6: //remove good
                    data = UserInterface.inputParameters(view, "Input name of good to delete: ");
                    if (model.removeGoodFromDepartment(departmentName, data[0])) {
                        view.printMessage("\nGood successfully deleted from department.\n");
                    } else {
                        view.printMessage("\nCan't delete this good. It doesn't exist.\n");
                    }
                    break;
                case 7: //replace good to another department
                    data = UserInterface.inputParameters(view, "Input space separated name of good and name of department to replace:: ");
                    if (!model.isDepartmentFull(data.length > 1 ? data[1] : "")) {
                        if (model.replaceGoodToAnotherDepartment(data[0], departmentName, data[1])) {
                            view.printMessage("\nGood successfully replaced to department " + data[1] + ".\n");
                        } else {
                            view.printMessage("\nCan't replace this good. It doesn't exist.\n");
                        }
                    } else {
                        view.printMessage("\nCan't replace this good. Department '" + data[1] + "' is full.\n");
                    }
                    break;
                case 0: //back
                    break departmentLoop;
            }
        }
    }
}
