package introduction_to_java.bai_tap.show_name;

import java.util.Scanner;

public class HienThiTen {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập tên của bạn vào đây");
        String name=sc.nextLine();
        System.out.println("Hello bạn "+name);
    }
}
