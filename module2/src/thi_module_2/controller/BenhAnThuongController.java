package thi_module_2.controller;

import thi_module_2.models.BenhAnThuong;
import thi_module_2.models.BenhAnVIP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static thi_module_2.common.validate.ValidateBenhAn.*;
import static thi_module_2.common.validate.ValidateBenhAn.checkNgayNhapRaVip;
import static thi_module_2.common.int_out_put.IntOut.*;
public class BenhAnThuongController {
    public static final String WRONG = "Enter incorrectly , please enter again";
    static Scanner input = new Scanner(System.in);
    public static void addNewThuong(BenhAnThuong benhAnThuong) {
        boolean check = true;
        List<BenhAnThuong> benhAnThuongList = new ArrayList<>();
        String sttBenhAn;
        String maBenhAn;
        String maBenhNhan;
        String tenBenhNhan;
        String ngayNhapVien;
        String ngayRaVien;
        String liDoNhapVien;
        double phiNamVien;
        //add id
        System.out.println("Thông tin bệnh án thường");
        //add ten dich vu
        System.out.println("Nhập vào stt");
        sttBenhAn = input.nextLine();
        benhAnThuong.setSttBenhan(sttBenhAn);

        //add kieu thue
        do {
            System.out.println("Nhập vào mã bệnh án");
            maBenhAn = input.nextLine();
            if (!checkMaBenhAn(maBenhAn))
                System.out.println(WRONG);
            else
                benhAnThuong.setMaBenhAn(maBenhAn);
        } while (!checkMaBenhAn(maBenhAn));
        //add tieu chuan phong
        do {
            System.out.println("Nhập vào mã bệnh nhân");
            maBenhNhan = input.nextLine();
            if (!checkMaBenhNhan(maBenhNhan))
                System.out.println(WRONG);
            else
                benhAnThuong.setMaBenhNhan(maBenhNhan);
        } while (!checkMaBenhNhan(maBenhNhan));
        do {
            System.out.println("Nhập vào tên bệnh nhân");
            tenBenhNhan = input.nextLine();
            if (!checkOnlyString(tenBenhNhan))
                System.out.println(WRONG);
            else
                benhAnThuong.setTenBenhNhan(tenBenhNhan);
        } while (!checkOnlyString(tenBenhNhan));
        do {
            System.out.println("Nhập vào ngày nhập viện");
            ngayNhapVien = input.nextLine();
            if (!checkNgayNhapRaVip(ngayNhapVien))
                System.out.println(WRONG);
            else
                benhAnThuong.setNgayNhapVien(ngayNhapVien);
        } while (!checkNgayNhapRaVip(ngayNhapVien));

        do {
            System.out.println("Nhập vào ngày ra viện");
            ngayRaVien = input.nextLine();
            if (!checkNgayNhapRaVip(ngayRaVien))
                System.out.println(WRONG);
            else
                benhAnThuong.setNgayRaVien(ngayRaVien);
        } while (!checkNgayNhapRaVip(ngayRaVien));
        //add mo ta tien nghi
        do {
            System.out.println("Nhập vào lí do nhập viện");
            liDoNhapVien = input.nextLine();
            if (!checkOnlyString(liDoNhapVien))
                System.out.println(WRONG);
            else
                benhAnThuong.setLiDoNhapVien(liDoNhapVien);
        } while (!checkOnlyString(liDoNhapVien));

            System.out.println("Nhập vào phí nằm viện");
            phiNamVien = Double.parseDouble(input.nextLine());
            benhAnThuong.setPhiNamVien(phiNamVien);
        benhAnThuongList.add(benhAnThuong);
        writeFileBenhAnThuong(benhAnThuongList, true);
        System.err.printf("Add bệnh nhân %s success  \n", benhAnThuong.getTenBenhNhan());
    }
}
