package mang_va_phuong_thuc_trong_java.thuc_hanh.tim_gia_tri_trong_mang;

import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        String name;
        int i,flag=0;
        boolean check=false;
        Scanner input=new Scanner(System.in);
        System.out.println("Nhập tên cần tìm vào đây");
        name=input.nextLine();
        for( i=0;i<students.length;i++){
            if(students[i].equals(name)){
                check=true;
                flag=i;
            }
        }
        if(check){
            System.out.printf("Vị tí của sinh viên %s trong mảng là %d ",name,flag);
        }else{
            System.out.printf("Không tìm thấy sinh viên %s",name);
        }
    }
}
