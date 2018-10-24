package Models.Entity;

public class Igroteco extends Kit{

    private String building;

    public Igroteco(String color, String material, String producer,
                    double price, double weight, int amountOfParts, int minAge, int maxAge,
                    String building) {
        super(color, material, producer, price, weight, amountOfParts, minAge, maxAge);
        this.building = building;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", building='" + building + '\'';
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String object) {
        this.building = building;
    }
}
