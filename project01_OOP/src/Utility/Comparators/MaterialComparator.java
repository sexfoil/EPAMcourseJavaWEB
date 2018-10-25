package Utility.Comparators;

import Models.Entity.Toy;

import java.util.Comparator;

public class MaterialComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return toy1.getMaterial().compareTo(toy2.getMaterial());
    }
}
