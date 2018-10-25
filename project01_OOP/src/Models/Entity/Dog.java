package Models.Entity;

public class Dog extends Soft {

    public Dog(String mainColor, String material, String origin,
               double price, int[] ageDelta, String sex, boolean isSpeak) {
        super(mainColor, material, origin, price, ageDelta, sex, isSpeak);
    }

    @Override
    public void makeSound() {
        System.out.println("Woooof...");
    }
}
