package patterncompositefilmappe;

public class Main {
    public static void main(String[] args) {
        Trekant triangle = new Trekant("Triangle 1", 10, 20);
        Rektangel rectangle = new Rektangel("Rectangle 1", 15, 25);
        Ellipse ellipse = new Ellipse("Ellipse 1", 7, 14);

        ShapeGroup group = new ShapeGroup();
        group.addShape(triangle);
        group.addShape(rectangle);
        group.addShape(ellipse);

        System.out.println("Drawing all shapes:");
        group.tegn();

        System.out.println("\nTotal area of all shapes: " + group.getArea());
    }
}