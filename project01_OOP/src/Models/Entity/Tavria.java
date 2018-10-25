package Models.Entity;

public class Tavria extends Car {

    public Tavria(String mainColor, String material, String origin,
                  double price, int[] ageDelta, boolean isMakeSound, String kind) {
        super(mainColor, material, origin, price, ageDelta, isMakeSound, kind);
    }

    @Override
    public void makeSound() {
        System.out.println("Bip-bip...");
    }
}
