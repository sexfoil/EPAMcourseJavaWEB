package Models.Entity;

public abstract class Kit extends Toy {

    private int amountOfParts;

    public Kit() {

    }

    public Kit(String name, String mainColor, String material,
               String origin, double price, int[] ageDelta,
               int amountOfParts) {
        super(name, mainColor, material, origin, price, ageDelta);
        setType(getClass().getSimpleName());
        this.amountOfParts = amountOfParts;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("parts:%-3d", amountOfParts);
    }

    public int getAmountOfParts() {
        return amountOfParts;
    }

    public void setAmountOfParts(int amountOfParts) {
        this.amountOfParts = amountOfParts;
    }
}
