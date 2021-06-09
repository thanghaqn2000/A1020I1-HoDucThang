package thi_module_2.common.validate;

import furama_resorts.common.exception.user_exception.BirthdayException;

import java.time.LocalDate;
import java.time.Period;

public class ValidateBenhAn {

    private static String regex = "";

    public static boolean checkMaBenhAn(String maBenhAn) {
        regex = "^BA-[\\d]{3}$";
        return maBenhAn.matches(regex);
    }

    public static boolean checkMaBenhNhan(String maBenhNhan) {
        regex = "^BN-[\\d]{3}$";
        return maBenhNhan.matches(regex);
    }

    public static boolean checkNgayNhapRaVip(String dof) {
        boolean check;
        LocalDate birthday;
        regex = "\\b(0?[1-9]|[12]\\d|3[01])[\\/\\-.](0?[1-9]|[12]\\d|3[01])[\\/\\-.](\\d{2}|\\d{4})\\b";
        check = dof.matches(regex);
        if (check) {
            String[] dateString = dof.split("/");
            int date = Integer.parseInt(dateString[0]);
            int month = Integer.parseInt(dateString[1]);
            int year = Integer.parseInt(dateString[2]);
            try {
                birthday = LocalDate.of(year, month, date);
            } catch (Exception e) {
                check = false;
            }
            LocalDate today = LocalDate.now();
            if (year < 1900) {
                check = false;
            }
        } else {
            check = false;
        }
        return check;
    }

    public static boolean checkOnlyString(String str) {
        regex = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
        return str.matches(regex);
    }

    public static boolean checkLoaiVip(String loaiVip) {
        regex = "(VIP I|VIP II|VIP III)";
        return loaiVip.matches(regex);
    }

}
