package Models.Entity;

public class McLaren extends Car {

    public McLaren(String color, String material, String producer,
                   double price, double weight, int scale, boolean isMakeSound, String model) {
        super(color, material, producer, price, weight, scale, isMakeSound, model);
    }

    @Override
    public void makeSound() {
        System.out.println("Faaaa...faaaaaa");
    }
}
