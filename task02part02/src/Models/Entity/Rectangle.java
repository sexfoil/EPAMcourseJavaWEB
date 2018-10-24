package Models.Entity;


public class Rectangle extends Shape {

    private double sideA;
    private double sideB;

    public Rectangle(String shapeColor, double sideA, double sideB) {
        super(shapeColor);
        this.sideA = sideA;
        this.sideB = sideB;
        setShapeName("Rectangle");
        setArea(calcArea());
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-10s | S=%-6.2f | a=%-6.2f | b=%-6.2f |          |",
                getShapeName(), getShapeColor(), getArea(), sideA, sideB);
    }

    @Override
    public double calcArea() {
        return sideA * sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
        setArea(calcArea());
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
        setArea(calcArea());
    }
}
