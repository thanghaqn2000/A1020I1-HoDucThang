package abstract_class_interface.bai_tap.colorable;

import abstract_class_interface.bai_tap.resizeable.Resizeable;


public class Rectangle extends Shape implements Resizeable {
    private double width = 1;
    private double heigth = 1;

    public Rectangle() {
    }

    public Rectangle(double width, double heigth) {
        this.width = width;
        this.heigth = heigth;
    }

    public Rectangle(String color, boolean filled, double width, double heigth) {
        super(color, filled);
        this.width = width;
        this.heigth = heigth;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public double getArea() {
        return width * heigth;
    }

    public double getPerimeter() {
        return (width + heigth) / 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", heigth=" + heigth +
                '}';
    }

    @Override
    public void resize(double percent) {
        width+=width*percent/100;
        heigth+=heigth*percent/100;
    }
}
