package stack_queue.demegring;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class In_Out {
    public final static String HUMAN_PATH=
            "E:\\GitHub\\A1020I1-HoDucThang\\module2\\src\\stack_queue\\demegring\\data\\Human.csv";
    public static void writeHumansToCSV(Queue<Human> humanList, String filePath) {
        //**Method writing service list to the file following the file path.
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath,true);
            for (Human human : humanList) {
                fileWriter.append(human.writeToCSV());
                fileWriter.append(",");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
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
}
