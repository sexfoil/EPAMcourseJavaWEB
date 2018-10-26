package Utility.Comparators;

import Models.Entity.Toy;

import java.util.Comparator;

/**
 * Comparator class {@code NameComparator} to compare toys by name.
 * Implement {@code Comparator} interface.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Comparator
 */
public class NameComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return toy1.getName().compareTo(toy2.getName());
    }
}
