package Views;

import Models.Entity.Toy;

import java.util.ArrayList;

/**
 * Parametrized class {@code ToysView} is view in MVC application.
 * Implement {@code Informable} interface.
 *
 * @author Slava Poliakov
 * @version 1.0
 */
public class ToysView<T extends Toy> implements Informable {

    @Override
    public void printMessage(String msg) {
        System.out.println(msg);
    }

    /**
     * Print set of toys.
     *
     * @param resultSet set of toys to print out
     */
    public void printToys(ArrayList<T> resultSet) {
        System.out.println(TABLE_BORDER);
        for (T item : resultSet) {
            System.out.println(item);
        }
        System.out.println(TABLE_BORDER);
    }

}
