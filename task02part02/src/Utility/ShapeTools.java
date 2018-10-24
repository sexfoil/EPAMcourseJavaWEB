package Utility;

import Models.Entity.Shape;
import Models.ShapesSet;

import java.util.Arrays;

public class ShapeTools {

    private ShapesSet model;

    public ShapeTools(ShapesSet model) {
        this.model = model;
    }

    public Shape[] subsetOfShapes(Shape[] shapes, String name) {
        Shape[] subset = new Shape[shapes.length];
        int index = 0;
        for (Shape shape : shapes) {
            if (name == null || shape.getShapeName().equals(name)) {
                subset[index++] = shape;
            }
        }
        return Arrays.copyOf(subset, index);
    }

    public double calculateSumOfAreasOfShapes (Shape[] shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.getArea();
        }
        return sum;
    }

}
