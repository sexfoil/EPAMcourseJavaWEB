package Utility.UI;

public interface Informable {

    String INPUT_PATH = "\nInput path and filename to load text or 'exit' to close the program:";


    String WRONG_INPUT = "\nWrong input! No such path or filename...";

    void printMessage(String msg);
}
