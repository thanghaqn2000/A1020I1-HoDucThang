package vong_lap_trong_java.bai_tap._20_so_nguyen_to;

import java.util.Scanner;

public class HienThi20NguyenTo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Muốn in ra bao nhiêu số nguyên tố");
        int count=0,amountNum,num=2;
        String result="";
        amountNum=sc.nextInt();
        while (count<amountNum){
            boolean check=true;
            for(int i=2;i<num;i++){
                if(num%i==0){
                    check=false;
                    break;
                }
            }
            if(check){
                result+=num+",";
                count++;
            }
            num++;
        }
        System.out.printf(result);
    }
}
