package Models.Entity;

import Models.Entity.Interfaces.MakeSounds;

public abstract class Soft extends Toy implements MakeSounds {

    private String sex;
    private int scale;

    public Soft() {
    }

    public Soft(String color, String material, String producer,
                double price, double weight, String sex, int scale) {
        super(color, material, producer, price, weight);
        this.sex = sex;
        this.scale = scale;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(", sex=%-5s", sex) +
                String.format(", scale=1:%-2d", scale);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
