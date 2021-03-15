package string_regex.validate_sdt;

import java.util.Scanner;

public class ValidateSDT {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean check=true;
        String regex_Sdt="[0-9]{2}-[0][0-9]{9}";
        while (check){
            System.out.println("Nhập số điện thoại theo định dạng");
            String input=scanner.nextLine();
            String kq=input.matches(regex_Sdt)?"Đúng ":"Sai";
            System.out.println(kq);
            System.out.println("Bạn có muốn nhập lại ko y/n?");
            String yn=scanner.nextLine();
            if(yn.equalsIgnoreCase("n"))
                check=false;
        }

    }
}
