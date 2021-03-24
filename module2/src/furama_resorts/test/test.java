package furama_resorts.test;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        switch (str){
            case "monday":
                System.out.println("Thứ 2");
                break;
            default:
                System.out.println("week");
        }
    }
}
