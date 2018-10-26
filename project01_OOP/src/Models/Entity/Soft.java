package Models.Entity;

import Models.Entity.Interfaces.MakeSounds;

/**
 * Abstract class {@code Soft} is super class of group of
 * specific toys extends class {@code Toy}. Implement {@code MakeSound} interface.
 * All subclasses has fields and implement the methods of this class.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Toy
 */
public abstract class Soft extends Toy implements MakeSounds {

    /**
     * Sex of soft toy.
     */
    private String sex;

    /**
     * Is this soft toy can speak.
     */
    private boolean isSpeak;


    /**
     * Sole default constructor.  (For invocation by subclass default constructors, typically
     * implicit.)
     */
    public Soft() {
    }

    /**
     * Sole constructor.  (For invocation by subclass constructors, typically
     * implicit.)
     *
     * @param mainColor initial main color of soft toy
     * @param material  initial material of soft toy
     * @param origin    initial country of producer of soft toy
     * @param price     initial price of soft toy
     * @param ageDelta  initial age's edges for user of soft toy
     * @param isSpeak   initial ability to speak
     * @param sex       initial sex of soft toy
     */
    public Soft(String mainColor, String material, String origin, double price, int[] ageDelta,
                String sex, boolean isSpeak) {
        super(mainColor, material, origin, price, ageDelta);
        this.sex = sex;
        this.isSpeak = isSpeak;
    }


    /**
     * Returns a string representation soft toys group of the toy.
     * Override the {@code toString} method of the super class.
     * <p>
     * The {@code toString} method for class {@code Soft}
     * returns a string of superclass and consisting of
     * sex and ability to speak of soft toy instance.
     *
     * @return a string representation of the soft toy.
     */
    @Override
    public String toString() {
        return super.toString() +
                String.format("sound:%-4s", (isSpeak ? "yes" : "no")) +
                String.format("sex:%-10s ", sex);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isSpeak() {
        return isSpeak;
    }

    public void setSpeak(boolean speak) {
        isSpeak = speak;
    }
}
