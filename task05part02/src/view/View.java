package view;

import utility.ui.InterfaceMessages;

import java.util.Collection;

public class View implements InterfaceMessages {

    public void printCollection(Collection<Integer> collection) {
        for (Integer item : collection) {
            System.out.println(item);
        }
    }

    @Override
    public void printMessage(String msg) {
        System.out.println(msg);
    }
}
