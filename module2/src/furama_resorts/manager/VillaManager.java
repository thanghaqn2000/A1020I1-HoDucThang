package furama_resorts.manager;

import furama_resorts.common.Input_Output;
import furama_resorts.models.Booking;
import furama_resorts.models.Customer;
import furama_resorts.models.Villa;

import java.util.*;

import static furama_resorts.common.Validate.ValidateForAll.onlyString;
import static furama_resorts.common.Validate.ValidateServices.*;
import static furama_resorts.common.Validate.ValidateServices.checkFloor;
import static furama_resorts.common.Input_Output.*;

public class VillaManager {
    public static final String WRONG = "Enter incorrectly , please enter again";
    public static final String COMMON = ",";
    static Scanner input = new Scanner(System.in);

    public static void addNewVilla(Villa villa) {
        String id;
        String service;
        String rentalType;
        String standardRoom;
        String describeRoom;
        double areaPool;
        double areaUsed;
        int rentalCosts;
        int amountPeople;
        int floor;
        //add id
        System.out.println("Info Villa");
        do {
            System.out.println("Input id Villa: (SVVl-YYYY)(Y is 0-9)");
            id = input.nextLine();
            if (!validateVilla(id))
                System.out.println(WRONG);
            else
                villa.setId(id);
        } while (!validateVilla(id));
        //add ten dich vu
        do {
            System.out.println("Enter name service");
            service = input.nextLine();
            if (!checkNameServicesTypeRentStandard(service))
                System.out.println(WRONG);
            else
                villa.setTenDichVu(service);
        } while (!checkNameServicesTypeRentStandard(service));
        //add kieu thue
        do {
            System.out.println("Enter rental type(kieu thue)");
            rentalType = input.nextLine();
            if (!checkNameServicesTypeRentStandard(rentalType))
                System.out.println(WRONG);
            else
                villa.setKieuThue(rentalType);
        } while (!checkNameServicesTypeRentStandard(rentalType));
        //add tieu chuan phong
        do {
            System.out.println("Enter room's standard(tieu chuan phong)");
            standardRoom = input.nextLine();
            if (!checkNameServicesTypeRentStandard(standardRoom))
                System.out.println(WRONG);
            else
                villa.setTieuChuanPhong(standardRoom);
        } while (!checkNameServicesTypeRentStandard(standardRoom));
        //add mo ta tien nghi
        do {
            System.out.println("Enter descirbe convenient(mo ta tien nghi)");
            describeRoom = input.nextLine();
            if (!onlyString(describeRoom))
                System.out.println(WRONG);
            else
                villa.setMoTaTienNghi(describeRoom);
        } while (!onlyString(describeRoom));

        //add chi phi thue
        do {
            System.out.println("Enter rental costs(chi phi thue)");
            rentalCosts = input.nextInt();
            if (!checkRentalCosts(rentalCosts))
                System.out.println(WRONG);
            else
                villa.setChiPhiThue(rentalCosts);
        } while (!checkRentalCosts(rentalCosts));

        //add so luong nguoi
        do {
            System.out.println("Enter amount people(amount<20)(so luong nguoi)");
            amountPeople = input.nextInt();
            if (!checkAmountMaxPeople(amountPeople))
                System.out.println(WRONG);
            else
                villa.setSoLuongNguoi(amountPeople);
        } while (!checkAmountMaxPeople(amountPeople));
        //add so tang
        do {
            System.out.println("Enter floor(so tang)");
            floor = input.nextInt();
            if (!checkFloor(floor))
                System.out.println(WRONG);
            else
                villa.setSoTang(floor);
        } while (!checkFloor(floor));
        //add dien tich su dung
        do {
            System.out.println("Enter area used >30m2");
            areaUsed = input.nextDouble();
            if (areaUsed >= 30)
                villa.setDienTichSuDung(areaUsed);
            else
                System.out.println(WRONG);
        } while (areaUsed < 30);

        //add dien tich ho boi
        do {
            System.out.println("Enter pool's area(dien tich ho boi >30m2)");
            areaPool = input.nextDouble();
            if (!checkSwimingBoolArea(areaPool))
                System.out.println(WRONG);
            else
                villa.setDienTichHoBoi(areaPool);
        } while (!checkSwimingBoolArea(areaPool));
        System.err.printf("Add villa %s success  \n",villa.getId());
        //Them vao file Villa.csv
        writeFileVilla(villa,true);
    }

    public static void showVilla() {
        List<Villa> listVilla = Input_Output.readVilla(VILLA_PATH);
        for (int i = 0; i < listVilla.size(); i++) {
            System.out.println("STT: " + (i + 1) + " " + listVilla.get(i).toString());
        }
    }
    public static void bookingVilla(List<Booking> listBooking, List<Customer> listCus, Booking booking, int choice) {
        List<Villa> listVilla = Input_Output.readVilla(VILLA_PATH);
        for (int i = 0; i < listVilla.size(); i++) {
            System.out.println("STT: " + (i + 1) + " " + listVilla.get(i).toString());
        }
        System.out.println("Choose villa :");
        int chooseVilla = Integer.parseInt(input.nextLine());
        Villa villa = listVilla.get(chooseVilla - 1);
//        booking.setIdService(listVilla.get(chooseVilla-1).getId());
        booking.setIdService(villa.getId());
        listBooking.add(booking);
        String lineBook;
        for (Booking itemBook : listBooking) {
            lineBook = booking.getIdCustomer() + COMMON + booking.getIdService();
            Input_Output.writeFile(BOOKING_PATH, lineBook,true);
        }
        System.out.println("Booked villa " + listVilla.get(chooseVilla - 1).getId() +
                " success for customer " + listCus.get(choice - 1).getNameOfCustomer());
    }
    public static void showAllVillaNotDuplicated() {
        Set<String> villaNotDuplicated = new TreeSet<>();
        List<Villa> listVilla = Input_Output.readVilla(VILLA_PATH);
        for (int i = 0; i < listVilla.size(); i++) {
            villaNotDuplicated.add(listVilla.get(i).getTenDichVu());
        }
        System.out.println("List's villa not duplicate:");
       int i =0;
        for (String nameVilla : villaNotDuplicated) {
            i++;
            System.out.println("STT "+i+": "+nameVilla);
        }
    }
}
