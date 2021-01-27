package lop_va_doi_tuong.fan;

public class FanMain {
    public static void main(String[] args) {
        Fan fan1 =new Fan(Fan.SLOW,true,10,"yellow");
        System.out.println(fan1.toString());
        Fan fan2 =new Fan();
        //fan2.getMEDIUM();
        System.out.println(fan2.toString());
    }
}
