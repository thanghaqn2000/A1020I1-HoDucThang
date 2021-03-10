package thuat_toan_sap_xep.insertion_sort;

import java.util.Arrays;

public class CaiDatSapXepChen {
    public static String insertionSort(int[] arr){
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
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        int[] arr={10,6,9,3,5,7};
        System.out.println(insertionSort(arr));
    }
}
