package furama_resorts.manager;

import furama_resorts.common.exception.user_exception.NameException;
import furama_resorts.models.Customer;
import furama_resorts.common.Input_Output;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static furama_resorts.common.Validate.ValidateCustomer.*;
import static furama_resorts.common.Validate.ValidateForAll.*;
import static furama_resorts.common.Input_Output.*;

public class CustomerManager {
    public static final String WRONG = "Enter incorrectly , please enter again";
    public static final String COMMON = ",";
    static boolean check=true;
    static Scanner input = new Scanner(System.in);

    public static void addNewCustomer(Customer customer) {
        String fullName;
        String dateOfBirth;
        String gender;
        String email;
        String address;
        String typeCustomer;
        String numberTelephone;
        String idCard;
        do {
            try {
                System.out.println("Enter your full name pls");
                fullName = input.nextLine();
                if (!nameExveption(fullName))
                    System.out.println(WRONG);
                else
                    customer.setNameOfCustomer(fullName);
                customer.getNameOfCustomer();
            } catch (NameException e) {
                System.out.println(e);
                check = false;
            }
        } while (!check);

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
            idCard = input.nextLine();
            if (!idCardException(idCard))
                System.out.println(WRONG);
            else
                customer.setIdCard(idCard);
        } while (!idCardException(idCard));
        do {
            System.out.println("Enter your number phone");
            numberTelephone = input.nextLine();
            if (!numberTelException(numberTelephone))
                System.out.println(WRONG);
            else
                customer.setNumberPhone(numberTelephone);
        } while (!numberTelException(numberTelephone));
        writeFileCus(customer);
    }

    public static void showInformationCustomers() {
        List<Customer> listCus = Input_Output.readCustomer(CUSTOMER_PATH);
        Collections.sort(listCus);
        for (int i = 0; i < listCus.size(); i++) {
            System.out.println("STT: " + (i + 1) + " " + listCus.get(i).toString());
        }
    }

    public static void buyTicketCinema() {

    }
}

