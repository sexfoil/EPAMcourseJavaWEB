package Models.Entity;

public abstract class Kit extends Toy {

    private int amountOfParts;

    public Kit() {

    }

    public Kit(String mainColor, String material, String origin, double price, int[] ageDelta,
               int amountOfParts) {
        super(mainColor, material, origin, price, ageDelta);
        this.amountOfParts = amountOfParts;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("parts:%-4d", amountOfParts);
    }

    public int getAmountOfParts() {
        return amountOfParts;
    }

    public void setAmountOfParts(int amountOfParts) {
        this.amountOfParts = amountOfParts;
    }
}
