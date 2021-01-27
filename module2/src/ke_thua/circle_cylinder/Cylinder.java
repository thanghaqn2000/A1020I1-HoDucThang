package ke_thua.circle_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double dienTich() {
        return (2*Math.PI*getRadius()*getRadius()+2*Math.PI*getRadius()*height);
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + getRadius() +
                ", color='" + getColor() + '\'' +
                "height=" + height +
                '}';
    }
}
