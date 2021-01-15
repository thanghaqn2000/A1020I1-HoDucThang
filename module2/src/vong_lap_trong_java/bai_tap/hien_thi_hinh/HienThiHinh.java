package vong_lap_trong_java.bai_tap.hien_thi_hinh;

import java.util.Scanner;

public class HienThiHinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose, i, j;
        boolean check = false;
        while (!check) {
            System.out.println("1.In hình chữ nhật \n"
                    + "2.In hình tam giác vuông có cạnh ở bot-left \n" +
                    "3.In hình tam giác vuông có cạnh ở bot-left \n"
                    + "4.Exit");
            switch (choose = sc.nextInt()) {
                case 1:
                    for (i = 0; i < 3; i++) {
                        for (j = 0; j < 6; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    for (i = 0; i < 5; i++) {
                        for (j = 0; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    for (i = 5; i > 0; i--) {
                        for (j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 4:
                    check = true;
                    break;
                default:
                    System.out.println("Không có trong menu");
                    break;
            }
        }
    }
}
