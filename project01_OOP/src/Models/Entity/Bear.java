package Models.Entity;

public class Bear extends Soft {

    private String kind;

    public Bear(String color, String material, String producer,
                double price, double weight, String sex, int scale,
                String kind) {
        super(color, material, producer, price, weight, sex, scale);
        this.kind = kind;
    }

    @Override
    public void makeSound() {
        System.out.println("Bearrrrrrrr...");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", kind='" + kind + '\'';
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
