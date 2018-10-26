package Models.Entity;

/**
 * Class {@code Bear} extends class {@code Soft}.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Soft
 * @see Toy
 */
public class Bear extends Soft {


    /**
     * Constructs a Bear soft toy.
     *
     * @param mainColor initial main color of Bear soft toy
     * @param material  initial material of Bear soft toy
     * @param origin    initial country of producer of Bear soft toy
     * @param price     initial price of Bear soft toy
     * @param ageDelta  initial age's edges for user of Bear soft toy
     * @param isSpeak   initial ability to speak
     * @param sex       initial sex of Bear soft toy
     */
    public Bear(String mainColor, String material, String origin,
                double price, int[] ageDelta, String sex, boolean isSpeak) {
        super(mainColor, material, origin, price, ageDelta, sex, isSpeak);
    }


    /**
     * Implementation of {@code MakeSound} interface method.
     */
    @Override
    public void makeSound() {
        System.out.println("Bearrrrrrrr...");
    }
}
