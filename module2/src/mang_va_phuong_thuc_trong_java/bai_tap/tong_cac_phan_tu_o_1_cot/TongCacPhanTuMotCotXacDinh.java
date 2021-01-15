package mang_va_phuong_thuc_trong_java.bai_tap.tong_cac_phan_tu_o_1_cot;

import java.util.Scanner;

public class TongCacPhanTuMotCotXacDinh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số cột");
        int sum = 0;
        int cot = input.nextInt();
        System.out.println("Nhập số dòng");
        int dong = input.nextInt();
        int arr[][] = new int[cot][dong];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("Nhập giá trị arr[%d][%d] ", i, j);
                arr[i][j] = input.nextInt();
            }
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("Cột %d \n",i);
            for (int j=0;j<arr[i].length;j++){
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.println("\n");
        }
        System.out.print("\n");
        System.out.println("Muốn tính tổng ở cột thứ mấy ?");
        int cotTinh = input.nextInt();
        for (int j = 0; j < arr[cotTinh].length; j++) {
            sum+=arr[cotTinh][j];
        }
        System.out.printf("Tổng là %d",sum);
    }
}
