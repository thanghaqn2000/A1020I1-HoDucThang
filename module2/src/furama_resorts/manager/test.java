package furama_resorts.manager;

import furama_resorts.common.exception.user_exception.BirthdayException;

import java.util.Scanner;

import static furama_resorts.common.Validate.ValidateCustomer.birthdayException;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dateOfBirth;
        boolean check;
        do {
            check = true;
            try {
                System.out.println("Enter your date of birth pls");
                dateOfBirth = input.nextLine();
                birthdayException(dateOfBirth);
                System.out.println("ok");
            } catch (BirthdayException e) {
                System.out.println(e);
                check = false;
            }
        } while (!check);
    }
}
