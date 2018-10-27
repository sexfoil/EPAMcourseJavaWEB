package Views;

import Models.Entity.Toy;

import java.util.ArrayList;

/**
 * This class is the View in MVC Pattern - represents the visualization of the data that model contains.
 * Implements {@code Informable} interface.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Informable
 */
public class ToysView<T extends Toy> implements Informable {

    /**
     * Output message to console.
     *
     * @param msg message to be outputted
     */
    @Override
    public void printMessage(String msg) {
        System.out.println(msg);
    }

    /**
     * Outputs set of toys as table.
     *
     * @param resultSet set of toys to be outputted
     */
    public void printToys(ArrayList<T> resultSet) {
        System.out.println(TABLE_BORDER);
        for (T item : resultSet) {
            System.out.println(item);
        }
        System.out.println(TABLE_BORDER);
    }

}
