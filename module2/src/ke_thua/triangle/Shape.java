package ke_thua.triangle;

public class Shape {
    private String color;
    public Shape() {
    }
    public Shape(String color) {
        this.color=color;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return 1;
    }
    public double getPerimiter(){
        return 1;
    }

}
