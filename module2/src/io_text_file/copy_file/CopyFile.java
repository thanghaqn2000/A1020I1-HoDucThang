package io_text_file.copy_file;

import java.io.*;

public class CopyFile {
    public final static String fileSend="E:\\GitHub\\A1020I1-HoDucThang\\module2\\src\\io_text_file\\copy_file\\data\\send.csv";
    public final static String fileTarget="E:\\GitHub\\A1020I1-HoDucThang\\module2\\src\\io_text_file\\copy_file\\data\\target.csv";
    public static void writeFile(String path,String line){
        try {
            FileWriter fileWriter=new FileWriter(new File(path),true);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readFile(String path){
        String line="";
        try {
            String temp;
            FileReader fileReader=new FileReader(new File(path));
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            while ((temp=bufferedReader.readLine())!=null){
                line+=temp;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    return line;
    }
    public static void main(String[] args) {
//        input vao file goc
        writeFile(fileSend,"duc thang");
        //input vao file copy tu file goc
        writeFile(fileTarget,readFile(fileSend));
//        in file da copy ra man hinh
        System.out.println(readFile(fileTarget));
    }
}
