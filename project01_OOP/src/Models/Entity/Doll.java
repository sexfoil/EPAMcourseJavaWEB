package Models.Entity;

import Models.Entity.Interfaces.MakeSounds;

public abstract class Doll extends Toy implements MakeSounds {

    private String sex;
    private boolean isSpeak;

    public Doll() {
    }

    public Doll(String mainColor, String material, String origin, double price, int[] ageDelta,
                String sex, boolean isSpeak) {
        super(mainColor, material, origin, price, ageDelta);
        this.sex = sex;
        this.isSpeak = isSpeak;
    }

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
