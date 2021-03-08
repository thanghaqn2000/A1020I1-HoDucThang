package thuat_toan_tìm_kiem.chuoi_lien_tiep;

import java.util.LinkedList;
import java.util.Scanner;

public class ChuoiLienTiepLonNhat {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();


        for (int i = 0; i < string.length(); i++) {
//            1 vòng for tới length =>O(n)
            if (list.size() > 1 && string.charAt(i) <= list.getLast() &&
                    list.contains(string.charAt(i))) {
//                1 cau if => O(1)
                list.clear();
            }

            list.add(string.charAt(i));

            if (list.size() > max.size()) {
//                1 cau if => O(1)
                max.clear();
                max.addAll(list);
            }
        }
        for (Character ch: max) {
//            1 vòng for tới length =>O(n)
            System.out.print(ch);
        }
        System.out.println();
//        độ phức tạp của thuật toán O(n)
    }
}
