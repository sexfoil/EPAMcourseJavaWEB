package Models.Entity;

public class McLaren extends Car {

    private String model;

    public McLaren(String name, String mainColor, String material, String origin,
                   double price, int[] ageDelta, boolean isMakeSound, String kind, String model) {
        super(name, mainColor, material, origin, price, ageDelta, isMakeSound, kind);
        this.model = model;
    }

    @Override
    public void makeSound() {
        System.out.println("Fa-fa-faaaaa...");
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("model:%-9s", model);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
