package ExceptionDebug.IllegalTriangleException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            Triangle triangle=new Triangle(3,6,3);
        } catch (IllegalTriangleException e) {
            System.out.println(e);
        }
    }
}
