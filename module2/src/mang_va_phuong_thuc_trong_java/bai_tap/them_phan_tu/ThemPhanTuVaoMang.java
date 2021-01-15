package mang_va_phuong_thuc_trong_java.bai_tap.them_phan_tu;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        System.out.println("Mảng ban đầu" + Arrays.toString(arr));
        int index, element;
        System.out.println("Nhập số cần chèn");
        element = scanner.nextInt();
        System.out.println("Nhập vị trí cần chèn");
        index = scanner.nextInt();
        for (int i = newArr.length - 1; i > index; i--) {
            newArr[i] = newArr[i - 1];
        }
        newArr[index] = element;
        System.out.println("Mảng sau khi chèn " + Arrays.toString(newArr));
    }
}

