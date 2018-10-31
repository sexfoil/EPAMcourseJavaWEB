package utility.ui;

public interface InterfaceMessages {

    String TABLE_BORDER = String.format("+%1$.8s+%1$.25s+%1$.13s+%1$.23s-+-%1$s%1$s-+", "------------------------------");

    String MAIN_MENU = "\nMAIN MENU (select action):\n" +
            "1 - show all students;\n" +
            "2 - add student;\n" +
            "0 - exit program.";

    String STUDENTS_LIST = "\nList of students:";

    String FIRST_NAME_STR = "Input first name:";
    String LAST_NAME_STR = "Input last name:";
    String DATE_STR = "Input date of birth in format 'DD.MM.YYYY' :";
    String PHONE_STR = "Input phone number in format '+XXX (XX) XXX-XX-XX' :";
    String ADDRESS_STR = "Input address in format '<Street name> b.<building number>, ap.<apartment number>' :";

    String EMPTY_INPUT = "\nError! Empty data string inputted!\n";
    String INVALID_INPUT = "\nInvalid format of data inputted!\n";
    String WRONG_INPUT = "\nWrong input! Try again...\n";

    void printMessage(String msg);
}
