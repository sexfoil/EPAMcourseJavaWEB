package Models.Entity;

import java.util.Arrays;

/**
 * Abstract class {@code Toy} is super class of toy's entity.
 * All subclasses has fields and implement the methods of this class.
 *
 * @author Slava Poliakov
 * @version 1.0
 */
public abstract class Toy {
    /**
     * Type of group of toy.
     */
    private String type;

    /**
     * Name of toy.
     */
    private String name;

    /**
     * Main color of toy instance.
     */
    private String mainColor;

    /**
     * Name of toy's material.
     */
    private String material;

    /**
     * Short country name of toy's producer.
     */
    private String origin;

    /**
     * Base price of toy instance.
     */
    private double price;

    /**
     * Edges of human age.
     */
    private int[] ageDelta;


    /**
     * Default constructor.
     */
    public Toy() {
    }

    /**
     * Constructor with parameters.  (For invocation by subclass constructors.)
     *
     * @param mainColor initial main color of toy
     * @param material  initial material of toy
     * @param origin    initial country of producer of toy
     * @param price     initial price of toy
     * @param ageDelta  initial age's edges for user of toy
     */
    public Toy(String mainColor, String material, String origin, double price, int[] ageDelta) {
        this.type = getClass().getSuperclass().getSimpleName();
        this.name = getClass().getSimpleName();
        this.mainColor = mainColor;
        this.material = material;
        this.origin = origin;
        this.price = price;
        this.ageDelta = ageDelta;
    }


    /**
     * Returns a string representation of the toy. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this toy.
     * <p>
     * The {@code toString} method for class {@code Toy}
     * returns a string consisting of the name, type, price, producer's country
     * material, color and edge of human's age of toy instance.
     *
     * @return a string representation of the toy.
     */
    @Override
    public String toString() {
        StringBuilder toyInfo = new StringBuilder(String.format("toy:%-8s ", name));
        toyInfo.append(String.format("type:%-9s price:$%-6.2f madden:%-3s ", type, price, origin)).
                append(String.format("material:%-7s color=%-5s ", material, mainColor)).
                append(String.format("age:[%2d-%-2d] ", ageDelta[0], ageDelta[1]));
        return toyInfo.toString();
    }

    /**
     * Indicates whether some other toy is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (Double.compare(toy.price, price) != 0) return false;
        if (!type.equals(toy.type)) return false;
        if (name != null ? !name.equals(toy.name) : toy.name != null) return false;
        if (mainColor != null ? !mainColor.equals(toy.mainColor) : toy.mainColor != null) return false;
        if (material != null ? !material.equals(toy.material) : toy.material != null) return false;
        if (origin != null ? !origin.equals(toy.origin) : toy.origin != null) return false;
        return Arrays.equals(ageDelta, toy.ageDelta);
    }

    /**
     * Returns a hash code value for the toy.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = type.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mainColor != null ? mainColor.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Arrays.hashCode(ageDelta);
        return result;
    }

    /**
     * Returns type of toy.
     *
     * @return type of toy
     */
    public String getType() {
        return type;
    }

    /**
     * Returns name of toy.
     *
     * @return name of toy
     */
    public String getName() {
        return name;
    }

    /**
     * Returns main color of toy.
     *
     * @return main color of toy
     */
    public String getMainColor() {
        return mainColor;
    }

    /**
     * Set main color of toy.
     *
     * @param mainColor color of toy
     */
    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    /**
     * Returns name of material of toy.
     *
     * @return name of material of toy
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Set material of toy.
     *
     * @param material name material of toy
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Returns name of producer's country of toy.
     *
     * @return name of producer's country of toy
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Set name of country of producer of toy.
     *
     * @param origin name of country
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Returns price of toy.
     *
     * @return price of toy
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set price of toy.
     *
     * @param price value of price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns delta ages.
     *
     * @return delta ages
     */
    public int[] getAgeDelta() {
        return ageDelta;
    }

    /**
     * Set delta ages of toy's player.
     *
     * @param ageDelta array of ages
     */
    public void setAgeDelta(int[] ageDelta) {
        this.ageDelta = ageDelta;
    }
}
