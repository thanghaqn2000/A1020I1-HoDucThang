package stack_queue.kiem_tra_dau_ngoac;

import java.util.Stack;

public class KiemTraDauNgoac {
    public static boolean checkNgoac(String str) {
        Stack<String> bStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                bStack.push("(");
            } else if (str.charAt(i) == ')') {
                if (bStack.empty())
                    return false;
                else
                    bStack.pop();
            }
        }
        return bStack.empty();
    }
    public static void main(String[] args) {
        String str = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        String kq = checkNgoac(str) ? "Đúng" : "sai";
        System.out.println(kq);
    }
}
