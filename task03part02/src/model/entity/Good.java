package model.entity;

public class Good {

    private static int CREATED_ID = 0;
    private int id;
    private String name;
    private double price;

    public Good(String name, double price) {
        id = ++CREATED_ID;
        this.name = name;
        this.price = price;

    }

    @Override
    public String toString() {
        return String.format(" %10s(id=%-2d) : $%-5.2f", name, id,  price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (Double.compare(good.price, price) != 0) return false;
        return name != null ? name.equals(good.name) : good.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
