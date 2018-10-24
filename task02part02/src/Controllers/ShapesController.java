package Controllers;

import Models.Entity.ColorComparator;
import Models.Entity.Shape;
import Models.ShapesSet;
import UI.UserInterface;
import Utility.ShapeTools;
import Views.ShapesView;

import java.util.Arrays;
import java.util.Comparator;


public class ShapesController {

    private ShapesSet model;
    private ShapesView view;
    private ShapeTools tools;

    public ShapesController() {
        init();
    }

    private void init() {
        model = new ShapesSet();
        view = new ShapesView();
        tools = new ShapeTools(model);
    }

    public void run() {
        view.printMessage( "WELCOME!!!\n");

        application:
        while (true) {
            int command = UserInterface.inputCommand(view);
            Shape[] resultSet;
            switch (command) {
                case 1:
                    view.printMessage(ShapesView.START_INFO + ":");
                    view.printShapes(model.getShapes());
                    break ;
                case 2:
                    view.printMessage("\n");
                    resultSet = model.getShapes(); // ALL
                    if (resultSet.length > 0) {
                        view.printShapes(resultSet);
                        view.printMessage(ShapesView.SUM_OF_AREA + ShapesView.AREA_ALL_SHAPES +
                                tools.calculateSumOfAreasOfShapes(resultSet));
                    } else {
                        view.printMessage(ShapesView.NO_RESULT);
                    }
                    break;
                case 3:
                    view.printMessage("\n");
                    resultSet = tools.subsetOfShapes(model.getShapes(), "Triangle"); // TRIANGLES
                    if (resultSet.length > 0) {
                        view.printShapes(resultSet);
                        view.printMessage(ShapesView.SUM_OF_AREA + ShapesView.AREA_TRIANGLES +
                                tools.calculateSumOfAreasOfShapes(resultSet));
                    } else {
                        view.printMessage(ShapesView.NO_RESULT);
                    }
                    break;
                case 4:
                    view.printMessage("\n");
                    resultSet = tools.subsetOfShapes(model.getShapes(), "Rectangle"); // RECTANGLES
                    if (resultSet.length > 0) {
                        view.printShapes(resultSet);
                        view.printMessage(ShapesView.SUM_OF_AREA + ShapesView.AREA_RECTANGLES +
                                tools.calculateSumOfAreasOfShapes(resultSet));
                    } else {
                        view.printMessage(ShapesView.NO_RESULT);
                    }
                    break;
                case 5:
                    view.printMessage("\n");
                    resultSet = tools.subsetOfShapes(model.getShapes(), "Circle"); // CIRCLES
                    if (resultSet.length > 0) {
                        view.printShapes(resultSet);
                        view.printMessage(ShapesView.SUM_OF_AREA + ShapesView.AREA_CIRCLES +
                                tools.calculateSumOfAreasOfShapes(resultSet));
                    } else {
                        view.printMessage(ShapesView.NO_RESULT);
                    }
                    break;
                case 6:
                    view.printMessage(ShapesView.START_INFO + ShapesView.SORTED_BY_AREA);
                    resultSet = tools.subsetOfShapes(model.getShapes(), null);
                    Arrays.sort(resultSet, new Comparator<Shape>() {
                        @Override
                        public int compare(Shape shape1, Shape shape2) {
                            return Double.compare(shape1.getArea(), shape2.getArea());
                        }
                    });
                    view.printShapes(resultSet);
                    break;
                case 7:
                    view.printMessage(ShapesView.START_INFO + ShapesView.SORTED_BY_COLOR);
                    resultSet = tools.subsetOfShapes(model.getShapes(), null);
                    Arrays.sort(resultSet, new ColorComparator());
                    view.printShapes(resultSet);
                    break;
                case 8:
                    view.printMessage(ShapesView.DRAWING_SHAPES);
                    view.showDrawingShapes(model.getShapes());
                    break;
                case 0:
                    view.printMessage("\nSEE YOU AND HAVE A NICE DAY!!!");
                    break application;
            }
        }

    }
}
