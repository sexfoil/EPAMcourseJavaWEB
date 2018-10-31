package view;

import model.entity.Student;
import utility.ui.InterfaceMessages;

import java.util.ArrayList;

public class TeacherBookView<T extends Student> implements InterfaceMessages {

    @Override
    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printResultSet(ArrayList<T> resultSet) {
        System.out.println(TABLE_BORDER);
        for (T item : resultSet) {
            System.out.println(item);
        }
        System.out.println(TABLE_BORDER);
    }
}
