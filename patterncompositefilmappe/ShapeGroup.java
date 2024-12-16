package patterncompositefilmappe;

import java.util.ArrayList;
import java.util.List;

public class ShapeGroup extends Shape {

    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public void tegn() {
        for (Shape shape : shapes) {
            shape.tegn();
        }
    }

    @Override
    public double getArea() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }
}