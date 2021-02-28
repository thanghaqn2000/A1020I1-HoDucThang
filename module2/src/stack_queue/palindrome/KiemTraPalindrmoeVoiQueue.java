package stack_queue.palindrome;
import java.util.Stack;

public class KiemTraPalindrmoeVoiQueue {
    public static boolean check_Palindrome(String str) {
        String newStr = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        while (stack.size() > 0) {
            char ch = stack.pop();
            newStr += ch;
        }
        if (newStr.equals(str))
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";
        String kq = check_Palindrome(str.toLowerCase()) ? "Đúng" : "Sai";
        System.out.println(kq);
    }
}
