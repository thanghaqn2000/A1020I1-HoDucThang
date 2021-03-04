package java_collection_framework.array_list_linked_list;

import java.util.Comparator;

public class SortProductDecrease implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o2.getPriceProduct()-o1.getPriceProduct());
    }
}
