package model.entity;

public class Cargo {

    private long id;
    private CargoType type;
    private int weight;


    public Cargo(long id, CargoType type, int weight) {
        this.id = id;
        this.type = type;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CargoType getType() {
        return type;
    }

    public void setType(CargoType type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
