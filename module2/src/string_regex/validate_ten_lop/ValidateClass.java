package string_regex.validate_ten_lop;

import java.util.Scanner;

public class ValidateClass {
    public static void main(String[] args) {
        boolean check=true;
        Scanner scanner=new Scanner(System.in);
        String regex_Class="[CAP]\\d{4}[GHIKLM]";
        while (check){
            System.out.println("Nhập lớp theo định dạng");
            String input=scanner.nextLine();
            String kq=input.matches(regex_Class)?"Đúng ":"Sai";
            System.out.println(kq);
            System.out.println("Bạn có muốn nhập lại ko y/n?");
            String yn=scanner.nextLine();
            if(yn.equalsIgnoreCase("n"))
                check=false;
        }
    }
}
