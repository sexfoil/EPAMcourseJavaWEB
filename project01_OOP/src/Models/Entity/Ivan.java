package Models.Entity;

/**
 * Class {@code Ivan} extends class {@code Doll}.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Doll
 * @see Toy
 */
public class Ivan extends Doll {

    /**
     * Region of Ivan's closes parameters.
     */
    private String region;

    /**
     * Constructs a Ivan doll.
     *
     * @param mainColor initial main color of Ivan doll
     * @param material  initial material of Ivan doll
     * @param origin    initial country of producer of Ivan doll
     * @param price     initial price of Ivan doll
     * @param ageDelta  initial age's edges for user of Ivan doll
     * @param isSpeak   initial ability to speak
     * @param sex       initial sex of Ivan doll
     * @param region    initial region of Ivan doll
     */
    public Ivan(String mainColor, String material, String origin,
                double price, int[] ageDelta, String sex, boolean isSpeak,
                String region) {
        super(mainColor, material, origin, price, ageDelta, sex, isSpeak);
        this.region = region;
    }


    /**
     * Implementation of {@code MakeSound} interface method.
     */
    @Override
    public void makeSound() {
        System.out.println("I'm not speaking...");
    }

    /**
     * Returns a string representation of Ivan doll.
     * Override the {@code toString} method of the super class.
     * <p>
     * The {@code toString} method for class {@code Ivan}
     * returns a string of superclass and consisting
     * of the theme of Ivan instance.
     *
     * @return a string representation of the Ivan.
     */
    @Override
    public String toString() {
        return super.toString() + String.format("region:%-14s", region);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
