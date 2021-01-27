package access_modifier_static_method_static_property.bai_tap.access_modifer;

public class Circle {
    private double radius=1.0;
    private String color="red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    protected double getRadius() {
        return radius;
    }

      public String getColor() {
        return color;
    }
}
