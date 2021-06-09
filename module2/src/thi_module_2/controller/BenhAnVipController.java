package thi_module_2.controller;

import furama_resorts.common.Input_Output;
import furama_resorts.models.Villa;
import thi_module_2.models.BenhAnVIP;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static furama_resorts.common.Input_Output.VILLA_PATH;
import static thi_module_2.common.validate.ValidateBenhAn.*;
import static thi_module_2.common.int_out_put.IntOut.*;

public class BenhAnVipController {
    public static final String WRONG = "Enter incorrectly , please enter again";
    public static final String COMMON = ",";
    static Scanner input = new Scanner(System.in);

    public static void addNewVip(BenhAnVIP benhAnVIP) {
        boolean check = true;
        List<BenhAnVIP> benhAnVIPList = new ArrayList<>();
        String sttBenhAn;
        String maBenhAn;
        String maBenhNhan;
        String tenBenhNhan;
        String ngayNhapVien;
        String ngayRaVien;
        String liDoNhapVien;
        String loaiVIP;
        String thoiHanVIP;
        //add id
        System.out.println("Thông tin bệnh án vip");
        //add ten dich vu

            System.out.println("Nhập vào stt");
            sttBenhAn = input.nextLine();
            benhAnVIP.setSttBenhan(sttBenhAn);

        //add kieu thue
        do {
            System.out.println("Nhập vào mã bệnh án");
            maBenhAn = input.nextLine();
            if (!checkMaBenhAn(maBenhAn))
                System.out.println(WRONG);
            else
                benhAnVIP.setMaBenhAn(maBenhAn);
        } while (!checkMaBenhAn(maBenhAn));
        //add tieu chuan phong
        do {
            System.out.println("Nhập vào mã bệnh nhân");
            maBenhNhan = input.nextLine();
            if (!checkMaBenhNhan(maBenhNhan))
                System.out.println(WRONG);
            else
                benhAnVIP.setMaBenhNhan(maBenhNhan);
        } while (!checkMaBenhNhan(maBenhNhan));
        do {
            System.out.println("Nhập vào tên bệnh nhân");
            tenBenhNhan = input.nextLine();
            if (!checkOnlyString(tenBenhNhan))
                System.out.println(WRONG);
            else
                benhAnVIP.setTenBenhNhan(tenBenhNhan);
        } while (!checkOnlyString(tenBenhNhan));
        do {
            System.out.println("Nhập vào ngày nhập viện");
            ngayNhapVien = input.nextLine();
            if (!checkNgayNhapRaVip(ngayNhapVien))
                System.out.println(WRONG);
            else
                benhAnVIP.setNgayNhapVien(ngayNhapVien);
        } while (!checkNgayNhapRaVip(ngayNhapVien));

        do {
            System.out.println("Nhập vào ngày ra viện");
            ngayRaVien = input.nextLine();
            if (!checkNgayNhapRaVip(ngayRaVien))
                System.out.println(WRONG);
            else
                benhAnVIP.setNgayRaVien(ngayRaVien);
        } while (!checkNgayNhapRaVip(ngayRaVien));
        //add mo ta tien nghi
        do {
            System.out.println("Nhập vào lí do nhập viện");
            liDoNhapVien = input.nextLine();
            if (!checkOnlyString(liDoNhapVien))
                System.out.println(WRONG);
            else
                benhAnVIP.setLiDoNhapVien(liDoNhapVien);
        } while (!checkOnlyString(liDoNhapVien));
        do {
            System.out.println("Nhập vào loại VIP");
            loaiVIP = input.nextLine();
            if (!checkLoaiVip(loaiVIP))
                System.out.println(WRONG);
            else
                benhAnVIP.setLoaiVip(loaiVIP);
        } while (!checkLoaiVip(loaiVIP));

        do {
            System.out.println("Nhập vào thời hạn VIP");
            thoiHanVIP = input.nextLine();
            if (!checkNgayNhapRaVip(thoiHanVIP))
                System.out.println(WRONG);
            else
                benhAnVIP.setThoiHanVip(thoiHanVIP);
        } while (!checkNgayNhapRaVip(thoiHanVIP));
        benhAnVIPList.add(benhAnVIP);
        writeFileBenhAnVip(benhAnVIPList, true);
        System.err.printf("Add bệnh nhân %s success  \n", benhAnVIP.getTenBenhNhan());
    }

}
