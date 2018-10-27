package Models.Entity;

/**
 * Class {@code Dog} extends class {@code Soft}.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Soft
 * @see Toy
 */
public class Dog extends Soft {


    /**
     * Constructs a Dog soft toy.
     *
     * @param mainColor initial main color of Dog soft toy
     * @param material  initial material of Dog soft toy
     * @param origin    initial country of producer of Dog soft toy
     * @param price     initial price of Dog soft toy
     * @param ageDelta  initial age's edges for user of Dog soft toy
     * @param isSpeak   initial ability to speak
     * @param sex       initial sex of Dog soft toy
     */
    public Dog(String mainColor, String material, String origin,
               double price, int[] ageDelta, String sex, boolean isSpeak) {
        super(mainColor, material, origin, price, ageDelta, sex, isSpeak);
    }


    /**
     * Implementation of {@code MakeSound} interface method.
     */
    @Override
    public void makeSound() {
        System.out.println("Woooooof...");
    }
}
