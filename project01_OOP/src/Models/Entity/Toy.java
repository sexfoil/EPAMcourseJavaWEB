package Models.Entity;

import java.util.Arrays;

public abstract class Toy {
    private String type;
    private String name;
    private String mainColor;
    private String material;
    private String origin;
    private double price;
    private int[] ageDelta;

    public Toy() {
    }

    public Toy(String mainColor, String material, String origin, double price, int[] ageDelta) {
        this.type = getClass().getSuperclass().getSimpleName();
        this.name = getClass().getSimpleName();
        this.mainColor = mainColor;
        this.material = material;
        this.origin = origin;
        this.price = price;
        this.ageDelta = ageDelta;
    }

    @Override
    public String toString() {
        StringBuilder toyInfo = new StringBuilder(String.format("toy:%-8s ", name));
        toyInfo.append(String.format("type:%-9s price:$%-6.2f madden:%-3s ", type, price, origin)).
                append(String.format("material:%-7s color=%-5s ", material, mainColor)).
                append(String.format("age:[%2d-%-2d] ", ageDelta[0], ageDelta[1]));
        return toyInfo.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (Double.compare(toy.price, price) != 0) return false;
        if (!type.equals(toy.type)) return false;
        if (name != null ? !name.equals(toy.name) : toy.name != null) return false;
        if (mainColor != null ? !mainColor.equals(toy.mainColor) : toy.mainColor != null) return false;
        if (material != null ? !material.equals(toy.material) : toy.material != null) return false;
        if (origin != null ? !origin.equals(toy.origin) : toy.origin != null) return false;
        return Arrays.equals(ageDelta, toy.ageDelta);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = type.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mainColor != null ? mainColor.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Arrays.hashCode(ageDelta);
        return result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int[] getAgeDelta() {
        return ageDelta;
    }

    public void setAgeDelta(int[] ageDelta) {
        this.ageDelta = ageDelta;
    }
}
