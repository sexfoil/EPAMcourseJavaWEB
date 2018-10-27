package Models.Entity;

/**
 *
 * Class {@code Iveco} extends class {@code Car}.
 *
 * @author  Slava Poliakov
 * @version 1.0
 * @see Car
 * @see Toy
 */
public class Iveco extends Car {

    /**
     * Constructs a Iveco car.
     *
     * @param mainColor initial main color of Iveco instance
     * @param material initial material of Iveco instance
     * @param origin initial country of producer of Iveco instance
     * @param price initial price of Iveco instance
     * @param ageDelta initial age's edges for user of Iveco instance
     * @param isMakeSound initial able of makes any sound by Iveco instance
     * @param kind initial kind of Iveco instance
     */
    public Iveco(String mainColor, String material, String origin,
                 double price, int[] ageDelta, boolean isMakeSound, String kind) {
        super(mainColor, material, origin, price, ageDelta, isMakeSound, kind);
    }


    /**
     * Implementation of {@code MakeSound} interface method.
     */
    @Override
    public void makeSound() {
        System.out.println("BAAAAAP-BAAAAAAAAAAAP...");
    }
}
