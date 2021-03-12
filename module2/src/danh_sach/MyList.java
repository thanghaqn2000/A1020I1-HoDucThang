package danh_sach;

import java.util.Arrays;
import java.util.Objects;

public class MyList<E> {
    private int size=0;
    private final static int DEFAULT_CAPTITAL=10;
    private Object elements[];

    public MyList() {
    }
    private void add(E e){
        elements = new Object[DEFAULT_CAPTITAL];
    }
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}
