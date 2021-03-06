package Utility.Comparators;

import Models.Entity.Toy;

import java.util.Comparator;


/**
 * Comparator class {@code AgeComparator} to compare toys by edge of ages.
 * Implement {@code Comparator} interface.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Comparator
 */
public class AgeComparator implements Comparator<Toy> {

    /**
     * Compares its two arguments for order by value of age.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     *
     * @param toy1 the first object to be compared.
     * @param toy2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first
     *         argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Toy toy1, Toy toy2) {
        if (toy1.getAgeDelta()[0] != toy2.getAgeDelta()[0]) {
            return Integer.compare(toy1.getAgeDelta()[0], toy2.getAgeDelta()[0]);
        } else {
            return Integer.compare(toy1.getAgeDelta()[1], toy2.getAgeDelta()[1]);
        }
    }
}
