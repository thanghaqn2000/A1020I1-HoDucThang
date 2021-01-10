package introduction_to_java.bai_tap.number_to_word;

import java.util.Scanner;

public class SoThanhChu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cần chuyển");
        int number = sc.nextInt();
        if (number < 10) {
            switch (number) {
                case 0:
                    System.out.println("zero");
                    break;
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
            }
        } else if (number <= 20) {
            switch (number) {
                case 10:
                    System.out.println("Ten");
                    break;
                case 11:
                    System.out.println("Eleven");
                    break;
                case 12:
                    System.out.println("Twelve");
                    break;
                case 13:
                    System.out.println("Thirteen");
                    break;
                case 14:
                    System.out.println("Fourteen");
                    break;
                case 15:
                    System.out.println("Fifteen");
                    break;
                case 16:
                    System.out.println("Sixteen");
                    break;
                case 17:
                    System.out.println("Seventeen");
                    break;
                case 18:
                    System.out.println("Eighteen");
                    break;
                case 19:
                    System.out.println("Nineteen");
                    break;
                case 20:
                    System.out.println("Twenty");
                    break;

            }
        } else if (number < 100) {
            System.out.println(number+" is "+docChuc(number));
        } else if (number < 1000) {
            int tram = number / 100;
            String docTram;
            switch (tram) {
                case 1:
                    docTram = "One hundred";
                    break;
                case 2:
                    docTram = "Two hundred";
                    break;
                case 3:
                    docTram = "Three hundred";
                    break;
                case 4:
                    docTram = "Four hundred";
                    break;
                case 5:
                    docTram = "Five hundred";
                    break;
                case 6:
                    docTram = "Six hundred";
                    break;
                case 7:
                    docTram = "Seven hundred";
                    break;
                case 8:
                    docTram = "Eight hundred";
                    break;
                case 9:
                    docTram = "Nine hundred";
                    break;
                default:
                    docTram = "Nope";
                    break;
            }
            System.out.println(number + " is " + docTram + " " + docChuc(number));
        }else{
            System.out.println("Chỉ đọc số nhỏ hơn 1000");
        }
    }
    public static String docChuc(int num) {
        String docDv, docChuc;
        int donVi = num % 10;
        int chuc = 0;
        int length = Integer.toString(num).length();
        if (length == 2) {
            chuc = num / 10;
        } else {
            num /= 10;
            chuc = num % 10;
        }
        switch (donVi) {
            case 1:
                docDv = "one";
                break;
            case 2:
                docDv = "two";
                break;
            case 3:
                docDv = "three";
                break;
            case 4:
                docDv = "four";
                break;
            case 5:
                docDv = "five";
                break;
            case 6:
                docDv = "six";
                break;
            case 7:
                docDv = "seven";
                break;
            case 8:
                docDv = "eight";
                break;
            case 9:
                docDv = "nine";
                break;
            default:
                docDv = "";
                break;
        }
        switch (chuc) {
            case 2:
                docChuc = "twenty";
                break;
            case 3:
                docChuc = "thirty";
                break;
            case 4:
                docChuc = "forty";
                break;
            case 5:
                docChuc = "fifty";
                break;
            case 6:
                docChuc = "sixty";
                break;
            case 7:
                docChuc = "seventy";
                break;
            case 8:
                docChuc = "eighty";
                break;
            case 9:
                docChuc = "ninety";
                break;
            default:
                docChuc = "";
                break;
        }
        return docChuc + " " + docDv;
    }
}
