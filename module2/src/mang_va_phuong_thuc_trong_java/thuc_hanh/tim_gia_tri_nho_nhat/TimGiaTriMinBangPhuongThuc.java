package mang_va_phuong_thuc_trong_java.thuc_hanh.tim_gia_tri_nho_nhat;

public class TimGiaTriMinBangPhuongThuc {
    public static int minValue(int[] arr){
       int min=arr[0];
       for(int i=0;i<arr.length;i++){
           if(min>arr[i]){
               min=arr[i];
           }
       }
       return min;
    }
    public static void main(String[] args) {
        int[] arr={9,8,2,50,-20};
        int index=minValue(arr);
        System.out.println("The smallest element in the array is: " + index);
    }
}
