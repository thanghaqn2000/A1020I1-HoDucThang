package stack_queue.thap_phan_sang_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class ThapPhanSangNhiPhan {
    public static String decimalToBinary(int decimalNum){
        Stack<Integer> stack=new Stack<>();
        while (decimalNum >= 1) {
            stack.push(decimalNum % 2);
            decimalNum /= 2;
        }
        String result = "";
        while (!stack.isEmpty()) {
            result+=stack.pop();
        }
        return result;
    }
    public static String decimalToHex(int decimalNum){
        String[] surPlusArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        Stack<String> stack = new Stack<>();
        while (decimalNum >= 1) {
            stack.push(surPlusArray[decimalNum % 16]);
            decimalNum /= 16;
        }
        String result = "";
        while (!stack.isEmpty()) {
            result +=stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("Nhập số");
        int value=input.nextInt();
        System.out.println("Binary: "+decimalToBinary(value));
        System.out.println("Hex: "+decimalToHex(value));
    }
}
