package Utility.Comparators;

import Models.Entity.Toy;

import java.util.Comparator;

/**
 * Comparator class {@code MaterialComparator} to compare toys by material.
 * Implement {@code Comparator} interface.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Comparator
 */
public class MaterialComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return toy1.getMaterial().compareTo(toy2.getMaterial());
    }
}
