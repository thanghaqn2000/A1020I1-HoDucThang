package thuat_toan_sap_xep.insertion_sort;

import java.util.Arrays;

public class SapXepChen {
    public static void main(String[] args) {
        int[] arr = {20, 10, -1, 5, 9, 6, 7};
        for (int i = 1; i < arr.length; i++) {
            int curElement = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (curElement < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = curElement;
        }
        System.out.println(Arrays.toString(arr));
    }
}
