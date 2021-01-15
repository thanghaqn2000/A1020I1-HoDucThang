package mang_va_phuong_thuc_trong_java.thuc_hanh.tim_gia_tri_lon_nhat;

import java.util.Scanner;

public class TimGiaTriLonNhat {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Property list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        int max=0,flag=0;
        for(int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
                flag=j;
            }
        }
        System.out.printf("Số lớn nhất trong mảng là %d ở vị trí %d",max,flag);
    }
}
