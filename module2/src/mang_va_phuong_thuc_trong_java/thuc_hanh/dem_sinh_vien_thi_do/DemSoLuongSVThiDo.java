package mang_va_phuong_thuc_trong_java.thuc_hanh.dem_sinh_vien_thi_do;

import java.util.Scanner;

public class DemSoLuongSVThiDo {
    public static void main(String[] args) {
        int size,count=0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Muốn nhập vào mấy sinh viên");
            size = scanner.nextInt();
            if (size > 30) {
                System.out.println("Không được nhập quá 30 sinh viên , hãy nhập lại");
            }
        } while (size > 30);

        int[] arrSv = new int[size];

        for (int i = 0; i < arrSv.length; i++) {
            System.out.printf("Nhập điểm sinh viên thứ %d", i+1);
            arrSv[i] = scanner.nextInt();
        }
        for (int i=1;i<arrSv.length;i++){
            if(arrSv[i]>=5 && arrSv[i] <= 10){
                count++;
                System.out.printf("Sinh viên %d đã đỗ với số điểm %d \n",i,arrSv[i]);
            }
        }
        System.out.printf("Có %d sinh viên đã đỗ",count);
    }
}
