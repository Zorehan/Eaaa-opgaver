package patterncompositefilmappe;

public class Rektangel implements Shape {

    private int length;
    private int width;
    private String name;

    public Rektangel(String name, int length, int width)

    {
        this.length = length;
        this.width = width;
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void tegn()
    {
        System.out.println(name);
    }

    @Override
    public double getArea()
    {
        return width * length;
    }
}
