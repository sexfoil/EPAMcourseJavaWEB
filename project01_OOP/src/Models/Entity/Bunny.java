package Models.Entity;

/**
 * Class {@code Bunny} extends class {@code Soft}.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Soft
 * @see Toy
 */
public class Bunny extends Soft {


    /**
     * Constructs a Bunny soft toy.
     *
     * @param mainColor initial main color of Bunny soft toy
     * @param material  initial material of Bunny soft toy
     * @param origin    initial country of producer of Bunny soft toy
     * @param price     initial price of Bunny soft toy
     * @param ageDelta  initial age's edges for user of Bunny soft toy
     * @param isSpeak   initial ability to speak
     * @param sex       initial sex of Bunny soft toy
     */
    public Bunny(String mainColor, String material, String origin,
                 double price, int[] ageDelta, String sex, boolean isSpeak) {
        super(mainColor, material, origin, price, ageDelta, sex, isSpeak);
    }


    /**
     * Implementation of {@code MakeSound} interface method.
     */
    @Override
    public void makeSound() {
        System.out.println("What's up doc!?");
    }
}
