package test;

import java.io.*;
import java.util.ArrayList;

public class test {
    public static boolean luuFile(ArrayList<String> dsData, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (String data : dsData) {
                bw.write(data);
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<String> docFile(String path) {
        ArrayList<String> dsData = new ArrayList<String>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (br.readLine() != null) {
                if (br.readLine().length() > 0)
                    dsData.add(line);
                line = br.readLine();
            }

            br.close();
            isr.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsData;

    }
}
