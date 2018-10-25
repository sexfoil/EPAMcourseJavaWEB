package Models.Entity;


public class Iveco extends Car {

    public Iveco(String mainColor, String material, String origin,
                 double price, int[] ageDelta, boolean isMakeSound, String kind) {
        super(mainColor, material, origin, price, ageDelta, isMakeSound, kind);
    }

    @Override
    public void makeSound() {
        System.out.println("BAAAAAP-BAAAAAAAAAAAAP...");
    }
}
