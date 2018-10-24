package Models.Entity;

import Models.Entity.Interfaces.MakeSounds;

public abstract class Doll extends Toy implements MakeSounds {
    private String sex;
    private boolean isSpeak;

    public Doll() {
    }

    public Doll(String color, String material, String producer,
                double price, double weight, String sex, boolean isSpeak) {
        super(color, material, producer, price, weight);
        this.sex = sex;
        this.isSpeak = isSpeak;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(", sex=%-5s", sex) +
                String.format(", speaking=%-3s", (isSpeak ? "YES" : "NO"));
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
