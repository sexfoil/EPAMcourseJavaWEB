package utility.tools;

import utility.ui.UserInterface;
import view.View;

public class Validator {

    View view;

    public Validator(View view) {
        this.view = view;
    }

    public int getValidCollectionSize() {
        String message = getMessage(1, Integer.MAX_VALUE, View.INPUT_COLLECTION_SIZE);
        return UserInterface.inputNumber(view, 1, Integer.MAX_VALUE, message);
    }

    public int getValidMinimumNumber(int min, int max, int size) {
        int maxEdge = max - size + 1;
        String message = getMessage(Integer.MIN_VALUE, maxEdge, View.INPUT_MIN_VALUE);
        return UserInterface.inputNumber(view, min, maxEdge, message);
    }

    public int getValidMaximumNumber(int min, int max, int size) {
        int minEdge = min + size - 1;
        String message = getMessage(minEdge, Integer.MAX_VALUE, View.INPUT_MAX_VALUE);
        return UserInterface.inputNumber(view, minEdge, Integer.MAX_VALUE, message);
    }


    private String getMessage(int fromValue, int toValue, String headMsg) {
        StringBuilder message = new StringBuilder(headMsg);
        message.append(View.RANGE_FROM).append(fromValue);
        message.append(View.RANGE_TO).append(toValue).append("):");
        return message.toString();
    }

}
