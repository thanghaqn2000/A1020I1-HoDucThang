package furama_resorts.models;

import java.util.Scanner;

import static furama_resorts.exception.ValidateCustomer.*;
import static furama_resorts.exception.ValidateServices.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id;
        double area;
        int people = 0;
        int length = 0;
        boolean check = true;
        String dof;
        do {
            System.out.println("Nhập vào id");
            dof = sc.nextLine();
           if(!birthdayException(dof))
               System.out.println("sai");
           else
               System.out.println("ok");
        } while (!birthdayException(dof));
        //do{
//            System.out.println("Nhập vào dịch vụ");
//            id=sc.nextLine();
//            if(!genderExeption(id.toLowerCase()))
//                System.out.println("Nhập sai hãy nhập lại");
//            else
//                System.out.println(uppercaseFirst(id));
//        }while (!genderExeption(id.toLowerCase()));

//        while (true){
//            try {
//                Scanner sc =new Scanner(System.in);
//                System.out.println("Nhap nguoi");
//                people= sc.nextInt();
//                if (checkAmountMaxPeople(people)){
//                    return;
//                }
//            }catch (Exception e){
//                System.out.println("Hãy nhập lại");
//            }
//        }
//        String number;
//        System.out.println("Enter number:");
//        number = sc.nextLine();
//        if (!number.matches("[0-9]+")) {
//            System.out.println("Invalid number");
//        }
    }
}
