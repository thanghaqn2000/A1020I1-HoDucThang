package mang_va_phuong_thuc_trong_java.bai_tap.gop_mang;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size1, size2;
        System.out.println("Nhập vào kích thước mảng 1");
        size1 = scanner.nextInt();
        int[] arr1 = new int[size1];
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("Nhập phàn tủ thứ %d của mảng 1 ", i);
            arr1[i] = scanner.nextInt();
        }
        System.out.println("Nhập vào kích thước mảng 2");
        size2 = scanner.nextInt();
        int[] arr2 = new int[size2];
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("Nhập phàn tủ thứ %d của mảng 2 ", i);
            arr2[i] = scanner.nextInt();
        }
        int[] arr3 = Arrays.copyOf(arr1, size1 + size2);
        for (int j = 0; j < arr2.length; j++) {
            arr3[size1] = arr2[j];
            size1++;
        }
        System.out.println("Mảng đã gộp: " + Arrays.toString(arr3));
    }
}
