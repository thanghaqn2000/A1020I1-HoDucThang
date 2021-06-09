package thi_module_2.controller;

import java.util.Scanner;

import static thi_module_2.controller.BenhAnController.*;

public class MainController {
    static Scanner input = new Scanner(System.in);
    static boolean check = true;
    static int choose = 0;
    public static void displayMainMenu() {
        do {
            try {
                System.out.println("--Chương trình quản lí bệnh án--\n"
                        + "Chọn chức năng theo số(để tiếp tục) \n" +
                        "1. Thêm mới " + "\n" +
                        "2. Xóa" + "\n" +
                        "3. Xem danh sách các bệnh án" + "\n" +
                        "4. Thoát");
                choose = Integer.parseInt(input.nextLine());
                switch (choose) {
                    case 1:
                        AddNewBenhAn();
                        break;
                    case 2:
                        xoaBenhNhan();
                        break;
                    case 3:
                        showAll();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Không có trong menu , hãy chọn lại");
                        break;
                }
            }catch (Exception e){
                System.err.println("Nhập ko đúng hãy nhập lại");
            }
        } while (check);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
