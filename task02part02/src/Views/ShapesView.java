package Views;

import Models.Entity.Shape;


public class ShapesView {

    public static final String TABLE_BORDER = String.format("+-%1$s-+-%1$s-+-%1$.8s-+-%1$.8s-+-%1$.8s-+-%1$.8s-+", "----------");

    public static final String MAKE_CHOISE = "\nInput command:\n" +
            "1 - show all shapes;\n" +
            "2 - calculate sum of area of all shapes;\n" +
            "3 - calculate sum of area of all triangles;\n" +
            "4 - calculate sum of area of all rectangles;\n" +
            "5 - calculate sum of area of all circles;\n" +
            "6 - sort shapes by value of area;\n" +
            "7 - sort shapes by color;\n" +
            "8 - draw all shapes (extra functionality);\n" +
            "0 - exit program.";

    public static final String START_INFO = "\nList of shapes";
    public static final String SORTED_BY_COLOR = " sorted by color:";
    public static final String SORTED_BY_AREA = " sorted by area:";
    public static final String SUM_OF_AREA = "The sum of area of";
    public static final String AREA_ALL_SHAPES = " all shapes: ";
    public static final String AREA_TRIANGLES = " all triangles: ";
    public static final String AREA_RECTANGLES = " all rectangles: ";
    public static final String AREA_CIRCLES = " all circles: ";
    public static final String DRAWING_SHAPES = "Drawing all shapes...\n";
    public static final String NO_RESULT = "No such shapes in the list. Sum of areas is 0.0";
    public static final String WRONG_INPUT = "\nWrong input. Try again...\n ";

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printShapes(Shape[] resultSet) {
        System.out.println(TABLE_BORDER);
        for (Shape shape : resultSet) {
            System.out.println(shape);
        }
        System.out.println(TABLE_BORDER);
    }

    public void showDrawingShapes(Shape[] resultSet) {
        for (Shape shape : resultSet) {
            shape.draw();
        }
    }
}
