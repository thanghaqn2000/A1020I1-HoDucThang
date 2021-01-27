package ke_thua.circle_cylinder;

public class ShapeMain {
    public static void main(String[] args) {
        Circle circle1=new Circle(3,"Brow");
        System.out.println(circle1.dienTich());
        System.out.println(circle1.toString());
        Cylinder cylinder1=new Cylinder(3,"Red",4);
        System.out.println(cylinder1.dienTich());
        System.out.println(cylinder1.toString());
    }
}
