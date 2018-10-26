package Views;


public interface Informable {
    String TABLE_BORDER = String.format("+-%1$s-+-%1$s-+-%1$s-+-%1$s-+-%1$s-+-%1$s-+", "--------------------");

    String INPUT_BUDGET = "\nInput budget of playroom: ";
    String MAIN_MENU = "\nMAIN MENU (select action):\n" +
            "1 - show all toys;\n" +
            "2 - calculate price of all toys;\n" +
            "3 - sort toys;\n" +
            "4 - select toys;\n" +
            "0 - exit program.";

    String SORT_MENU = "\nSORT BY (input parameter):\n" +
            "- Input one parameter to sort toys: [name, type, price, material, age, madden];\n" +
            "- Input 'back' to return in previous menu.";

    String SELECT_MENU = "\nSELECT BY (input characteristics):\n" +
            "- Input space separated pairs of characteristics of toy for selecting [param:value param2:value2 ...]\n" +
            "  (NOTE: for price use '<', '>' or '=' between param and value [price>51.50]):\n" +
            "- Input 'back' to return in previous menu.";

    String START_INFO = "\nList of toys";
    String SORTED_BY = " sorted by ";
    String SUM_OF_PRICES = "\nThe total price of all toys:";
    String SELECTED_BY = " selected by ";

    String EMPTY_INPUT = "\nEmpty input!!! Try again...\n";
    String WRONG_INPUT = "\nWrong input!!! Try again...\n ";

    void printMessage(String msg);

}
