package Models.Entity;

public class Barbie extends Doll {

    private String theme;

    public Barbie(String color, String material, String producer,
                  double price, double weight, String sex, boolean isSpeak,
                  String theme) {
        super(color, material, producer, price, weight, sex, isSpeak);
        this.theme = theme;
    }

    @Override
    public void makeSound() {
        System.out.println("Hello, my name is Barbie!");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", theme='" + theme + '\'';
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
