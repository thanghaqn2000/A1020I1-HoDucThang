package lop_va_doi_tuong.fan;

public class FanMain {
    public static void main(String[] args) {
        Fan fan1 =new Fan(Fan.SLOW,true,10,"yellow");
        System.out.println(fan1.toString());
        Fan fan2 =new Fan(Fan.MEDIUM,false,5,"Blue");
        fan2.setColor(fan2.getColor());
        System.out.println(fan2.toString());
    }
}
