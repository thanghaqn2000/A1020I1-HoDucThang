package abstract_class_interface.thuc_hanh.comparator;

import java.util.Comparator;

public class CircleComparator  implements Comparator<Circle2> {
    @Override
    public int compare(Circle2 c1, Circle2 c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}
