package Models.Entity;

public class Ivan extends Doll {

    private String region;

    public Ivan(String color, String material, String producer,
                double price, double weight, String sex, boolean isSpeak,
                String region) {
        super(color, material, producer, price, weight, sex, isSpeak);
        this.region = region;
    }

    @Override
    public void makeSound() {
        System.out.println("I'm not speaking...");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", region='" + region + '\'';
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
