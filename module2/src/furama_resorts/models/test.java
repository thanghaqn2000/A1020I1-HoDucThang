package furama_resorts.models;

import java.util.Scanner;

import static furama_resorts.validate.CheckValidate.checkUseArea;
import static furama_resorts.validate.CheckValidate.validateVilla;

public class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String id;
        double area;
        do{
            System.out.println("Nhap area");
            area=sc.nextDouble();
           if(!checkUseArea(area))
               System.out.println("Hãy nhập lại");
           else
               System.out.println("ok");
        }while (!checkUseArea(area));
    }
}
