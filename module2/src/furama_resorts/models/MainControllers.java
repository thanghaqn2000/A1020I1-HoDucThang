package furama_resorts.models;

import test.Input_Output;
import test.QuadraticEquation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MainControllers {
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
                    System.out.println(listVilla);
                    break;
                case 2:
                    List<String> listHouse = Input_Output.readFile("E:/House.csv");
                    System.out.println(listHouse);
                    break;
                case 3:
                    List<String> listRoom = Input_Output.readFile("E:/Room.csv");
                    System.out.println(listRoom);
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
                    "2.Show Services" + "\n" +
                    "3.Add New Customer" + "\n" +
                    "4.Show Information of Customer" + "\n" +
                    "5.Add New Booking" + "\n" +
                    "6.Show Information of Employee" + "\n" +
                    "7.Exit" + "\n");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    addNewServies();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    check = false;
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
                    check = false;
                    break;
                default:
                    System.out.println("Không có trong menu , hãy nhập lại");
                    break;
            }
        } while (check);
    }

    public static void checkCondition(String id, String tenDV, String typeThue, int chiPhiThue, int soLuong) {

    }

    public static void inputTypeService(Services services) {
        input.nextLine();
        System.out.println("Nhập id");
        services.setId(input.nextLine());
        System.out.println("Tên dịch vụ");
        services.setTenDichVu(input.nextLine());
        System.out.println("Kiểu thuê");
        services.setKieuThue(input.nextLine());
        System.out.println("Chi phí thuê");
        services.setChiPhiThue(input.nextInt());
        System.out.println("Số lượng người");
        services.setAmountMaxPeople(input.nextInt());
        if (services instanceof Villa) {
            input.nextLine();
            System.out.println("Tiêu chuẩn phòng");
            ((Villa) services).setTieuChuanPhong(input.nextLine());
            System.out.println("Mô tả tiện nghi");
            ((Villa) services).setMoTaTienNghi(input.nextLine());
            System.out.println("Diện tích hồ bơi");
            ((Villa) services).setDienTichHoBoi(input.nextDouble());
            System.out.println("Số tầng");
            ((Villa) services).setSoTang(input.nextInt());
            List<Villa> villa = new ArrayList<>();
            villa.add((Villa) services);
            String lineVilla = null;
            for (Villa listVilla : villa) {
                lineVilla = services.getId() + COMMON + services.getTenDichVu() + COMMON + services.getKieuThue()
                        + COMMON + services.getChiPhiThue() + COMMON
                        + services.getAmountMaxPeople() + COMMON + ((Villa) services).getTieuChuanPhong() +
                        COMMON + ((Villa) services).getMoTaTienNghi()
                        + COMMON + ((Villa) services).getDienTichHoBoi() + COMMON + ((Villa) services).getSoTang();
                Input_Output.writeFile("E:/Villa.csv", lineVilla);
            }
        } else if (services instanceof House) {
            input.nextLine();
            System.out.println("Tiêu chuẩn phòng");
            ((House) services).setTieuChuanPhong(input.nextLine());
            System.out.println("Mô tả tiện nghi");
            ((House) services).setMoTaTienNghi(input.nextLine());
            System.out.println("Số tầng");
            ((House) services).setSoTang(input.nextInt());
            List<House> house = new ArrayList<>();
            house.add((House) services);
            String lineHouse = null;
            for (House listHouse : house) {
                lineHouse = services.getId() + COMMON + services.getTenDichVu() + COMMON + services.getKieuThue() +
                        COMMON + services.getChiPhiThue() + COMMON
                        + services.getAmountMaxPeople() + COMMON + ((House) services).getTieuChuanPhong()
                        + COMMON + ((House) services).getMoTaTienNghi() + COMMON +
                        ((House) services).getSoTang();
                Input_Output.writeFile("E:/House.csv", lineHouse);
            }
        } else if (services instanceof Room) {
            input.nextLine();
            System.out.println("Nhập tên đơn vị đi kèm");
            ((Room) services).setTenDVDiKem(input.nextLine());
            System.out.println("Nhập tên đơn vị");
            ((Room) services).setDonVi(input.nextLine());
            System.out.println("Nhập giá tiền");
            ((Room) services).setGiaTien(input.nextInt());
            List<Room> room = new ArrayList<>();
            room.add((Room) services);
            String lineRoom = null;
            for (Room listRoom : room) {
                lineRoom = services.getId() + COMMON + services.getTenDichVu() + COMMON + services.getKieuThue() +
                        COMMON + services.getChiPhiThue() + COMMON
                        + services.getAmountMaxPeople() + COMMON + ((Room) services).getTenDVDiKem()
                        + COMMON + ((Room) services).getDonVi() + COMMON + ((Room) services).getGiaTien();
                Input_Output.writeFile("E:/Room.csv", lineRoom);
            }
        }
    }
    public static void addNewServies() {
        do {
            System.out.println("1. Add New Villa " + "\n" +
                    "2. Add New House" + "\n" +
                    "3.Add New Room" + "\n" +
                    "4.Back to menu" + "\n" +
                    "5.Exit" + "\n");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Info Villa");
                    Villa villa1 = new Villa();
                    inputTypeService(villa1);
                    villa1.showInfor();
                    break;
                case 2:
                    System.out.println("Info House");
                    House house1 = new House();
                    inputTypeService(house1);
                    house1.showInfor();
                    break;
                case 3:
                    System.out.println("Info Room");
                    Room room1 = new Room();
                    inputTypeService(room1);
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
