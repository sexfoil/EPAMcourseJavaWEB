package Models.Entity;

/**
 * Abstract class {@code Kit} is super class of group of
 * specific toys extends class {@code Toy}. Implement {@code MakeSound} interface.
 * All subclasses has fields and implement the methods of this class.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Toy
 */
public abstract class Kit extends Toy {

    /**
     * Amount of parts if kit.
     */
    private int amountOfParts;


    /**
     * Default constructor.
     */
    public Kit() {
    }

    /**
     * Constructor with parameters.  (For invocation by subclass constructors.)
     *
     * @param mainColor     initial main color of kit
     * @param material      initial material of kit
     * @param origin        initial country of producer of kit
     * @param price         initial price of kit
     * @param ageDelta      initial age's edges for user of kit
     * @param amountOfParts initial kit's amount of parts
     */
    public Kit(String mainColor, String material, String origin, double price, int[] ageDelta,
               int amountOfParts) {
        super(mainColor, material, origin, price, ageDelta);
        this.amountOfParts = amountOfParts;
    }


    /**
     * Returns a string representation kits group of the toy.
     * Override the {@code toString} method of the super class.
     * <p>
     * The {@code toString} method for class {@code Kit}
     * returns a string of superclass and consisting of
     * the amount of parts of kit instance.
     *
     * @return a string representation of the kit.
     */
    @Override
    public String toString() {
        return super.toString() + String.format("parts:%-4d", amountOfParts);
    }

    /**
     * Returns amount of kit's parts.
     *
     * @return amount of kit's parts
     */
    public int getAmountOfParts() {
        return amountOfParts;
    }

    /**
     * Set amount of parts to kit.
     *
     * @param amountOfParts amount of parts
     */
    public void setAmountOfParts(int amountOfParts) {
        this.amountOfParts = amountOfParts;
    }
}
