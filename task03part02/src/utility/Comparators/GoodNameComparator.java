package utility.Comparators;

import model.entity.Good;

import java.util.Comparator;

public class GoodNameComparator implements Comparator<Good> {
    @Override
    public int compare(Good g1, Good g2) {
        return g1.getName().compareTo(g2.getName());
    }
}
