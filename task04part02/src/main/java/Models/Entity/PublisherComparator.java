package Models.Entity;

import java.util.Comparator;

/**
 * Comparator class {@code PublisherComparator} to compare books by publisher.
 * Implement {@code Comparator} interface.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Comparator
 */
public class PublisherComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Book) o1).getPublisher().compareTo(((Book) o2).getPublisher());
    }
}
