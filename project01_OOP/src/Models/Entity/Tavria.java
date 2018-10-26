package Models.Entity;

/**
 *
 * Class {@code Tavria} extends class {@code Car}.
 *
 * @author  Slava Poliakov
 * @version 1.0
 * @see Car
 * @see Toy
 */
public class Tavria extends Car {


    /**
     * Constructs a Tavria car.
     *
     * @param mainColor initial main color of Tavria instance
     * @param material initial material of Tavria instance
     * @param origin initial country of producer of Tavria instance
     * @param price initial price of Tavria instance
     * @param ageDelta initial age's edges for user of Tavria instance
     * @param isMakeSound initial able of makes any sound by Tavria instance
     * @param kind initial kind of Tavria instance
     */
    public Tavria(String mainColor, String material, String origin,
                  double price, int[] ageDelta, boolean isMakeSound, String kind) {
        super(mainColor, material, origin, price, ageDelta, isMakeSound, kind);
    }


    /**
     * Implementation of {@code MakeSound} interface method.
     */
    @Override
    public void makeSound() {
        System.out.println("Bip-bip...");
    }
}
