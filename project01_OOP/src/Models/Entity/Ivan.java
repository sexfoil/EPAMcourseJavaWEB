package Models.Entity;

public class Ivan extends Doll {

    private String region;

    public Ivan(String mainColor, String material, String origin,
                double price, int[] ageDelta, String sex, boolean isSpeak,
                String region) {
        super(mainColor, material, origin, price, ageDelta, sex, isSpeak);
        this.region = region;
    }

    @Override
    public void makeSound() {
        System.out.println("I'm not speaking...");
    }

    @Override
    public String toString() {
        return super.toString() + String.format("region:%-14s", region);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
