package mang_va_phuong_thuc_trong_java.bai_tap.dem_so_luong_xuat_hien;

import java.util.Scanner;

public class DemSoLanXuatHienTrongChuoi {
    public static String checkNumber(int a,int b,int c) {
        if(b==0)
            return "b cannot equal zero";
        if (c==a/b)
            return "C=A/B";
        else
            return "C!=A/B";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String str = "codegym dn";
        System.out.println("Muốn tìm kiếm từ gì");
        char key = scanner.next().charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if(key==str.charAt(i)){
                count++;
            }
        }
        System.out.printf("Từ %c xuất hiện %d lần ", key, count);
    }
}
