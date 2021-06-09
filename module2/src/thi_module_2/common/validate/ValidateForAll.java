package thi_module_2.common.validate;

public class ValidateForAll {

    public static String regex="";
    public static boolean onlyString(String str){
        regex="^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
        return str.matches(regex);
    }
    public static String uppercaseFirst(String str) {
        String temp = str.substring(0, 1).toUpperCase() + str.substring(1);
        return temp;
    }
}
