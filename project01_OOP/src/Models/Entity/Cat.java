package Models.Entity;

/**
 * Class {@code Cat} extends class {@code Soft}.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Soft
 * @see Toy
 */
public class Cat extends Soft {


    /**
     * Constructs a Cat soft toy.
     *
     * @param mainColor initial main color of Cat soft toy
     * @param material  initial material of Cat soft toy
     * @param origin    initial country of producer of Cat soft toy
     * @param price     initial price of Cat soft toy
     * @param ageDelta  initial age's edges for user of Cat soft toy
     * @param isSpeak   initial ability to speak
     * @param sex       initial sex of Cat soft toy
     */
    public Cat(String mainColor, String material, String origin,
               double price, int[] ageDelta, String sex, boolean isSpeak) {
        super(mainColor, material, origin, price, ageDelta, sex, isSpeak);
    }


    /**
     * Implementation of {@code MakeSound} interface method.
     */
    @Override
    public void makeSound() {
        System.out.println("Murr-meow...");
    }
}
