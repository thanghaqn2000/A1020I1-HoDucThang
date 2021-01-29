package abstract_class_interface.thuc_hanh.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Circle2[] circles = new Circle2[3];
        circles[0] = new Circle2(3.6);
        circles[1] = new Circle2();
        circles[2] = new Circle2(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (Circle2 circle : circles) {
            System.out.println(circle.getRadius());
        }

        Comparator circleComparator = new CircleComparator();

        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted:");
        for (Circle2 circle : circles) {
            System.out.println(circle.getRadius());
        }
    }
}
