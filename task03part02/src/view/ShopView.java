package view;

import model.entity.Good;

import java.util.ArrayList;

public class ShopView<T> implements PrintInformation{

    @Override
    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printDepartments(ArrayList<T> resultSet) {
        System.out.println(TABLE_BORDER);
        for (T item : resultSet) {
            System.out.println(item);
        }
        System.out.println(TABLE_BORDER);
    }

    public void printGoods(ArrayList<Good> resultSet) {
        System.out.println(TABLE_BORDER);
        for (Good item : resultSet) {
            System.out.println(item);
        }
        System.out.println(TABLE_BORDER);
    }

}
