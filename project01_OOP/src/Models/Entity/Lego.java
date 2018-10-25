package Models.Entity;

public class Lego extends Kit {

    private String theme;

    public Lego(String mainColor, String material, String origin,
                double price, int[] ageDelta, int amountOfParts,
                String theme) {
        super(mainColor, material, origin, price, ageDelta, amountOfParts);
        this.theme = theme;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("theme:%-15s", theme);
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
