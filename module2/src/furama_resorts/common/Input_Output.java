package furama_resorts.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Input_Output {
    public static void writeFile(String path, String line) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
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

    public static List<Customer> readCustomer(String path) {
        List<String> list = readFile(path);
        List<Customer> listCustomer = new ArrayList<>();
        String[] arrayCus = null;

        for (String i : list) {
            arrayCus = i.split(",");
            Customer customer = new Customer(arrayCus[0], arrayCus[1], arrayCus[2], arrayCus[3], arrayCus[4], arrayCus[5],
                    Integer.parseInt(arrayCus[6]), Integer.parseInt(arrayCus[7]));
            listCustomer.add(customer);
        }
        return listCustomer;
    }
}
