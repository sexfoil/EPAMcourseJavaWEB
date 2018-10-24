package Models.Entity;

import Models.Entity.Interfaces.MakeSounds;

public abstract class Car extends Toy implements MakeSounds {

    private int scale;
    private boolean isMakeSound;
    private String model;

    public Car() {
    }

    public Car(String color, String material, String producer,
               double price, double weight, int scale, boolean isMakeSound, String model) {
        super(color, material, producer, price, weight);
        this.scale = scale;
        this.isMakeSound = isMakeSound;
        this.model = model;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(", scale=1:%-3d", scale) +
                String.format(", klaxon=%-3s", (isMakeSound ? "YES" : "NO")) +
                String.format(", model=%s", model);
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public boolean isMakeSound() {
        return isMakeSound;
    }

    public void setMakeSound(boolean makeSound) {
        isMakeSound = makeSound;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
