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

    /**
     * Compares its two arguments for order by value of toy's price.
     * Returns a negative integer, zero, or a positive integer as the first argument
     * is less than, equal to, or greater than the second.<p>
     *
     * @param toy1 the first object to be compared.
     * @param toy2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first
     *         argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return Double.compare(toy1.getPrice(), toy2.getPrice());
    }
}
