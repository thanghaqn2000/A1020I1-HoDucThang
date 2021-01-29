package abstract_class_interface.bai_tap.colorable;

import abstract_class_interface.bai_tap.resizeable.Resizeable;


public class Circle extends Shape implements Colorable {

    private double radius = 1;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return radius * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public void howToColor() {
        System.out.println(" Color all four sides..");
    }
}
