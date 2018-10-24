package Models.Entity;


public abstract class Shape implements Drawable {
    private String shapeColor = "Default";
    private String shapeName = this.getClass().getName();
    private double area = 0.0;

    public Shape() { }

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public void draw() {
        String line = "###########################################################################";
        String text = String.format("# Drawing %s %s with area = %.2f #", shapeColor, shapeName, area);
        System.out.println("\n" + line.substring(0, text.length()));
        System.out.println(text);
        System.out.println(line.substring(0, text.length()) + "\n");
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-10s | %-10.2f |", shapeName, shapeColor, area);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shape shape = (Shape) o;

        if (Double.compare(shape.area, area) != 0) return false;
        if (shapeColor != null ? !shapeColor.equals(shape.shapeColor) : shape.shapeColor != null) return false;
        return shapeName != null ? shapeName.equals(shape.shapeName) : shape.shapeName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = shapeColor != null ? shapeColor.hashCode() : 0;
        result = 31 * result + (shapeName != null ? shapeName.hashCode() : 0);
        temp = Double.doubleToLongBits(area);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
