package furama_resorts.models;


import furama_resorts.common.Input_Output;

import java.util.*;

import static furama_resorts.manager.BookingManager.addNewBooking;
import static furama_resorts.manager.CustomerManager.*;
import static furama_resorts.manager.EmployeeManager.*;
import static furama_resorts.manager.ServiceManager.addNewServies;
import static furama_resorts.manager.ServiceManager.showServices;

public class MainControllers {
    public static final String COMMON = ",";
    static Scanner input = new Scanner(System.in);
    static boolean check = true;
    static int choose = 0;
    public static void displayMainMenu() {
        do {
            System.out.println("1. Add New Services " + "\n" +
                    "2. Show Services" + "\n" +
                    "3. Add New Customer" + "\n" +
                    "4. Show Information of Customer" + "\n" +
                    "5. Add New Booking" + "\n" +
                    "6. Function of Employee" + "\n" +
                    "7. Exit" + "\n");
            choose = Integer.parseInt(input.nextLine());
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
                    break;
                case 4:
                   showInformationCustomers();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                   functionEmployee();
                    break;
                case 7:
                   System.exit(0);
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
