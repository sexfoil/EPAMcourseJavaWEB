package utility.Comparators;

import model.entity.Good;

import java.util.Comparator;

public class GoodNameComparator implements Comparator<Good> {
    @Override
    public int compare(Good g1, Good g2) {
        if (g1 == null && g2 == null) {
            return 0;
        } else if (g2 == null) {
            return -1;
        } else if (g1 == null){
            return 1;
        } else {
            return g1.getName().compareTo(g2.getName());
        }
    }
}
