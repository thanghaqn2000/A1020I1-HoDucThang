package introduction_to_java.thuc_hanh.use_operator;

import java.util.Scanner;

public class dung_toan_tu {
    public static void main(String[] args) {
        double height, width;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chiều cao và chiều dài");
        height = sc.nextDouble();
        width = sc.nextDouble();
        double area = height * width;
        System.out.println("Diện tích là: "+area);
    }
}
