package furama_resorts.manager;

import furama_resorts.common.exception.user_exception.*;
import furama_resorts.models.Customer;
import furama_resorts.common.Input_Output;

import java.util.*;

import static furama_resorts.common.Validate.ValidateCustomer.*;
import static furama_resorts.common.Validate.ValidateForAll.*;
import static furama_resorts.common.Input_Output.*;

public class CustomerManager {
    public static final String WRONG = "Enter incorrectly , please enter again";

    static int ticket = 3;
    static Queue<Customer> customerQueue = new LinkedList<>();
    static Scanner input = new Scanner(System.in);

    public static void functionCustomer() {
        boolean check=false;
        do {
            try {
                System.out.println("--MENU CUSTOMER--\n" +
                        "1. Add customer\n" +
                        "2. Show customer\n" +
                        "3. Go to the cinema\n" +
                        "4. Delete customer\n" +
                        "5. Change info customer\n" +
                        "6. Back to main menu");
                int choose = Integer.parseInt(input.nextLine());
                switch (choose) {
                    case 1:
                        Customer customer = new Customer();
                        addNewCustomer(customer);
                        break;
                    case 2:
                        showInformationCustomers();
                        break;
                    case 3:
                        ticketCinema();
                        break;
                    case 4:
                        deleteCus();
                        break;
                    case 5:
                        updateCus();
                        break;
                    case 6:
                        System.out.println("Hope to see u again!");
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

    public static void addNewCustomer(Customer customer) {
        boolean check;
        List<Customer> listCustomer = new ArrayList<>();
        String fullName;
        String dateOfBirth;
        String gender;
        String email;
        String address;
        String typeCustomer;
        String numberTelephone;
        String idCard;
        do {
            check = true;
            try {
                System.out.println("Enter your full name pls");
                fullName = input.nextLine();
                nameException(fullName);
                customer.setNameOfCustomer(fullName);
            } catch (NameException e) {
                check = false;
            }

        } while (!check);
        do {
            check = true;
            try {
                System.out.println("Enter your date of birth pls");
                dateOfBirth = input.nextLine();
                birthdayException(dateOfBirth);
                customer.setDof(dateOfBirth);
            } catch (BirthdayException e) {
                System.out.println(e);
                check = false;
            }
        } while (!check);
        do {
            check = true;
            try {
                System.out.println("Enter your gender pls");
                gender = input.nextLine();
                gender = gender.toLowerCase();
                genderExeption(gender);
                customer.setGender(uppercaseFirst(gender));
            } catch (GenderException e) {
                System.out.println(e);
                check = false;
            }

        } while (!check);
        do {
            check = true;
            try {
                System.out.println("Enter your email pls");
                email = input.nextLine();
                emailException(email);
                customer.setEmail(email);
            } catch (EmailException e) {
                System.out.println(e);
                check = false;
            }
        } while (!check);
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
            check = true;
            try {
                System.out.println("Enter your id card");
                idCard = input.nextLine();
                idCardException(idCard);
                customer.setIdCard(idCard);
            } catch (IdCardException e) {
                System.out.println(e);
                check = false;
            }
        } while (!check);
        do {
            System.out.println("Enter your number phone");
            numberTelephone = input.nextLine();
            if (!numberTelException(numberTelephone))
                System.out.println(WRONG);
            else
                customer.setNumberPhone(numberTelephone);
        } while (!numberTelException(numberTelephone));
        listCustomer.add(customer);
        System.err.printf("Add success customer: %s \n", customer.getNameOfCustomer());
        writeFileCus(listCustomer, true);
    }

    public static void showInformationCustomers() {
        List<Customer> listCus = Input_Output.readCustomer(CUSTOMER_PATH);
        Collections.sort(listCus);
        for (int i = 0; i < listCus.size(); i++) {
            System.out.println("STT: " + (i + 1) + " " + listCus.get(i).toString());
        }
    }

    public static void ticketCinema() {
        boolean check=false;
        do{
            try {
                System.out.println("--MENU CINEMA DUC THANG-- \n" +
                        "1. Buy a ticket \n" +
                        "2. Show list customer bought ticket\n" +
                        "3. Stop buying ");
                System.out.println("Choose a function in menu");
                int choose = Integer.parseInt(input.nextLine());
                switch (choose) {
                    case 1:
                        System.err.printf("Ticket's quantity left %d \n", ticket);
                        if (ticket == 0) {
                            System.err.println("Sold out TT");
                            break;
                        }
                        List<Customer> listCus = Input_Output.readCustomer(CUSTOMER_PATH);
                        for (int i = 0; i < listCus.size(); i++) {
                            System.out.printf("STT %d |Customer %s \n", (i + 1), listCus.get(i).getNameOfCustomer());
                        }
                        System.out.println("Who do you buy for ?");
                        int chooseCus = Integer.parseInt(input.nextLine());
                        if (chooseCus > listCus.size() || chooseCus < 1) {
                            System.err.println("Can't found customer need to buy!");
                            break;
                        }
                        System.out.println("Bought a ticket success for " + listCus.get(chooseCus - 1).getNameOfCustomer());
                        customerQueue.add(listCus.get(chooseCus - 1));
                        ticket -= 1;
                        break;
                    case 2:
                        int stt = 0;
                        if (customerQueue.isEmpty()) {
                            System.err.println("No one has bought tickets yet TT");
                            break;
                        }
                        System.out.println("List of customer bought ticket:");
                        for (Customer cus : customerQueue) {
                            stt++;
                            System.out.println("STT " + stt + " " + cus.getNameOfCustomer() + "|" + cus.getIdCard());
                        }
                        break;
                    case 3:
                        System.out.println("Thanks for coming!!");
                        check = true;
                        break;
                    default:
                        System.err.println("Your choice don't have in our menu TT");
                        break;
                }
            }catch (Exception e){
                System.err.println("Wrong data type with regulations of system!");
            }
        }while (!check);

    }

    public static void deleteCus() {
        boolean check=false;
        List<Customer> listCus = Input_Output.readCustomer(CUSTOMER_PATH);
        do {
            for (int i = 0; i < listCus.size(); i++) {
                System.out.printf("STT %d |Customer %s \n", (i + 1), listCus.get(i).toString());
            }
            System.out.println("Choose customer need to delete");
            int choose = Integer.parseInt(input.nextLine());
            if (choose > listCus.size() || choose < 1) {
                System.err.println("Can't found customer need to delete!");
                break;
            }
            System.err.printf("Really wanna delete %s y/n: \n", listCus.get(choose - 1).getNameOfCustomer());
            String yn = input.nextLine();
            if (yn.equalsIgnoreCase("y")) {
                System.out.printf("Delete success %s: \n", listCus.get(choose - 1).getNameOfCustomer());
                listCus.remove(choose - 1);
                System.out.println("List customer have left:");
                for (int i = 0; i < listCus.size(); i++) {
                    System.out.println("STT: " + (i + 1) + " " + listCus.get(i).getNameOfCustomer());
                }
                writeFileCus(listCus, false);
            } else
                break;
        } while (check);
    }
    public static void updateCus() {
        boolean check=false;
        List<Customer> listCus = Input_Output.readCustomer(CUSTOMER_PATH);
        do {
            for (int i = 0; i < listCus.size(); i++) {
                System.out.printf("STT %d | %s \n", (i + 1), listCus.get(i).toString());
            }
            System.out.println("Choose customer need to fix");
            int choose = Integer.parseInt(input.nextLine());
            if (choose > listCus.size() || choose < 1) {
                System.err.println("Can't found customer need to fix!");
                break;
            }
            System.out.println("Choose properties want to fix\n" +
                    "1. Fix id: " + listCus.get(choose - 1).getIdCard() + "\n" +
                    "2. Fix name: " + listCus.get(choose - 1).getNameOfCustomer() + "\n" +
                    "3. Fix gender: " + listCus.get(choose - 1).getGender() + "\n" +
                    "4. Fix typeCustomer: " + listCus.get(choose - 1).getTypeCustomer() + "\n" +
                    "5. Fix email: " + listCus.get(choose - 1).getEmail() + "\n" +
                    "6. Fix address: " + listCus.get(choose - 1).getAddress());
            int chooseFix = Integer.parseInt(input.nextLine());
            switch (chooseFix) {
                case 1:
                    System.out.println("Enter id need to fix");
                    listCus.get(choose - 1).setIdCard(input.nextLine());
                    System.err.println("Fix id success");
                    break;
                case 2:
                    System.out.println("Enter name need to fix");
                    listCus.get(choose - 1).setNameOfCustomer(input.nextLine());
                    System.err.println("Fix name success");
                    break;
                case 3:
                    System.out.println("Enter gender need to fix");
                    listCus.get(choose - 1).setGender(input.nextLine());
                    System.err.println("Fix gender success");
                    break;
                case 4:
                    System.out.println("Enter typeCustomer need to fix");
                    listCus.get(choose - 1).setTypeCustomer(input.nextLine());
                    System.err.println("Fix typeCustomer success");
                    break;
                case 5:
                    System.out.println("Enter email need to fix");
                    listCus.get(choose - 1).setEmail(input.nextLine());
                    System.err.println("Fix email success");
                    break;
                case 6:
                    System.out.println("Enter address need to fix");
                    listCus.get(choose - 1).setAddress(input.nextLine());
                    System.err.println("Fix address success");
                    break;
                default:
                    System.err.println("Our menu don't have your choice, enter again");
            }
            writeFileCus(listCus, false);
        } while (check);
    }
}

