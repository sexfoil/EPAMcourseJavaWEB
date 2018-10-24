package Models.Entity;


public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(String shapeColor, double sideA, double sideB, double sideC) {
        super(shapeColor);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        setShapeName("Triangle");
        setArea(calcArea());
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-10s | S=%-6.2f | a=%-6.2f | b=%-6.2f | c=%-6.2f |",
                getShapeName(), getShapeColor(), getArea(), sideA, sideB, sideC);
    }

    @Override
    public double calcArea() {
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
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

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
        setArea(calcArea());
    }
}
