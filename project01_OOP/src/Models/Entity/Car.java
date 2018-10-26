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
     * Is this toy can make any sound.
     */
    private boolean isMakeSound;

    /**
     * Kind of car.
     */
    private String kind;


    /**
     * Sole default constructor.  (For invocation by subclass default constructors, typically
     * implicit.)
     */
    public Car() {}

    /**
     * Sole constructor.  (For invocation by subclass constructors, typically
     * implicit.)
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

    public boolean isMakeSound() {
        return isMakeSound;
    }

    public void setMakeSound(boolean makeSound) {
        isMakeSound = makeSound;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
