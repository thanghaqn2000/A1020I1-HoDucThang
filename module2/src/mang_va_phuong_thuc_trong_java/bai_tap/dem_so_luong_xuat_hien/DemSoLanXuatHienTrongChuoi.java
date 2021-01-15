package mang_va_phuong_thuc_trong_java.bai_tap.dem_so_luong_xuat_hien;

import java.util.Scanner;

public class DemSoLanXuatHienTrongChuoi {
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
