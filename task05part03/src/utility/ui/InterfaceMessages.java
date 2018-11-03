package utility.ui;

public interface InterfaceMessages {

    String INPUT_TEXT = "Input text to translate or empty string to exit program.\n";
    String SOURCE_TEXT_OUTPUT = "\nOriginal text: ";
    String TRANSLATED_OUTPUT = "\nTranslation: ";

    void printMessage(String msg);
}
