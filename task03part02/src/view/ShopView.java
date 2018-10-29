package view;

import model.ShopModel;
import model.entity.Good;


public class ShopView<T> implements PrintInformation{

    @Override
    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printDepartments(T[] resultSet) {
        System.out.println(TABLE_BORDER);
        for (int i = 0; i < resultSet.length; i++) {
            System.out.println(resultSet[i] != null ?
                    resultSet[i] :
                    " Location '" + ShopModel.DEPARTMENT_LOCATIONS[i] + "' is empty");
        }
        System.out.println(TABLE_BORDER);
    }

    public void printGoods(Good[] resultSet) {
        System.out.println(TABLE_BORDER);
        for (int i = 0; i < resultSet.length; i++) {
            System.out.println(resultSet[i] != null ?
                    resultSet[i] :
                    " Empty slot for good.");
        }
        System.out.println(TABLE_BORDER);
    }

}
