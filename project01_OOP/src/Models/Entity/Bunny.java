package Models.Entity;

public class Bunny extends Soft {

    public Bunny(String color, String material, String producer, double price, double weight, String sex, int scale) {
        super(color, material, producer, price, weight, sex, scale);
    }

    @Override
    public void makeSound() {
        System.out.println("What's up doc?");
    }
}
