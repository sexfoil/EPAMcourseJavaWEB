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
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return toy1.getOrigin().compareTo(toy2.getOrigin());
    }
}
