package Models.Entity.Comparators;

import Models.Entity.Toy;

import java.util.Comparator;

public class TypeComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return toy1.getType().compareTo(toy2.getType());
    }
}
