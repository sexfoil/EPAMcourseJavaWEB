package Utility.Comparators;

import Models.Entity.Toy;

import java.util.Comparator;

/**
 * Comparator class {@code TypeComparator} to compare toys by type.
 * Implement {@code Comparator} interface.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Comparator
 */
public class TypeComparator implements Comparator<Toy> {

    /**
     * Compares its two arguments for order by type of toy lexicographically.
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
        return toy1.getType().compareTo(toy2.getType());
    }
}
