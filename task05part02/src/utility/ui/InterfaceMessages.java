package utility.ui;

public interface InterfaceMessages {

    String INPUT_COLLECTION_SIZE = "\nInput SIZE of collection ";
    String RANGE_FROM = "(Range: from ";
    String RANGE_TO = " to ";

    String INPUT_MIN_VALUE = "Input MIN value ";
    String INPUT_MAX_VALUE = "Input MAX value ";

    String INVALID_INPUT_VALUE = "\nInvalid value inputted!\n";
    String WRONG_INPUT = "\nWrong input! Try again...\n";

    void printMessage(String msg);

}
