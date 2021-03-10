package furama_resorts.manager;

import furama_resorts.common.Input_Output;
import furama_resorts.models.Booking;
import furama_resorts.models.Customer;
import furama_resorts.models.Room;

import java.util.*;

import static furama_resorts.common.Validate.ValidateForAll.onlyString;
import static furama_resorts.common.Validate.ValidateServices.*;
import static furama_resorts.common.Validate.ValidateServices.checkFreeServices;
import static furama_resorts.common.Input_Output.*;
public class RoomManager {
    public static final String WRONG = "Enter incorrectly , please enter again";
    public static final String COMMON = ",";
    static Scanner input=new Scanner(System.in);
    public static void addNewRoom(Room room) {
        String id;
        String service;
        String rentalType;
        String freeSevices;
        String nameUnit;
        int priceMoney;
        int rentalCosts;
        int amountPeople;
        double areaUsed;
        //input.nextLine();
        do {
            System.out.println("Input id Room: (SVRO-YYYY)(Y is 0-9)");
            id = input.nextLine();
            if (!validateRoom(id))
                System.out.println(WRONG);
            else
                room.setId(id);
        } while (!validateRoom(id));

        //add ten dich vu
        do {
            System.out.println("Enter name service");
            service = input.nextLine();
            if (!checkNameServicesTypeRentStandard(service))
                System.out.println(WRONG);
            else
                room.setTenDichVu(service);
        } while (!checkNameServicesTypeRentStandard(service));
        //add kieu thue
        do {
            System.out.println("Enter rental type(kieu thue)");
            rentalType = input.nextLine();
            if (!checkNameServicesTypeRentStandard(rentalType))
                System.out.println(WRONG);
            else
                room.setKieuThue(rentalType);
        } while (!checkNameServicesTypeRentStandard(rentalType));
        do {
            System.out.println("Enter free services(Massage,karaoke,food,drink,car)");
            freeSevices = input.nextLine();
            if (!checkFreeServices(freeSevices))
                System.out.println(WRONG);
            else
                room.setTenDVDiKem(freeSevices);

        } while (!checkFreeServices(freeSevices));
        //add ten don vi
        do {
            System.out.println("Enter unit's name(ten don vi)");
            nameUnit = input.nextLine();
            if (!onlyString(nameUnit))
                System.out.println(WRONG);
            else
                room.setDonVi(nameUnit);
        } while (!onlyString(nameUnit));



        //add gia tien
        do {
            System.out.println("Enter the price money");
            priceMoney = input.nextInt();
            if (priceMoney > 0)
                room.setGiaTien(priceMoney);
            else
                System.out.println(WRONG);
        } while (priceMoney <= 0);

        //add chi phi thue
        do {
            System.out.println("Enter rental costs(chi phi thue)");
            rentalCosts = input.nextInt();
            if (!checkRentalCosts(rentalCosts))
                System.out.println(WRONG);
            else
                room.setChiPhiThue(rentalCosts);
        } while (!checkRentalCosts(rentalCosts));
        //add so luong nguoi
        do {
            System.out.println("Enter amount people(amount<20)(so luong nguoi)");
            amountPeople = input.nextInt();
            if (!checkAmountMaxPeople(amountPeople))
                System.out.println(WRONG);
            else
                room.setSoLuongNguoi(amountPeople);
        } while (!checkAmountMaxPeople(amountPeople));
        //add dien tich su dung
        do {
            System.out.println("Enter area used(>30)");
            areaUsed = input.nextDouble();
            if (areaUsed >= 30)
                room.setDienTichSuDung(areaUsed);
            else
                System.out.println(WRONG);
        } while (areaUsed < 30);
//        thêm room vào file
        writeFileRoom(room);
    }

    public static void bookingRoom(List<Booking> listBooking, List<Customer> listCus, Booking booking, int choice) {
        List<Room> listRoom = Input_Output.readRoom(ROOM_PATH);
        for (int i = 0; i < listRoom.size(); i++) {
            System.out.println("STT: " + (i + 1) + " " + listRoom.get(i).toString());
        }
        System.out.println("Chọn Room :");
        int chooseRoom = input.nextInt();
        Room room = listRoom.get(chooseRoom - 1);
        booking.setIdService(room.getId());
        listBooking.add(booking);
        String lineBook;
        for (Booking itemBook : listBooking) {
            lineBook = booking.getIdCustomer() + COMMON + booking.getIdService();
            Input_Output.writeFile(BOOKING_PATH, lineBook);
        }
        System.out.println("Đã book Room: " + listRoom.get(chooseRoom - 1).getId() +
                " thành công cho khách hàng: " + listCus.get(choice - 1).getNameOfCustomer());
    }
    public static void showRoom(){
        List<String> listRoom =Input_Output.readFile(ROOM_PATH);
        for (String room : listRoom)
            System.out.println(room);
    }
    public static void showAllRoomNotDuplicated() {
        Set<String> roomNotDuplicated = new TreeSet<>();
        List<Room> listhouse = Input_Output.readRoom(ROOM_PATH);
        for (int i = 0; i < listhouse.size(); i++) {
            roomNotDuplicated.add(listhouse.get(i).getTenDichVu());
        }
        System.out.println("Danh sách tên các Room không trùng nhau:");
        for (String nameRoom:roomNotDuplicated ){
            System.out.println(nameRoom);
        }
    }
}
