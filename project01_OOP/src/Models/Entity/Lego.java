package Models.Entity;

/**
 * Class {@code Lego} extends class {@code Kit}.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Kit
 * @see Toy
 */
public class Lego extends Kit {

    /**
     * General theme of Lego kit.
     */
    private String theme;


    /**
     * Constructs a Lego kit.
     *
     * @param mainColor     initial main color of Lego kit
     * @param material      initial material of Lego kit
     * @param origin        initial country of producer of Lego kit
     * @param price         initial price of Lego kit
     * @param ageDelta      initial age's edges for user of Lego kit
     * @param amountOfParts initial Lego kit's amount of parts
     * @param theme         initial general theme of Lego kit
     */
    public Lego(String mainColor, String material, String origin,
                double price, int[] ageDelta, int amountOfParts,
                String theme) {
        super(mainColor, material, origin, price, ageDelta, amountOfParts);
        this.theme = theme;
    }


    /**
     * Returns a string representation of Lego kit.
     * Override the {@code toString} method of the super class.
     * <p>
     * The {@code toString} method for class {@code Lego}
     * returns a string of superclass and consisting
     * of the theme of Lego instance.
     *
     * @return a string representation of the Lego.
     */
    @Override
    public String toString() {
        return super.toString() + String.format("theme:%-15s", theme);
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
