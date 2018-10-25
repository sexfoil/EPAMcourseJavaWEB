package Models.Entity;

public class Barbie extends Doll {

    private String theme;

    public Barbie(String name, String mainColor, String material, String origin,
                  double price, int[] ageDelta, String sex, boolean isSpeak,
                  String theme) {
        super(name, mainColor, material, origin, price, ageDelta, sex, isSpeak);
        this.theme = theme;
    }

    @Override
    public void makeSound() {
        System.out.println("Hello, my name is Barbie!");
    }

    @Override
    public String toString() {
        return super.toString() + String.format("theme:%-15s" + theme);
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
