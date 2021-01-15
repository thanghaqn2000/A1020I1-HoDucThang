package mang_va_phuong_thuc_trong_java.thuc_hanh.dao_nguoc_item_cua_mang;

import java.util.Arrays;
import java.util.Scanner;

public class DaoNguocPhanTuCuaMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array;
        int size;
        do {
            System.out.println("Nhập vào số phần tử của mảng");
            size = input.nextInt();
            if (size > 20) {
                System.out.println("Ko được quá 20");
            }
        } while (size > 20);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Nhập phần tử a[%d]", i);
            array[i] = input.nextInt();
        }
        System.out.println("Mảng đã nhập: " + Arrays.toString(array));
        System.out.print("Mảng đảo ngược: ");
        //cach 1
//        for (int j = 0; j < array.length / 2; j++) {
//            int temp = array[j];
//            array[j] = array[size - 1 - j];
//            array[size - 1 - j] = temp;
//        }
        //cach 2
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
