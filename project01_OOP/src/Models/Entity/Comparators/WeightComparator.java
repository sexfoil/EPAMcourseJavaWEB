package Models.Entity.Comparators;

import Models.Entity.Toy;

import java.util.Comparator;

public class WeightComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return Double.compare(toy1.getWeight(), toy2.getWeight());
    }
}
