package patterncompositefilmappe;

public class Ellipse extends Shape {

    private int rad1;
    private int rad2;
    private String name;

    public Ellipse(String name, int rad1, int rad2)
    {
        this.rad1 = rad1;
        this.rad2 = rad2;
        this.name = name;
    }

    public int getRad1() {
        return rad1;
    }

    public void setRad1(int rad1) {
        this.rad1 = rad1;
    }

    public int getRad2() {
        return rad2;
    }

    public void setRad2(int rad2) {
        this.rad2 = rad2;
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
        return 3.14 * rad1 * rad2;
    }
}
