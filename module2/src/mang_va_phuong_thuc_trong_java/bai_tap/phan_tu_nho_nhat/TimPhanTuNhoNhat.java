package mang_va_phuong_thuc_trong_java.bai_tap.phan_tu_nho_nhat;

import java.util.Scanner;

public class TimPhanTuNhoNhat {
    public static int minValue(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Nhập size của mảng");
        int size=input.nextInt();
        int[] arr=new int[size];
        for (int i=0;i<arr.length;i++){
            System.out.printf("Nhập giá trị a[%d]",i);
            arr[i]=input.nextInt();
        }
        int index=minValue(arr);
        System.out.println("The smallest element in the array is: " + index);
    }
}
