package views;

import utility.ui.InterfaceMessages;

public class View implements InterfaceMessages {

    @Override
    public void printMessage(String msg) {
        System.out.println(msg);
    }
}
