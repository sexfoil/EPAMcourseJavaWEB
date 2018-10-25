package Models.Entity;

public class Bear extends Soft {

    public Bear(String mainColor, String material, String origin,
                double price, int[] ageDelta, String sex, boolean isSpeak) {
        super(mainColor, material, origin, price, ageDelta, sex, isSpeak);
    }

    @Override
    public void makeSound() {
        System.out.println("Bearrrrrrrr...");
    }
}
