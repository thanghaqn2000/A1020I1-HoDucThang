package string_regex.qui_tac_regex;

import finalmodule.models.Oto;

import static finalmodule.controller.OtoController.addNewOto;
import static finalmodule.controller.OtoController.showOto;
import static furama_resorts.manager.CustomerManager.functionCustomer;

public class Regex {
//  [...]	trả về một ký tự phù hợp
//  [abc]	a, b, hoặc c
//  [^abc]	Bất kỳ ký tự nào ngoại trừ a, b, hoặc c
//  [a-zA-Z]	a tới z hoặc A tới Z
//  [a-d[m-p]]	a tới d, hoặc m tới p: [a-dm-p]
//  [a-z&&[def]]	d, e, hoặc f
//  [a-z&&[^bc]]	a tới z, ngoại trừ b và c: [ad-z]
//  [a-z&&[^m-p]]	a tới z, ngoại trừ m tới p: [a-lq-z]

//  0-9]	0 tới 9
//    X?	X xảy ra một hoặc không lần	hellos?	hello, hellos, helloss
//    X+	X xảy ra một hoặc nhiều lần	Version \w-\w+	Version A-b1_1
//    X*	X xảy ra không hoặc nhiều lần	A*B*C*	AAACC
//    X{n}	X chỉ xảy ra n lần	\d{4}	2018, 20189, 201
//    X{n,}	X xảy ra n hoặc nhiều lần	\d{4,}	2018, 20189, 201
//    X{y,z}	X xảy ra ít nhất y lần nhưng nhỏ hơn z lần	\d{2,3}	2018, 201
//    .	Bất kỳ ký tự nào
//      ^	Có 2 cách sử dụng.
//      1. Đánh dấu bắt đầu của một dòng, một chuỗi.
//            2. Nếuu sử dụng trong dấu [...] thì nó có nghĩa là phủ định.
//    $	Đánh dấu Kết thúc của một dòng
//      \d	Bất kỳ chữ số nào, viết tắt của [0-9]
//            \D	Bất kỳ ký tự nào không phải chữ số, viết tắt của [^0-9]
//            \s	Bất kỳ ký tự trống nào (như dấu cách, tab, xuống dòng, ...), viết tắt của [\t\n\x0B\f\r]
//            \S	Bất kỳ ký tự trống nào không phải ký tự trống, viết tắt của [^\s]
//            \w	Bất kỳ ký tự chữ nào (chữ cái và chữ số), viết tắt của [a-zA-Z_0-9]
//            \W	Bất kỳ ký tự nào không phải chữ cái và chữ số, viết tắt của [^\w]
//            \b	Ranh giới của một từ
//      \B	Không phải ranh giới của một từ

//    |	Hoặc	22|33	33
//     ( … )	Group các ký tự và chụp lại	A(nt|pple)	Ant, Apple
//      \1	Nội dung của Group 1	r(\w)g\1x	regex
//      \2	Nội dung của Group 2	(\d\d)\+(\d\d)=\2\+\1	12+65=65+12
//       (?: … )	Group không được chụp lại, bạn không thể sử dụng \1	A(?:nt|pple)	Ant, Apple
public static void main(String[] args) {
    do {
        try {
            System.out.println("--MENU FINAL MODULE--\n" + "1. T" + "\n" +
                    "2. " + "\n" +
                    "3. X" + "\n" +
                    "4. Thoát");
            int choose =1;
            switch (choose) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Không có trong menu , hãy chọn lại");
                    break;
            }
        } catch (Exception e) {
            System.err.println("Hãy nhập lại!");
        }
    } while (true);
}
}
