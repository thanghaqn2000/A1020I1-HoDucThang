package finalmodule.common.input_output;

import finalmodule.models.Oto;
import furama_resorts.models.Villa;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

import static furama_resorts.manager.EmployeeManager.COMMON;

public class IntOut {
    public final static String XEMAY_PATH = "E:\\GitHub\\A1020I1-HoDucThang\\module2\\src\\finalmodule\\data\\xemay.csv";
    public final static String OTO_PATH = "E:\\GitHub\\A1020I1-HoDucThang\\module2\\src\\finalmodule\\data\\oto.csv";
    public final static String XETAI_PATH = "E:\\GitHub\\A1020I1-HoDucThang\\module2\\src\\finalmodule\\data\\xetai.csv";
    public static void writeFile(String path, String line, boolean check) {
        try {
            FileWriter fileWriter = new FileWriter(path, check);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeFileOto(List<Oto> listOto, boolean check) {
        try {
            FileWriter fileWriter = new FileWriter(OTO_PATH, check);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Oto itemOto : listOto) {
                String lineOto;
                lineOto = itemOto.getBienKiemSoat() + COMMON + itemOto.getTenHangSX() + COMMON
                        + itemOto.getNamSanXuat() + COMMON + itemOto.getChuSoHuu() + COMMON + itemOto.getSoChoNgoi() + COMMON +
                        itemOto.getKieuXe() ;
                bufferedWriter.write(lineOto);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public static List<Oto>readOto(String path) {
        List<String> list = readFile(path);
        List<Oto> otoList = new ArrayList<>();
        String[] arrOto = null;
        for (String i : list) {
            arrOto = i.split(",");
            Oto oto = new Oto(arrOto[0], arrOto[1], arrOto[2], arrOto[3],
                    arrOto[4], arrOto[5]);
            otoList.add(oto);
        }
        return otoList;
    }
}
