package utility.Comparators;

import model.entity.Good;

import java.util.Comparator;

public class GoodPriceComparator implements Comparator<Good> {
    @Override
    public int compare(Good g1, Good g2) {
        return Double.compare(g1.getPrice(), g2.getPrice());
    }
}
