package furama_resorts.manager;

import furama_resorts.common.Input_Output;
import furama_resorts.models.Booking;
import furama_resorts.models.Customer;
import furama_resorts.models.House;

import java.util.*;

import static furama_resorts.common.Validate.ValidateForAll.onlyString;
import static furama_resorts.common.Validate.ValidateServices.*;
import static furama_resorts.common.Validate.ValidateServices.checkFloor;
import static furama_resorts.common.Input_Output.*;

public class HouseManager {
    public static final String WRONG = "Enter incorrectly , please enter again";
    public static final String COMMON = ",";
    static Scanner input = new Scanner(System.in);

    public static void addNewHouse(House house) {
        String id;
        String service;
        String rentalType;
        String standardRoom;
        String describeRoom;
        int rentalCosts;
        int amountPeople;
        int floor;
        double areaUsed;
        System.out.println("Info House");
        do {
            System.out.println("Input id House: (SVHO-YYYY)(Y is 0-9)");
            id = input.nextLine();
            if (!validateHouse(id))
                System.out.println(WRONG);
            else
                house.setId(id);
        } while (!validateHouse(id));
        //add ten dich vu
        do {
            System.out.println("Enter name service");
            service = input.nextLine();
            if (!checkNameServicesTypeRentStandard(service))
                System.out.println(WRONG);
            else
                house.setTenDichVu(service);
        } while (!checkNameServicesTypeRentStandard(service));
        //add mo ta tien nghi
        do {
            System.out.println("Enter descirbe convenient(mo ta tien nghi)");
            describeRoom = input.nextLine();
            if (!onlyString(describeRoom))
                System.out.println(WRONG);
            else
                house.setMoTaTienNghi(describeRoom);
        } while (!onlyString(describeRoom));

        //add tieu chuan phong
        do {
            System.out.println("Enter room's standard(tieu chuan phong");
            standardRoom = input.nextLine();
            if (!checkNameServicesTypeRentStandard(standardRoom))
                System.out.println(WRONG);
            else
                house.setTieuChuanPhong(standardRoom);
        } while (!checkNameServicesTypeRentStandard(standardRoom));

        //add kieu thue
        do {
            System.out.println("Enter rental type(kieu thue)");
            rentalType = input.nextLine();
            if (!checkNameServicesTypeRentStandard(rentalType))
                System.out.println(WRONG);
            else
                house.setKieuThue(rentalType);
        } while (!checkNameServicesTypeRentStandard(rentalType));
        //add so tang
        do {
            System.out.println("Enter floor(so tang)");
            floor = input.nextInt();
            if (!checkFloor(floor))
                System.out.println(WRONG);
            else
                house.setSoTang(floor);
        } while (!checkFloor(floor));

        //add chi phi thue
        do {
            System.out.println("Enter rental costs(chi phi thue)");
            rentalCosts = input.nextInt();
            if (!checkRentalCosts(rentalCosts))
                System.out.println(WRONG);
            else
                house.setChiPhiThue(rentalCosts);
        } while (!checkRentalCosts(rentalCosts));
        //add so luong nguoi
        do {
            System.out.println("Enter amount people(amount<20)(so luong nguoi)");
            amountPeople = input.nextInt();
            if (!checkAmountMaxPeople(amountPeople))
                System.out.println(WRONG);
            else
                house.setSoLuongNguoi(amountPeople);
        } while (!checkAmountMaxPeople(amountPeople));

        //add dien tich su dung
        do {
            System.out.println("Enter area used >30m2");
            areaUsed = input.nextDouble();
            if (areaUsed >= 30)
                house.setDienTichSuDung(areaUsed);
            else
                System.out.println(WRONG);
        } while (areaUsed < 30);
        System.err.printf("Add house %s success \n",house.getId());
        //Them vao file House.csv
        writeFileHouse(house,true);
    }

    public static void showHouse() {
        List<House> listHouse = Input_Output.readHouse(HOUSE_PATH);
        for (int i = 0; i <listHouse.size() ; i++) {
            System.out.printf("STT %d | %s",(i+1),listHouse.get(i).toString());
        }
    }

    public static void bookingHouse(List<Booking> listBooking, List<Customer> listCus, Booking booking, int choice) {
        List<House> listHouse = Input_Output.readHouse(HOUSE_PATH);
        for (int i = 0; i < listHouse.size(); i++) {
            System.out.println("STT: " + (i + 1) + " " + listHouse.get(i).toString());
        }
        System.out.println("Chọn house :");
        int chooseHouse = input.nextInt();
        House house = listHouse.get(chooseHouse - 1);
        booking.setIdService(house.getId());
        listBooking.add(booking);
        String lineBook;
        for (Booking itemBook : listBooking) {
            lineBook = booking.getIdCustomer() + COMMON + booking.getIdService();
            Input_Output.writeFile(BOOKING_PATH, lineBook,true);
        }
        System.out.println("Đã book Villa: " + listHouse.get(chooseHouse - 1).getId() +
                " thành công cho khách hàng: " + listCus.get(choice - 1).getNameOfCustomer());
    }

    public static void showAllHouseNotDuplicated() {
        Set<String> houseNotDuplicated = new TreeSet<>();
        List<House> listhouse = Input_Output.readHouse(HOUSE_PATH);
        for (int i = 0; i < listhouse.size(); i++) {
            houseNotDuplicated.add(listhouse.get(i).getTenDichVu());
        }
        System.out.println("Danh sách tên các House không trùng nhau:");
        for (String nameHouse : houseNotDuplicated) {
            System.out.println(nameHouse);
        }
    }
}
