package Models.Entity;

public abstract class Toy {
    private String type;
    private String color;
    private String material;
    private String producer;
    private double price;
    private double weight;

    public Toy() {
    }

    public Toy(String color, String material, String producer,
               double price, double weight) {
        this.type = this.getClass().getSimpleName();
        this.color = color;
        this.material = material;
        this.producer = producer;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("type=%-10s", type) +
                String.format(" color=%-7s", color) +
                String.format(" material=%-10s", material) +
                String.format(" producer=%-3s", producer) +
                String.format(" price=%-10.2f", price) +
                String.format(" weight=%-10.2f", weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (Double.compare(toy.price, price) != 0) return false;
        if (Double.compare(toy.weight, weight) != 0) return false;
        if (type != null ? !type.equals(toy.type) : toy.type != null) return false;
        if (color != null ? !color.equals(toy.color) : toy.color != null) return false;
        if (material != null ? !material.equals(toy.material) : toy.material != null) return false;
        return producer != null ? producer.equals(toy.producer) : toy.producer == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = 17;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
