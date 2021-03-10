package furama_resorts.common.Validate;

public class ValidateServices {

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

    public static boolean checkNameServicesTypeRentStandard(String nameService) {
        regex = "^[A-Z][a-z]{0,}([\\\\s][A-Z][a-z]{0,})*$";
        return nameService.matches(regex);
    }

    public static boolean checkUseArea(double area) {
        return area > 30;
    }

    public static boolean checkSwimingBoolArea(double areaPool) {
        return areaPool > 30;
    }

    public static boolean checkRentalCosts(int money) {
        return money > 0;
    }

    public static boolean checkAmountMaxPeople(int people) {
        return (people > 0 && people < 20) ? true : false;
    }

    public static boolean checkFloor(int floor) {
        return floor > 0;
    }

    public static boolean checkFreeServices(String service) {
        boolean check;
        switch (service.toLowerCase()) {
            case "massage":
            case "karaoke":
            case "food":
            case "drink":
            case "car":
                check = true;
                break;
            default:
                check = false;
                break;
        }
        return check;
    }

}
