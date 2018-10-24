package Models.Entity;

public abstract class Kit extends Toy {

    private int amountOfParts;
    private int minAge = 0;
    private int maxAge = 99;

    public Kit() {

    }

    public Kit(String color, String material, String producer,
               double price, double weight, int amountOfParts, int minAge, int maxAge) {
        super(color, material, producer, price, weight);
        this.amountOfParts = amountOfParts;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(", parts=%-4d", amountOfParts) +
                String.format(", minAge=%-2d", minAge) +
                String.format(", maxAge=%-2d", maxAge);
    }

    public int getAmountOfParts() {
        return amountOfParts;
    }

    public void setAmountOfParts(int amountOfParts) {
        this.amountOfParts = amountOfParts;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }
}
