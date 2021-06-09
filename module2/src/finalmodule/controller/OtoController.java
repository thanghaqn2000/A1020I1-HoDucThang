package finalmodule.controller;

import finalmodule.models.Oto;
import furama_resorts.common.Input_Output;
import furama_resorts.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static finalmodule.common.input_output.IntOut.OTO_PATH;
import static finalmodule.common.input_output.IntOut.*;
import static finalmodule.common.validate.VaildatePhuongTien.*;


import static furama_resorts.common.Validate.ValidateForAll.onlyString;
import static furama_resorts.common.Validate.ValidateServices.*;


public class OtoController {
    public static final String WRONG = "Enter incorrectly , please enter again";
    public static final String COMMON = ",";
    static Scanner input = new Scanner(System.in);

    public static void addNewOto(Oto oto) {
        boolean check = true;
        List<Oto> otoList = new ArrayList<>();
        String bienKiemSoat = "";
        String hangSx;
        String namSx;
        String chuSoHuu;
        String soChoNgoi;
        String kieuXe;
        //add id
        System.out.println("Thông tin xe oto");
        do {
            System.out.println("Nhập vào kiểu xe:\n" + "-Xe du lịch\n" + "-Xe khách");
            kieuXe = (input.nextLine());
            switch (kieuXe) {
                case "du lich":
                    oto.setKieuXe(kieuXe);
                    System.out.println("Nhập vào biển kiểm soát: XXA-XXX.XX ");
                    bienKiemSoat = input.nextLine();
                    if (!validateOtoDuLich(bienKiemSoat)) {
                        System.out.println(WRONG);
                        check = false;
                    } else{
                        oto.setBienKiemSoat(bienKiemSoat);
                        check = true;
                    }
                    break;
                case "khach":
                    oto.setKieuXe(kieuXe);
                    System.out.println("Nhập vào biển kiểm soát: XXB-XXX.XX ");
                    bienKiemSoat = input.nextLine();
                    if (!validateOtoKhach(bienKiemSoat)) {
                        System.out.println(WRONG);
                        check = false;
                    } else{
                        oto.setBienKiemSoat(bienKiemSoat);
                        check = true;
                    }
                    break;
                default:
                    System.out.println("Hãy chọn lại kiểu xe");
                    check=false;
            }
        } while (!check);
        //add ten dich vu
        do {
            System.out.println("Nhập vào hãng sản xuất");
            hangSx = input.nextLine();
            if (!checkNameServicesTypeRentStandard(hangSx))
                System.out.println(WRONG);
            else
                oto.setTenHangSX(hangSx);
        } while (!checkNameServicesTypeRentStandard(hangSx));
        //add kieu thue

            System.out.println("Nhập vào năm sản xuất");
            namSx = input.nextLine();
            oto.setNamSanXuat(namSx);
        //add tieu chuan phong
        do {
            System.out.println("Nhập vào chủ sỡ hữu");
            chuSoHuu = input.nextLine();
            if (!checkNameServicesTypeRentStandard(chuSoHuu))
                System.out.println(WRONG);
            else
                oto.setChuSoHuu(chuSoHuu);
        } while (!checkNameServicesTypeRentStandard(chuSoHuu));
        //add mo ta tien nghi
            System.out.println("Nhập vào số chỗ ngồi");
            soChoNgoi = input.nextLine();
            oto.setSoChoNgoi(soChoNgoi);
        otoList.add(oto);
        writeFileOto(otoList, true);
        System.err.printf("Add oto %s success  \n", oto.getKieuXe());
    }
    public static void showOto() {
        List<Oto> otoList = readOto(OTO_PATH);
        for (int i = 0; i < otoList.size(); i++) {
            System.out.println("STT: " + (i + 1) + " " + otoList.get(i).toString());
        }
    }
}
