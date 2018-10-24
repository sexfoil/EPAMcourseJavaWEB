package Models.Entity;

public class Lego extends Kit {

    private String theme;

    public Lego(String color, String material, String producer,
                double price, double weight, int amountOfParts, int minAge, int maxAge,
                String theme) {
        super(color, material, producer, price, weight, amountOfParts, minAge, maxAge);
        this.theme = theme;
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
