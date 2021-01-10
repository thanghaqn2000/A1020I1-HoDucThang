package introduction_to_java.thuc_hanh.bmi;

import java.util.Scanner;

public class KiemTraBMI {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập chiều cao : ");
        double height=sc.nextDouble();
        System.out.println("Nhập cân nặng: ");
        double weight=sc.nextDouble();
        double bmi=weight/Math.pow(height,2);
        if(bmi<18.5){
            System.out.println("Underweight");
        }else if(bmi<25){
            System.out.println("Normal");
        }else if(bmi<30){
            System.out.println("Overweight");
        }else{
            System.out.println("Obese");
        }
    }
}
