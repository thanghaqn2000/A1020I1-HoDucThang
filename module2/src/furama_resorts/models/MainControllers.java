package furama_resorts.models;

import test.Input_Output;

import java.util.*;

import static furama_resorts.exception.ValidateCustomer.*;
import static furama_resorts.exception.ValidateForAll.*;
import static furama_resorts.exception.ValidateServices.*;

class MainControllers {
    public static final String WRONG = "Enter incorrectly , please enter again";
    public static final String COMMON = ",";
    static Scanner input = new Scanner(System.in);
    static boolean check = true;
    static int choose = 0;

    public static void showServices() {
        do {
            System.out.println("1.Show all Villa " + "\n" +
                    "2.Show all House" + "\n" +
                    "3.Show all Room" + "\n" +
                    "4.Show All Name Villa Not Duplicate" + "\n" +
                    "5.Show All Name House Not Duplicate" + "\n" +
                    "6.Show All Name Room Not Duplicate" + "\n" +
                    "7.Back to menu" + "\n" +
                    "8.Exit" + "\n");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    List<String> listVilla = Input_Output.readFile("E:/Villa.csv");
                    for (String villa : listVilla)
                        System.out.println(villa);
                    break;
                case 2:
                    List<String> listHouse = Input_Output.readFile("E:/House.csv");
                    for (String house : listHouse)
                        System.out.println(house);
                    break;
                case 3:
                    List<String> listRoom = Input_Output.readFile("E:/Room.csv");
                    for (String room : listRoom)
                        System.out.println(room);
                    break;
                case 4:
                    check = false;
                    break;
                case 5:
                    check = false;
                    break;
                case 6:
                    check = false;
                    break;
                case 7:
                    displayMainMenu();
                    break;
                case 8:
                    check = false;
                    break;
                default:
                    System.out.println("Không có trong menu , hãy nhập lại");
                    break;
            }
        } while (check);

    }

    public static void displayMainMenu() {
        do {
            System.out.println("1. Add New Services " + "\n" +
                    "2. Show Services" + "\n" +
                    "3. Add New Customer" + "\n" +
                    "4. Show Information of Customer" + "\n" +
                    "5. Add New Booking" + "\n" +
                    "6. Show Information of Employee" + "\n" +
                    "7. Exit" + "\n");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    addNewServies();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    Customer customer = new Customer();
                    addNewCustomer(customer);
                    customer.showInfor();
                    break;
                case 4:
                    showInformationCustomers();
                    break;
                case 5:
                    check = false;
                    break;
                case 6:
                    check = false;
                    break;
                case 7:
                    check = false;
                    break;
                default:
                    System.out.println("Không có trong menu , hãy nhập lại");
                    break;
            }
        } while (check);
    }

    public static void addNewBooking() {
        showInformationCustomers();
        do {
            System.out.println("1.Booking Villa " + "\n" +
                    "2. Booking House" + "\n" +
                    "3. Booking Room" + "\n" +
                    "4. Exit" + "\n");
            choose = input.nextInt();
            switch (choose) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Không có trong menu , hãy nhập lại");
            }
        } while (check);
    }

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
        input.nextLine();
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
        //add dien tich su dung
        do {
            System.out.println("Enter area used");
            areaUsed = input.nextDouble();
            if (areaUsed >= 30)
                villa.setDienTichSuDung(areaUsed);
            else
                System.out.println(WRONG);
        } while (areaUsed < 30);
        input.nextLine();
        //add kieu thue
        do {
            System.out.println("Enter rental type(kieu thue)");
            rentalType = input.nextLine();
            if (!checkNameServicesTypeRentStandard(rentalType))
                System.out.println(WRONG);
            else
                villa.setKieuThue(rentalType);
        } while (!checkNameServicesTypeRentStandard(rentalType));
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
        input.nextLine();
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
        //add dien tich ho boi
        do {
            System.out.println("Enter pool's area(dien tich ho boi)");
            areaPool = input.nextDouble();
            if (!checkSwimingBoolArea(areaPool))
                System.out.println(WRONG);
            else
                villa.setDienTichHoBoi(areaPool);
        } while (!checkSwimingBoolArea(areaPool));
        //add so tang
        do {
            System.out.println("Enter floor(so tang)");
            floor = input.nextInt();
            if (!checkFloor(floor))
                System.out.println(WRONG);
            else
                villa.setSoTang(floor);
        } while (!checkFloor(floor));
        //Them vao file Villa.csv
        List<Villa> listVilla = new ArrayList<>();
        listVilla.add(villa);
        String lineVilla;
        for (Villa itemVilla : listVilla) {
            lineVilla = villa.getId() + COMMON + villa.getTenDichVu() + COMMON + villa.getDienTichSuDung()
                    + COMMON + villa.getKieuThue()
                    + COMMON + villa.getChiPhiThue() + COMMON
                    + villa.getSoLuongNguoi() + COMMON + villa.getTieuChuanPhong() +
                    COMMON + villa.getMoTaTienNghi()
                    + COMMON + villa.getDienTichHoBoi() + COMMON + villa.getSoTang();
            Input_Output.writeFile("E:/Villa.csv", lineVilla);
        }
    }

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
        input.nextLine();
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
        //add dien tich su dung
        do {
            System.out.println("Enter area used");
            areaUsed = input.nextDouble();
            if (areaUsed >= 30)
                house.setDienTichSuDung(areaUsed);
            else
                System.out.println(WRONG);
        } while (areaUsed < 30);
        input.nextLine();
        //add kieu thue
        do {
            System.out.println("Enter rental type(kieu thue)");
            rentalType = input.nextLine();
            if (!checkNameServicesTypeRentStandard(rentalType))
                System.out.println(WRONG);
            else
                house.setKieuThue(rentalType);
        } while (!checkNameServicesTypeRentStandard(rentalType));
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
        input.nextLine();
        //add tieu chuan phong
        do {
            System.out.println("Enter room's standard(tieu chuan phong");
            standardRoom = input.nextLine();
            if (!checkNameServicesTypeRentStandard(standardRoom))
                System.out.println(WRONG);
            else
                house.setTieuChuanPhong(standardRoom);
        } while (!checkNameServicesTypeRentStandard(standardRoom));
        //add mo ta tien nghi
        do {
            System.out.println("Enter descirbe convenient(mo ta tien nghi)");
            describeRoom = input.nextLine();
            if (!onlyString(describeRoom))
                System.out.println(WRONG);
            else
                house.setMoTaTienNghi(describeRoom);
        } while (!onlyString(describeRoom));
        //add so tang
        do {
            System.out.println("Enter floor(so tang)");
            floor = input.nextInt();
            if (!checkFloor(floor))
                System.out.println(WRONG);
            else
                house.setSoTang(floor);
        } while (!checkFloor(floor));
        //Them vao file Villa.csv
        List<House> listHouse = new ArrayList<>();
        listHouse.add(house);
        String lineHouse;
        for (House itemHouse : listHouse) {
            lineHouse = house.getId() + COMMON + house.getTenDichVu() + COMMON + house.getDienTichSuDung()
                    + COMMON + house.getKieuThue()
                    + COMMON + house.getChiPhiThue() + COMMON
                    + house.getSoLuongNguoi() + COMMON + house.getTieuChuanPhong() +
                    COMMON + house.getMoTaTienNghi()
                    + COMMON + house.getSoTang();
            Input_Output.writeFile("E:/House.csv", lineHouse);
        }
    }

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
        input.nextLine();
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
        //add dien tich su dung
        do {
            System.out.println("Enter area used");
            areaUsed = input.nextDouble();
            if (areaUsed >= 30)
                room.setDienTichSuDung(areaUsed);
            else
                System.out.println(WRONG);
        } while (areaUsed < 30);
        input.nextLine();
        //add kieu thue
        do {
            System.out.println("Enter rental type(kieu thue)");
            rentalType = input.nextLine();
            if (!checkNameServicesTypeRentStandard(rentalType))
                System.out.println(WRONG);
            else
                room.setKieuThue(rentalType);
        } while (!checkNameServicesTypeRentStandard(rentalType));
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
        input.nextLine();
        do {
            System.out.println("Enter free services(Massage,karaoke,food,drink,car)");
            freeSevices = input.nextLine();
            if (!checkFreeServices(freeSevices))
                System.out.println(WRONG);
            else
                room.setTenDVDiKem(freeSevices);

        } while (!checkFreeServices(freeSevices));
        do {
            System.out.println("Enter unit's name(ten don vi)");
            nameUnit = input.nextLine();
            if (!onlyString(nameUnit))
                System.out.println(WRONG);
            else
                room.setDonVi(nameUnit);
        } while (!onlyString(nameUnit));
        do {
            System.out.println("Enter the price money");
            priceMoney = input.nextInt();
            if (priceMoney > 0)
                room.setGiaTien(priceMoney);
            else
                System.out.println(WRONG);
        } while (priceMoney <= 0);
        List<Room> listRoom = new ArrayList<>();
        listRoom.add(room);
        String lineRoom;
        for (Room itemRoom : listRoom) {
            lineRoom = room.getId() + COMMON + room.getTenDichVu() + COMMON + room.getDienTichSuDung()
                    + COMMON + room.getKieuThue() + COMMON
                    + room.getChiPhiThue() + COMMON + room.getDonVi() + COMMON
                    + room.getGiaTien() + COMMON + room.getSoLuongNguoi() + COMMON + room.getTenDVDiKem();
            Input_Output.writeFile("E:/Room.csv", lineRoom);
        }
    }

    public static void addNewCustomer(Customer customer) {
        Services useService;
        String fullName;
        String dateOfBirth;
        String gender;
        String email;
        String address;
        String typeCustomer;
        int idCard;
        int numberTelephone;
        input.nextLine();
        do {
            System.out.println("Enter your full name pls");
            fullName = input.nextLine();
            if (!nameExveption(fullName))
                System.out.println(WRONG);
            else
                customer.setNameOfCustomer(fullName);
        } while (!nameExveption(fullName));
        do {
            System.out.println("Enter your date of birth pls");
            dateOfBirth = input.nextLine();
            if (!birthdayException(dateOfBirth))
                System.out.println(WRONG);
            else
                customer.setDof(dateOfBirth);
        } while (!birthdayException(dateOfBirth));
        do {
            System.out.println("Enter your gender pls");
            gender = input.nextLine();
            if (!genderExeption(gender))
                System.out.println(WRONG);
            else
                gender = gender.toLowerCase();
            customer.setGender(uppercaseFirst(gender));
        } while (!genderExeption(gender));
        do {
            System.out.println("Enter your email pls");
            email = input.nextLine();
            if (!emailException(email))
                System.out.println(WRONG);
            else
                customer.setEmail(email);
        } while (!emailException(email));
        do {
            System.out.println("Enter your address pls");
            address = input.nextLine();
            if (!onlyString(address))
                System.out.println(WRONG);
            else
                customer.setAddress(address);
        } while (!onlyString(address));
        do {
            System.out.println("Enter your type customer pls");
            typeCustomer = input.nextLine();
            if (!onlyString(typeCustomer))
                System.out.println(WRONG);
            else
                customer.setTypeCustomer(typeCustomer);
        } while (!onlyString(typeCustomer));
        do {
            System.out.println("Enter your id card");
            idCard = input.nextInt();
            if (!idCardException(idCard))
                System.out.println(WRONG);
            else
                customer.setIdCard(idCard);
        } while (!idCardException(idCard));
        do {
            System.out.println("Enter your number phone");
            numberTelephone = input.nextInt();
            if (!numberTelException(numberTelephone))
                System.out.println(WRONG);
            else
                customer.setNumberPhone(numberTelephone);
        } while (!numberTelException(numberTelephone));
        List<Customer> listCustomer = new ArrayList<>();
        listCustomer.add(customer);
        String lineCustomer;
        for (Customer itemCus : listCustomer) {
            lineCustomer = customer.getNameOfCustomer() + COMMON + customer.getDof() + COMMON
                    + customer.getGender() + COMMON + customer.getEmail() + COMMON + customer.getAddress() + COMMON +
                    customer.getTypeCustomer() + COMMON + customer.getIdCard() + COMMON + customer.getNumberPhone();
            Input_Output.writeFile("E:/Customer.csv", lineCustomer);
        }
    }

    public static void showInformationCustomers() {
        List<String> listCus = Input_Output.readFile("E:/Customer.csv");
        Collections.sort(listCus);
        for (String customer : listCus) {
            System.out.println(customer);
        }
    }

    public static void addNewServies() {
        do {
            System.out.println("1. Add New Villa " + "\n" +
                    "2. Add New House" + "\n" +
                    "3. Add New Room" + "\n" +
                    "4. Back to menu" + "\n" +
                    "5. Exit" + "\n");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Info Villa");
                    Villa villa1 = new Villa();
                    addNewVilla(villa1);
                    villa1.showInfor();
                    break;
                case 2:
                    System.out.println("Info House");
                    House house1 = new House();
                    addNewHouse(house1);
                    house1.showInfor();
                    break;
                case 3:
                    System.out.println("Info Room");
                    Room room1 = new Room();
                    addNewRoom(room1);
                    room1.showInfor();
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    check = false;
                    break;
                default:
                    System.out.println("Không có trong menu , hãy nhập lại");
                    break;
            }
        } while (check);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
