package vn.codegym.common;

import vn.codegym.model.bean.ChuyenBay;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Input_Output {
    public final static String CB_PATH = "E:\\GitHub\\A1020I1-HoDucThang\\module4\\temp\\Code\\ChuyenBay.csv";
    public static final String COMMON = ",";
    public final static String HEADER="Id,Số hiệu,Tuyến bay,Loại tuyến bay";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public static void writeFileCB(List<ChuyenBay> listCB, boolean check) {
        try {
            FileWriter fileWriter = new FileWriter(CB_PATH, check);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            fileWriter.append(HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (ChuyenBay itemCB : listCB) {
                String lineCB;
                lineCB = itemCB.getId() + COMMON + itemCB.getSoHieu().getSoHieu() + COMMON
                        + itemCB.getTuyenBay().getTenTuyenBay() + COMMON + itemCB.getTuyenBay().getLoaiTuyenBay().getTenLoaiTuyenBay();
                bufferedWriter.write(lineCB);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
