package patterncompositefilmappe;

public class Trekant implements Shape{

    private int height;
    private int groundline;
    private String name;

    public Trekant(String name, int height, int groundline)
    {
        this.height = height;
        this.groundline = groundline;
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getGroundline() {
        return groundline;
    }

    public void setGroundline(int groundline) {
        this.groundline = groundline;
    }

    @Override
    public void tegn()
    {
        System.out.println(name);
    }

    @Override
    public double getArea()
    {
        return 0.5 * groundline *height;
    }
}
