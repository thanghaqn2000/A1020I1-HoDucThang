package furama_resorts.controllers;
import furama_resorts.models.Villa;

import java.util.*;

import static furama_resorts.manager.BookingManager.addNewBooking;
import static furama_resorts.manager.CustomerManager.*;
import static furama_resorts.manager.EmployeeManager.*;
import static furama_resorts.manager.ServiceManager.addNewServies;
import static furama_resorts.manager.ServiceManager.showServices;

public class MainControllers {
    static Scanner input = new Scanner(System.in);
    static boolean check = true;
    static int choose = 0;
    public static void displayMainMenu() {
        do {
            try{
            System.out.println("--MENU FURAMA RESORT--\n"+"1. Add New Services " + "\n" +
                    "2. Show Services" + "\n" +
                    "3. Customer's menu" + "\n" +
                    "4. Add New Booking" + "\n" +
                    "5. Employee's menu" + "\n" +
                    "6. Exit");
                choose = Integer.parseInt(input.nextLine());
                switch (choose) {
                    case 1:
                        addNewServies();
                        break;
                    case 2:
                        showServices();
                        break;
                    case 3:
                        functionCustomer();
                        break;
                    case 4:
                        addNewBooking();
                        break;
                    case 5:
                        functionEmployee();
                        break;
                    case 6:
                        System.out.println("Bye bye :)");
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Our menu don't have your choice, enter again");
                        break;
                }
            }catch (Exception e){
                System.err.println("Wrong data type with regulations of system!");
            }
        } while (check);
    }
    public static void main(String[] args) {
        displayMainMenu();
    }
}
