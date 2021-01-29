package furama_resorts.validate;

public class CheckValidate {

    private static String regex = "";

    public static boolean validateVilla(String idVilla) {
        regex = "^SVVL-[\\d]{4}$";
        return idVilla.matches(regex);
    }

    public static boolean validateHouse(String idHouse) {
        regex = "^SVHO-[\\d]{4}$";
        return idHouse.matches(regex);
    }

    public static boolean validateRoom(String idRoom) {
        regex = "^SVRO-[\\d]{4}$";
        return idRoom.matches(regex);
    }

    public static boolean checkNameServices(String nameService) {
        regex = "^[A-Z][a-z]{0,}([\\\\s][A-Z][a-z]{0,})*$";
        return nameService.matches(regex);
    }

    public static boolean checkUseArea(double area) {
        return area > 30;
    }

    public static boolean checkSwimingBoolArea(double areaPool) {
        return areaPool > 30;
    }

}
