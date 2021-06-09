package finalmodule.controller;

import finalmodule.models.Oto;

import java.util.Scanner;
import static furama_resorts.manager.CustomerManager.functionCustomer;
import static finalmodule.controller.OtoController.*;

public class MainControllers {
    static Scanner input = new Scanner(System.in);
    static boolean check = true;
    static int choose = 0;

    public static void displayMainMenu() {
        do {
            try {
                System.out.println("--MENU FINAL MODULE--\n" + "1. Thêm mới phương tiện " + "\n" +
                        "2. Hiển thị phương tiện" + "\n" +
                        "3. Xóa phương tiện" + "\n" +
                        "4. Thoát");
                choose = Integer.parseInt(input.nextLine());
                switch (choose) {
                    case 1:
                        Oto oto = new Oto();
                        addNewOto(oto);
                        break;
                    case 2:
                        showOto();
                        break;
                    case 3:
                        functionCustomer();
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
        } while (check);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
