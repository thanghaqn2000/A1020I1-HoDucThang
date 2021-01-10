package introduction_to_java.thuc_hanh.tinh_ngay_thang;

import java.util.Scanner;

public class TinhNgayThang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month, day;
        System.out.println("Nhập tháng cần tính vào đây");
        month = sc.nextInt();
        boolean check = false;
        char c;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
                day = 31;
                System.out.printf("Có %d ngày", day);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                System.out.printf("Có %d ngày", day);
                break;
            case 2:
                day = 28;
                System.out.printf("Có %d hoặc 29 ngày", day);
                break;
            default:
                System.out.println("Nhập chưa đúng tháng qui định");
                break;
        }
//            String enter=sc.nextLine();
//            System.out.println("Có muốn thực hiện tiếp hay ko y/n");
//            c = sc.nextLine().charAt(0);
//            if (c == 'y') {
//                check = true;
//            } else {
//                check = false;
//            }
    }

}
