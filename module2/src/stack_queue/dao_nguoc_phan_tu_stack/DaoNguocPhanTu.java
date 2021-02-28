package stack_queue.dao_nguoc_phan_tu_stack;

import java.util.*;

public class DaoNguocPhanTu {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            list.add(i);
        }
        System.out.println("Mảng ban đầu: "+list);
        Stack<Integer> stack = new Stack<Integer>();
        while (list.size()>0){
            stack.push(list.remove(0));
        }
        while (stack.size() > 0) {
            list.add(stack.pop());
        }
        System.out.println("Sau khi đã đảo ngược: "+list);

    }
}

