package finalmodule.common.validate;

public class VaildatePhuongTien {
    private static  String regex="";
    public static boolean validateOtoDuLich(String bienKiemSoat) {
        regex = "[0-9]{2}A-[0-9]{3}.[0-9]{2}";
        return bienKiemSoat.matches(regex);
    }
    public static boolean validateOtoKhach(String bienKiemSoat) {
        regex = "[0-9]{2}B-[0-9]{3}.[0-9]{2}";
        return bienKiemSoat.matches(regex);
    }
}
