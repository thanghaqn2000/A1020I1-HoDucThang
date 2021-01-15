package mang_va_phuong_thuc_trong_java.bai_tap.xoa_phan_tu;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập số " + i);
            arr[i] = scanner.nextInt();
        }
        System.out.print("Dãy mảng " + Arrays.toString(arr));
        System.out.println("Nhập phần tử cần xóa");
        int numDel = scanner.nextInt();
        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == numDel) {
                flag = i;
            }
        }
        System.out.println("flag: " + flag);
        //xoa mang
        for (int i = flag; i < n-1; i++) {
            arr[i] = arr[i+1];
        }
        n--;
        //duyet mang
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
    }
}

