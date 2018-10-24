package Models.Entity;

import java.util.Comparator;

public class PublisherComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Book) o1).getPublisher().compareTo(((Book) o2).getPublisher());
    }
}
