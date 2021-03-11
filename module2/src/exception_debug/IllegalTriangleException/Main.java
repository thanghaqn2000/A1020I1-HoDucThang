package exception_debug.IllegalTriangleException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            Triangle triangle=new Triangle(3,6,3);
            System.out.println("chuẩn");
        } catch (IllegalTriangleException e) {
            System.out.println(e);
        }
    }
}
