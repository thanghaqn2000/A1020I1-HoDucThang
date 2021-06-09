package thi_module_2.common.int_out_put;

import thi_module_2.models.BenhAnThuong;
import thi_module_2.models.BenhAnVIP;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static furama_resorts.manager.EmployeeManager.COMMON;

public class IntOut {
    public final static String MEDICAL_RECORDS_PATH = "E:\\GitHub\\A1020I1-HoDucThang\\module2\\src\\thi_module_2\\data\\medical_records.csv";
    public static void writeBenhBan(List<String> listBenhAn,boolean check){
        try {
            FileWriter fileWriter = new FileWriter(MEDICAL_RECORDS_PATH, check);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String benhAnVip=null;
            for (int i = 0; i <listBenhAn.size() ; i++) {
                benhAnVip+=listBenhAn.get(i);
                bufferedWriter.write(benhAnVip);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileBenhAnVip(List<BenhAnVIP> benhAnVIP, boolean check) {
        try {
            FileWriter fileWriter = new FileWriter(MEDICAL_RECORDS_PATH, check);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (BenhAnVIP itemBenhAnVip : benhAnVIP) {
                String benhAnVip;
                benhAnVip = itemBenhAnVip.getSttBenhan() + COMMON + itemBenhAnVip.getMaBenhAn() +
                        COMMON + itemBenhAnVip.getMaBenhNhan() + COMMON
                        + itemBenhAnVip.getTenBenhNhan() + COMMON + itemBenhAnVip.getNgayNhapVien() + COMMON
                        + itemBenhAnVip.getNgayRaVien() + COMMON +
                        itemBenhAnVip.getLiDoNhapVien() + COMMON + itemBenhAnVip.getLoaiVip() + COMMON + itemBenhAnVip.getThoiHanVip();
                bufferedWriter.write(benhAnVip);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileBenhAnThuong(List<BenhAnThuong> benhAnThuong, boolean check) {
        try {
            FileWriter fileWriter = new FileWriter(MEDICAL_RECORDS_PATH, check);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (BenhAnThuong itemBenhAnThuong : benhAnThuong) {
                String benhAnNormal;
                benhAnNormal = itemBenhAnThuong.getSttBenhan() + COMMON + itemBenhAnThuong.getMaBenhAn() + COMMON
                        + itemBenhAnThuong.getMaBenhNhan() + itemBenhAnThuong.getTenBenhNhan() +
                        COMMON + itemBenhAnThuong.getNgayNhapVien() + COMMON + itemBenhAnThuong.getNgayRaVien() + COMMON +
                        itemBenhAnThuong.getLiDoNhapVien() + COMMON + itemBenhAnThuong.getPhiNamVien();
                bufferedWriter.write(benhAnNormal);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> readBenhNhan(){
        List<String> list=new ArrayList<>();
        try {
            String temp;
            FileReader fileReader=new FileReader(new File(MEDICAL_RECORDS_PATH));
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            while ((temp=bufferedReader.readLine())!=null){
               list.add(temp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
