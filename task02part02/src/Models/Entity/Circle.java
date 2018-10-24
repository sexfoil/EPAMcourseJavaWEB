package Models.Entity;


public class Circle extends Shape {

    private double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
        setShapeName("Circle");
        setArea(calcArea());
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-10s | S=%-6.2f | r=%-6.2f |          |          |",
                getShapeName(), getShapeColor(), getArea(), radius);
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        setArea(calcArea());
    }
}
