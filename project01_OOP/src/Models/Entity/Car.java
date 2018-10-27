package Models.Entity;

import Models.Entity.Interfaces.MakeSounds;

/**
 *
 * Abstract class {@code Car} is super class of group of
 * specific toys extends class {@code Toy}. Implement {@code MakeSound} interface.
 * All subclasses has fields and implement the methods of this class.
 *
 * @author  Slava Poliakov
 * @version 1.0
 * @see Toy
 */
public abstract class Car extends Toy implements MakeSounds {

    /**
     * Ability of makes a sound.
     */
    private boolean isMakeSound;

    /**
     * Kind of car.
     */
    private String kind;


    /**
     * Default constructor.
     */
    public Car() {}

    /**
     * Constructor with parameters.  (For invocation by subclass constructors.)
     *
     * @param mainColor initial main color of toy
     * @param material initial material of toy
     * @param origin initial country of producer of toy
     * @param price initial price of toy
     * @param ageDelta initial age's edges for user of toy
     * @param isMakeSound initial able of makes any sound by toy
     * @param kind initial kind of toy
     */
    public Car(String mainColor, String material, String origin, double price, int[] ageDelta,
               boolean isMakeSound, String kind) {
        super(mainColor, material, origin, price, ageDelta);
        this.isMakeSound = isMakeSound;
        this.kind = kind;
    }


    /**
     * Returns a string representation cars group of the toy.
     * Override the {@code toString} method of the super class.
     *
     * The {@code toString} method for class {@code Car}
     * returns a string of superclass and consisting of
     * kind and ability to make a sound of car instance.
     *
     * @return  a string representation of the car.
     */
    @Override
    public String toString() {
        return super.toString() +
                String.format("sound:%-4s", (isMakeSound ? "yes" : "no")) +
                String.format("kind:%-9s ", kind);
    }


    /**
     * Returns is car can make a sound.
     *
     * @return {@code true} if toy can make a sound;
     *         otherwise returns {@code false}
     */
    public boolean isMakeSound() {
        return isMakeSound;
    }

    /**
     * Set ability of make a sound.
     *
     * @param makeSound ability of make a sound
     */
    public void setMakeSound(boolean makeSound) {
        isMakeSound = makeSound;
    }

    /**
     * Returns kind of car.
     *
     * @return kind of car
     */
    public String getKind() {
        return kind;
    }

    /**
     * Set kind of car.
     *
     * @param kind kind of car
     */
    public void setKind(String kind) {
        this.kind = kind;
    }
}
