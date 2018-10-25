package Models.Entity;

public class Igroteco extends Kit{

    private String building;

    public Igroteco(String mainColor, String material, String origin,
                    double price, int[] ageDelta, int amountOfParts,
                    String building) {
        super(mainColor, material, origin, price, ageDelta, amountOfParts);
        this.building = building;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("object:%-12s", building);
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}
