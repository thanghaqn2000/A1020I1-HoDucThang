package furama_resorts.manager;

import furama_resorts.common.Input_Output;
import furama_resorts.models.Booking;
import furama_resorts.models.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static furama_resorts.common.Input_Output.*;
import static furama_resorts.manager.HouseManager.*;
import static furama_resorts.manager.RoomManager.*;
import static furama_resorts.manager.VillaManager.*;
import static furama_resorts.controllers.MainControllers.displayMainMenu;

public class BookingManager {
    static Scanner input = new Scanner(System.in);
    static boolean check = true;
    static int choose = 0;
    public static void addNewBooking() {
        List<Customer> listCus = Input_Output.readCustomer(CUSTOMER_PATH);
        List<Booking> listBooking = new ArrayList<>();
        Collections.sort(listCus);
        Booking booking = new Booking();
        System.out.println("List's customer");
        for (int i = 0; i < listCus.size(); i++) {
            System.out.println("STT: " + (i + 1) + " " + listCus.get(i).getNameOfCustomer() + " " + listCus.get(i).getDof()
                    + " " + listCus.get(i).getIdCard());
        }
        System.out.println("Choose customer :");
        int chooseKH = Integer.parseInt(input.nextLine());
        Customer customer = listCus.get(chooseKH - 1);
        booking.setIdCustomer(customer.getIdCard());
        do {
            System.out.println("1. Booking Villa " + "\n" +
                    "2. Booking House" + "\n" +
                    "3. Booking Room" + "\n" +
                    "4. Exit" + "\n");
            choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    bookingVilla(listBooking, listCus, booking, chooseKH);
                    break;
                case 2:
                    bookingHouse(listBooking, listCus, booking, chooseKH);
                    break;
                case 3:
                   bookingRoom(listBooking,listCus,booking,chooseKH);
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.err.println("Our menu don't have your choice, enter again");
            }
        } while (check);
    }

}
