package Views;

import Models.Entity.Toy;

import java.util.ArrayList;

public class ToysView<T extends Toy> {

    public static final String TABLE_BORDER = String.format("+-%1$s-+-%1$s-+-%1$s-+-%1$s-+-%1$s-+-%1$s-+", "--------------------");

    public static final String MAIN_MENU = "\nMAIN MENU (select action):\n" +
            "1 - show all toys;\n" +
            "2 - calculate price of all toys;\n" +
            "3 - sort toys;\n" +
            "4 - select toys;\n" +
            "0 - exit program.";

    public static final String SORT_MENU = "\nSORT BY (input parameter):\n" +
            "- Input one parameter to sort toys: [type, price, weight, material];\n" +
            "- Input [back] to return in previous menu.";

    public static final String SELECT_MENU = "\nSELECT BY (input characteristics):\n" +
            "- Input space separated pairs of characteristics of toy for selecting: [param=value param2=value2 ...]\n" +
            "- Input [back] to return in previous menu.";

    public static final String START_INFO = "\nList of toys";
    public static final String SORTED_BY = " sorted by ";
    public static final String SUM_OF_PRICES = "\nThe total price of all toys:";
    public static final String SELECTED_BY = " selected by ";

    public static final String EMPTY_INPUT = "\nEmpty input!!! Try again...\n";
    public static final String WRONG_INPUT = "\nWrong input!!! Try again...\n ";

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printToys(ArrayList<T> resultSet) {
        System.out.println(TABLE_BORDER);
        for (T item : resultSet) {
            System.out.println(item);
        }
        System.out.println(TABLE_BORDER);
    }

}
