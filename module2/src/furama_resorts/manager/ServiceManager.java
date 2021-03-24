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
    static int choose = 0;

    public static void showServices() {
        boolean check = false;
        do {
            try {

                System.out.println("1.Show all Villa " + "\n" +
                        "2.Show all House" + "\n" +
                        "3.Show all Room" + "\n" +
                        "4.Show All Name Villa Not Duplicate" + "\n" +
                        "5.Show All Name House Not Duplicate" + "\n" +
                        "6.Show All Name Room Not Duplicate" + "\n" +
                        "7.Back to main menu");
                choose = Integer.parseInt(input.nextLine());
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
                        check = true;
                        break;
                    default:
                        System.err.println("Our menu don't have your choice, enter again");
                        break;
                }
            }catch (Exception e){
                System.err.println("Wrong data type with regulations of system!");
            }
        } while (!check);
    }

    public static void addNewServies() {
        boolean check = false;
        do {
            System.out.println("--MENU SERVIES--\n" +
                    "1. Add New Villa " + "\n" +
                    "2. Add New House" + "\n" +
                    "3. Add New Room" + "\n" +
                    "4. Back to menu" + "\n");
            choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    Villa villa = new Villa();
                    addNewVilla(villa);
                    break;
                case 2:
                    House house = new House();
                    addNewHouse(house);
                    break;
                case 3:
                    Room room = new Room();
                    addNewRoom(room);
                    break;
                case 4:
                    System.out.println("Hope to see u again!");
                    check=true;
                    break;
                default:
                    System.err.println("Our menu don't have your choice, enter again");
                    break;
            }
        } while (!check);

    }
}

