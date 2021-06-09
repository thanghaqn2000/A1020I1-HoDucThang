package thi_module_2.controller;

import furama_resorts.common.Input_Output;
import furama_resorts.models.Customer;
import thi_module_2.models.BenhAnThuong;
import thi_module_2.models.BenhAnVIP;

import java.util.List;
import java.util.Scanner;

import static furama_resorts.common.Input_Output.CUSTOMER_PATH;
import static furama_resorts.common.Input_Output.writeFileCus;
import static thi_module_2.common.int_out_put.IntOut.readBenhNhan;
import static thi_module_2.common.int_out_put.IntOut.writeBenhBan;
import static thi_module_2.controller.BenhAnThuongController.*;
import static thi_module_2.controller.BenhAnVipController.*;

public class BenhAnController {
    static Scanner input = new Scanner(System.in);
    static boolean check = true;
    static int choose = 0;

    public static void AddNewBenhAn() {
        do {
            try {
                System.out.println("--MENU BENH AN--\n"
                        + "1. Thêm mới bệnh án VIP" + "\n" +
                        "2.Thêm mới bệnh án thường " + "\n" +
                        "3. Thoát");
                choose = Integer.parseInt(input.nextLine());
                switch (choose) {
                    case 1:
                        BenhAnVIP benhAnVIP = new BenhAnVIP();
                        addNewVip(benhAnVIP);
                        break;
                    case 2:
                        BenhAnThuong benhAnThuong = new BenhAnThuong();
                        addNewThuong(benhAnThuong);
                        break;
                    case 3:
                        check = false;
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

    public static void showAll() {
        List<String> listBenhNhan = readBenhNhan();
        if(listBenhNhan.isEmpty()){
            System.out.println("Danh sách hiện tại đang trống");
        }else{
            for (int i = 0; i < listBenhNhan.size(); i++) {
                System.out.println("STT: " + (i + 1) + ": " + listBenhNhan.get(i));
            }
        }
    }

    public static void xoaBenhNhan() {
        boolean check = false;
        List<String> listBenhNhan = readBenhNhan();
        do {
            if(listBenhNhan.isEmpty()){
                System.err.println("Danh sách hiện tại đang trống");
                break;
            }
            for (int i = 0; i < listBenhNhan.size(); i++) {
                System.out.println("STT " + (i + 1) + ": " + listBenhNhan.get(i));
            }
            System.out.println("Chọn bệnh nhân muốn xóa");
            int choose = Integer.parseInt(input.nextLine());
            if (choose > listBenhNhan.size() || choose < 1) {
                System.err.println("Không tìm thấy  bệnh nhân cần xóa!");
                break;
            }
            System.err.printf("Bạn thật sự muốn xóa (y/n) \n");
            String yn = input.nextLine();
            if (yn.equalsIgnoreCase("y")) {
                listBenhNhan.remove(choose - 1);
                System.out.printf("Xóa thành công \n");
                System.out.println("Số bệnh nhân còn lại:");
                for (int i = 0; i < listBenhNhan.size(); i++) {
                    System.out.println("STT " + (i + 1) + ": " + listBenhNhan.get(i));
                }
                writeBenhBan(listBenhNhan, false);
            } else
                break;
        } while (check);
    }
}
