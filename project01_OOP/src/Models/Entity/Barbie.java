package Models.Entity;

/**
 * Class {@code Barbie} extends class {@code Doll}.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Doll
 * @see Toy
 */
public class Barbie extends Doll {

    /**
     * Closes theme of Barbie doll.
     */
    private String theme;


    /**
     * Constructs a Barbie doll.
     *
     * @param mainColor initial main color of Barbie doll
     * @param material  initial material of Barbie doll
     * @param origin    initial country of producer of Barbie doll
     * @param price     initial price of Barbie doll
     * @param ageDelta  initial age's edges for user of Barbie doll
     * @param isSpeak   initial ability to speak
     * @param sex       initial sex of Barbie doll
     * @param theme     initial theme of Barbie doll
     */
    public Barbie(String mainColor, String material, String origin,
                  double price, int[] ageDelta, String sex, boolean isSpeak,
                  String theme) {
        super(mainColor, material, origin, price, ageDelta, sex, isSpeak);
        this.theme = theme;
    }


    /**
     * Implementation of {@code MakeSound} interface method.
     */
    @Override
    public void makeSound() {
        System.out.println("Hello, my name is Barbie!");
    }

    /**
     * Returns a string representation of Barbie doll.
     * Override the {@code toString} method of the super class.
     * <p>
     * The {@code toString} method for class {@code Barbie}
     * returns a string of superclass and consisting
     * of the theme of Barbie instance.
     *
     * @return a string representation of the Barbie.
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
