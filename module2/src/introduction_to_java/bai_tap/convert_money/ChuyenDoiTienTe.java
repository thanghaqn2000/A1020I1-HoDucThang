package introduction_to_java.bai_tap.convert_money;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
      final int VND=23000;
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số tiền cần đổi từ USD sang VND:");
        int dola=sc.nextInt();
        int money=dola*VND;
        System.out.printf("Tiền sau khi chuyển %d VND",money);
    }
}
