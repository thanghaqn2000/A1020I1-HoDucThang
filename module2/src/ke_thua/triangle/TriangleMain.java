package ke_thua.triangle;

public class TriangleMain {
    public static void main(String[] args) {
        Triangle triangle=new Triangle("Red",6,8,3);
        Triangle triangle1=new Triangle();
        triangle1.setColor("Blue");
        System.out.println(triangle1.toString());
        System.out.println(triangle.toString());
    }
}
