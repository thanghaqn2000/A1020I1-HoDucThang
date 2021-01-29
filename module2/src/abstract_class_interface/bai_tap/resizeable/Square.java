package abstract_class_interface.bai_tap.resizeable;

public class Square extends Shape implements Resizeable {
    private double side = 1;

    public Square(double side) {
        this.side = side;
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getPerimeter() {
        return side * 4;
    }

    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }

    @Override
    public void resize(double percent) {
        side += side * percent / 100;
    }
}
