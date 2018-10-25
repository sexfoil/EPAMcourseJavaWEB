package Models.Entity;

import Models.Entity.Interfaces.MakeSounds;

public abstract class Car extends Toy implements MakeSounds {

    private boolean isMakeSound;
    private String kind;

    public Car() {
    }

    public Car(String mainColor, String material, String origin, double price, int[] ageDelta,
               boolean isMakeSound, String kind) {
        super(mainColor, material, origin, price, ageDelta);
        this.isMakeSound = isMakeSound;
        this.kind = kind;
    }

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
