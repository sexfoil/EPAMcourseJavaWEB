package view;

public interface PrintInformation {

    String TABLE_BORDER = String.format("+-%1$s-+-%1$s-+-%1$s-+-%1$s-+-%1$s-+-%1$s-+", "--------------------");

    String MAIN_MENU = "\nMAIN MENU (select action):\n" +
            "1 - show all departments;\n" +
            "2 - sort departments;\n" +
            "3 - select department;\n" +
            "4 - create department;\n" +
            "5 - delete department;\n" +
            "0 - exit program.";

    String DEPARTMENT_MENU = " department MENU (select action):\n" +
            "1 - show goods in department;\n" +
            "2 - sort goods by id;\n" +
            "3 - sort goods by name;\n" +
            "4 - sort goods by price;\n" +
            "5 - add good;\n" +
            "6 - remove good;\n" +
            "7 - replace good to another department;\n" +
            "0 - back to main menu.";

    String SHOP_INFO = "\nList of departments";
    String DEPARTMENT_GOODS = "\nList of goods";

    String EMPTY_INPUT = "\nEmpty input!!! Try again...\n";
    String WRONG_INPUT = "\nWrong input!!! Try again...\n ";

    void printMessage(String msg);
}
