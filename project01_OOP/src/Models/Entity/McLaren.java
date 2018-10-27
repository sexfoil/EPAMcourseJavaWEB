package Models.Entity;

/**
 *
 * Class {@code McLaren} extends class {@code Car}.
 *
 * @author  Slava Poliakov
 * @version 1.0
 * @see Car
 * @see Toy
 */
public class McLaren extends Car {

    /**
     * Model of sport car McLaren.
     */
    private String model;


    /**
     * Constructs a McLaren car.
     *
     * @param mainColor initial main color of McLaren instance
     * @param material initial material of McLaren instance
     * @param origin initial country of producer of McLaren instance
     * @param price initial price of McLaren instance
     * @param ageDelta initial age's edges for user of McLaren instance
     * @param isMakeSound initial able of makes any sound by McLaren instance
     * @param kind initial kind of McLaren instance
     * @param model initial model of McLaren instance
     */
    public McLaren(String mainColor, String material, String origin,
                   double price, int[] ageDelta, boolean isMakeSound, String kind, String model) {
        super(mainColor, material, origin, price, ageDelta, isMakeSound, kind);
        this.model = model;
    }


    /**
     * Implementation of {@code MakeSound} interface method.
     */
    @Override
    public void makeSound() {
        System.out.println("Fa-fa-fa-faaaaaa...");
    }

    /**
     * Returns a string representation of McLaren car.
     * Override the {@code toString} method of the super class.
     *
     * The {@code toString} method for class {@code McLaren}
     * returns a string of superclass and consisting
     * of the model of McLaren instance.
     *
     * @return  a string representation of the McLaren.
     */
    @Override
    public String toString() {
        return super.toString() +
                String.format("model:%-9s", model);
    }

    /**
     * Returns model of McLaren car.
     *
     * @return model of McLaren car
     */
    public String getModel() {
        return model;
    }

    /**
     * Set model type to McLaren car.
     *
     * @param model model of McLaren
     */
    public void setModel(String model) {
        this.model = model;
    }
}
