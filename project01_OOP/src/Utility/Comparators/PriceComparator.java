package Utility.Comparators;

import Models.Entity.Toy;

import java.util.Comparator;

/**
 * Comparator class {@code PriceComparator} to compare toys by price.
 * Implement {@code Comparator} interface.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Comparator
 */
public class PriceComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return Double.compare(toy1.getPrice(), toy2.getPrice());
    }
}
