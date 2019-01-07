package model.entity;

public class CargoType {

    private int id;
    private String type;
    private int minWeight;
    private int maxWeight;
    private int rate;


    public CargoType(int id, String type, int minWeight, int maxWeight, int rate) {
        this.id = id;
        this.type = type;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.rate = rate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
