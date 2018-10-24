package utility.Comparators;

import model.entity.Good;

import java.util.Comparator;

public class GoodIdComparator implements Comparator<Good> {
    @Override
    public int compare(Good g1, Good g2) {
        return Integer.compare(g1.id, g2.id);
    }
}
