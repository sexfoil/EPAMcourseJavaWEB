package Views;

/**
 * This interface contains set of specific messages for users dialog and
 * provides each class that implements it with ability to output messages to console.
 *
 * @author Slava Poliakov
 * @version 1.0
 */
public interface Informable {

    /**
     * String that represents border of data's table
     */
    String TABLE_BORDER = String.format("+-%1$s-+-%1$s-+-%1$s-+-%1$s-+-%1$s-+-%1$s-+", "--------------------");

    /**
     * String that represents starting message to user about budget
     */
    String INPUT_BUDGET = "\nInput budget of playroom: ";

    /**
     * String that represents main menu
     */
    String MAIN_MENU = "\nMAIN MENU (select action):\n" +
            "1 - show all toys;\n" +
            "2 - calculate price of all toys;\n" +
            "3 - sort toys;\n" +
            "4 - select toys;\n" +
            "0 - exit program.";

    /**
     * String that represents sorting menu
     */
    String SORT_MENU = "\nSORT BY (input parameter):\n" +
            "- Input one parameter to sort toys: [name, type, price, material, age, madden];\n" +
            "- Input 'back' to return in previous menu.";

    /**
     * String that represents selecting menu
     */
    String SELECT_MENU = "\nSELECT BY (input characteristics):\n" +
            "- Input space separated pairs of characteristics of toy for selecting [param:value param2:value2 ...]\n" +
            "  (NOTE: for price use '<', '>' or '=' between param and value [price>51.50]):\n" +
            "- Input 'back' to return in previous menu.";

    /**
     * String that represents head part of resulting message to user
     */
    String START_INFO = "\nList of toys";

    /**
     * String that represents sorted-menu part of resulting message to user
     */
    String SORTED_BY = " sorted by ";

    /**
     * String that represents selected-menu part of resulting message to user
     */
    String SELECTED_BY = " selected by ";

    /**
     * String that represents message to user about total price
     */
    String SUM_OF_PRICES = "\nThe total price of all toys:";

    /**
     * String that represents message to user about empty input
     */
    String EMPTY_INPUT = "\nEmpty input!!! Try again...\n";

    /**
     * String that represents message to user about wrong input
     */
    String WRONG_INPUT = "\nWrong input!!! Try again...\n ";


    /**
     * Output message to console.
     *
     * @param msg message to be outputted
     */
    void printMessage(String msg);
}
