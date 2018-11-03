package utility.tools;

import java.util.*;

public class Creator {

    Random random;

    public Creator() {
        random = new Random();
    }

    public List<Integer> getListOfElements(int min, int max, int size) {
        List<Integer> list = new ArrayList<>();
        int bound = max - min + 1;
        while (size > 0) {
            int num = random.nextInt(bound) + min;
            list.add(num);
            size--;
        }
        return list;
    }

    public Set<Integer> getSetOfElements(int min, int max, int size) {
        Set<Integer> set = new TreeSet<>();
        int bound = max - min + 1;
        while (size > 0) {
            int num = random.nextInt(bound) + min;
            if (set.add(num)) {
                size--;
            }
        }
        return set;
    }

}
