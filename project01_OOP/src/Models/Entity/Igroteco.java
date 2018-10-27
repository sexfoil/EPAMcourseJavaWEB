package Models.Entity;

/**
 * Class {@code Igroteco} extends class {@code Kit}.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Kit
 * @see Toy
 */
public class Igroteco extends Kit {

    /**
     * General building's theme of Igroteco kit.
     */
    private String building;


    /**
     * Constructs a Lego kit.
     *
     * @param mainColor     initial main color of Igroteco kit
     * @param material      initial material of Igroteco kit
     * @param origin        initial country of producer of Igroteco kit
     * @param price         initial price of Igroteco kit
     * @param ageDelta      initial age's edges for user of Igroteco kit
     * @param amountOfParts initial Igroteco kit's amount of parts
     * @param building      initial general building's theme of Igroteco kit
     */
    public Igroteco(String mainColor, String material, String origin,
                    double price, int[] ageDelta, int amountOfParts,
                    String building) {
        super(mainColor, material, origin, price, ageDelta, amountOfParts);
        this.building = building;
    }


    /**
     * Returns a string representation of Igroteco kit.
     * Override the {@code toString} method of the super class.
     * <p>
     * The {@code toString} method for class {@code Igroteco}
     * returns a string of superclass and consisting
     * of the building of Igroteco instance.
     *
     * @return a string representation of the Igroteco.
     */
    @Override
    public String toString() {
        return super.toString() + String.format("object:%-12s", building);
    }

    /**
     * Returns name of building of Igroteco kit.
     *
     * @return name of building
     */
    public String getBuilding() {
        return building;
    }

    /**
     * Set building to Igroteco kit.
     *
     * @param building building of kit
     */
    public void setBuilding(String building) {
        this.building = building;
    }
}
