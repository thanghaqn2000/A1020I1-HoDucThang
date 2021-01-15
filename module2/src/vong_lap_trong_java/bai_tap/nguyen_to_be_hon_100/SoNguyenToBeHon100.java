package vong_lap_trong_java.bai_tap.nguyen_to_be_hon_100;

public class SoNguyenToBeHon100 {
    public static void main(String[] args) {
        int num=2;
        String result="";
        while (num<100){
            boolean check=true;
            for(int i=2;i<num;i++){
                if(num%i==0){
                    check=false;
                    break;
                }
            }
            if(check){
                result+=num+",";
            }
            num++;
        }
        System.out.printf(result);
    }
}
