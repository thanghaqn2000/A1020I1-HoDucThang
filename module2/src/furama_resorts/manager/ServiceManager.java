package furama_resorts.manager;

import furama_resorts.models.House;
import furama_resorts.models.Room;
import furama_resorts.models.Villa;

import java.util.Scanner;

import static furama_resorts.manager.HouseManager.*;
import static furama_resorts.manager.RoomManager.*;
import static furama_resorts.manager.VillaManager.*;
import static furama_resorts.controllers.MainControllers.displayMainMenu;

public class ServiceManager {
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
                    showVilla();
                    break;
                case 2:
                    showHouse();
                    break;
                case 3:
                    showRoom();
                    break;
                case 4:
                   showAllVillaNotDuplicated();
                    break;
                case 5:
                    showAllHouseNotDuplicated();
                    break;
                case 6:
                    showAllRoomNotDuplicated();
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

}
