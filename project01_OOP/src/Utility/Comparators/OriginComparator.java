package Utility.Comparators;

import Models.Entity.Toy;

import java.util.Comparator;

/**
 * Comparator class {@code OriginComparator} to compare toys by producer's country.
 * Implement {@code Comparator} interface.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Comparator
 */
public class OriginComparator implements Comparator<Toy> {

    /**
     * Compares its two arguments for order by producer's country lexicographically.
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
        return toy1.getOrigin().compareTo(toy2.getOrigin());
    }
}
