package Views;

import Utility.UI.Informable;

public class TextToolsView implements Informable {

    @Override
    public void printMessage(String msg) {
        System.out.println(msg);
    }
}
