package Models;

import Models.Entity.Circle;
import Models.Entity.Rectangle;
import Models.Entity.Shape;
import Models.Entity.Triangle;

import java.util.Random;


public class ShapesSet {

    private Shape[] shapes;

    public ShapesSet() {
        setShapes(createShapes());
    }

    private Shape[] createShapes() {
        Shape[] shapesSet = new Shape[15];
        Random random = new Random();
        String[] colors = {"red", "orange", "yellow", "green", "blue", "indigo", "violet"};
        String color;
        double a, b, c;
        Shape shape = null;
        for (int i = 0; i < shapesSet.length; i++) {
            color = colors[random.nextInt(1000) % colors.length];
            switch (random.nextInt(1000) % 3) {
                case 0:
                    a = (random.nextInt(899) + 100) / 100.0;
                    shape = new Circle(color, a);
                    break;
                case 1:
                    a = (random.nextInt(899) + 100) / 100.0;
                    b = (random.nextInt(899) + 100) / 100.0;
                    shape = new Rectangle(color, a, b);
                    break;
                case 2:
                    a = (random.nextInt(899) + 100) / 100.0;
                    b = (random.nextInt(899) + 100) / 100.0;
                    do {
                        c = (random.nextInt(899) + 100) / 100.0;
                    } while (a + b <= c || a + c <= b || b + c <= a);
                    shape = new Triangle(color, a, b, c);
                    break;
            }
            shapesSet[i] = shape;
        }
        return shapesSet;
    }

    public Shape[] getShapes() {
        return shapes;
    }

    public void setShapes(Shape[] shapes) {
        this.shapes = shapes;
    }
}
