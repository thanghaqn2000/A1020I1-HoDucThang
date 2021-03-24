package furama_resorts.manager;

import furama_resorts.common.Input_Output;
import furama_resorts.models.Employee;
import furama_resorts.models.FilingCabinets;

import java.util.*;

import static furama_resorts.common.Input_Output.*;
import static furama_resorts.common.Validate.ValidateEmployee.*;
public class EmployeeManager {
    public static final String WRONG = "Enter incorrectly , please enter again";
    public static final String COMMON = ",";
    static Scanner input = new Scanner(System.in);
    public static void functionEmployee() {
        boolean check=false;
        do {
            try {
                System.out.println("1. Add new employee" + "\n" + "2. Show employee's info" + "\n" +
                        "3. Show filing cabinets" + "\n" + "4. Back to main menu");
                int choose = Integer.parseInt(input.nextLine());
                switch (choose) {
                    case 1:
                        Employee employee = new Employee();
                        addEmployee(employee);
                        break;
                    case 2:
                        showMapEmp();
                        break;
                    case 3:
                        System.out.println("Hope to see u again!");
                        searchFillingCaninetsEmp();
                        break;
                    case 4:
                        check = true;
                        break;
                    default:
                        System.err.println("Our menu don't have your choice, enter again");
                }
            }catch (Exception e){
                System.err.println("Wrong data type with regulations of system!");
            }
        } while (!check);
    }
    public static void addEmployee(Employee employee) {
        String idEmp;
        String nameEmp;
        String dofEmp;
        String addressEmp;
        String idCardEmp;
        String numberPhoneEmp;
        String emailEmp;
        String levelEmp;
        String positionEmp;
        String salaryEmp;
//        add id nhân viên
        System.out.println("Enter your id pls");
        idEmp = input.nextLine();
        employee.setIdEmp(idEmp);
//        add tên nhân viên
        do {
            System.out.println("Enter your full name pls");
            nameEmp = input.nextLine();
            if (!nameExveptionEmp(nameEmp))
                System.out.println(WRONG);
            else
                employee.setNameEmp(nameEmp);
        } while (!nameExveptionEmp(nameEmp));
//        add ngày sinh nhân viên
        do {
            System.out.println("Enter your date of birth pls");
            dofEmp = input.nextLine();
            if (!birthdayExceptionEmp(dofEmp))
                System.out.println(WRONG);
            else
                employee.setDofEmp(dofEmp);
        } while (!birthdayExceptionEmp(dofEmp));
//        add địa chỉ nhân viên
        System.out.println("Enter your address pls");
        addressEmp = input.nextLine();
        employee.setAddressEmp(addressEmp);
//        add cmnd nhân viên

        do {
            System.out.println("Enter your id card pls");
            idCardEmp = input.nextLine();
            if (!idCardExceptionEmp(idCardEmp))
                System.out.println(WRONG);
            else
                employee.setIdCardEmp(idCardEmp);
        } while (!idCardExceptionEmp(idCardEmp));
//        add số điện thoại nhân viên
        do {
            System.out.println("Enter your phone number pls");
            numberPhoneEmp = input.nextLine();
            if (!numberTelExceptionEmp(numberPhoneEmp))
                System.out.println(WRONG);
            else
                employee.setNumberPhoneEmp(numberPhoneEmp);
        } while (!numberTelExceptionEmp(numberPhoneEmp));
//        add email nhân viên
        do {
            System.out.println("Enter your email pls");
            emailEmp = input.nextLine();
            if (!emailExceptionEmp(emailEmp))
                System.out.println(WRONG);
            else
                employee.setEmailEmp(emailEmp);
        } while (!emailExceptionEmp(emailEmp));
//        add trình độ nhân viên
        do {
            System.out.println("Enter your level pls");
            levelEmp = input.nextLine();
            if (!checkLevelEmp(levelEmp))
                System.out.println(WRONG);
            else
                employee.setLevelEmp(levelEmp);
        } while (!checkLevelEmp(levelEmp));
//        add vị trí nhân viên
        do {
            System.out.println("Enter your position pls");
            positionEmp = input.nextLine();
            if (!checkPositionEmp(positionEmp))
                System.out.println(WRONG);
            else
                employee.setPositonEmp(positionEmp);
        } while (!checkPositionEmp(positionEmp));
//        add lương nhân viên
        System.out.println("Enter your salary pls");
        salaryEmp = input.nextLine();
        employee.setSalaryEmp(salaryEmp);
        System.err.printf("Add employee %s success! \n", employee.getNameEmp());
        writeFileEmp(employee, true);
    }
    public static void showMapEmp() {
        int stt=0;
        List<Employee> listEmp = Input_Output.readEmployee(EMPLOYEE_PATH);
        Map<String, Employee> mapEmp = new TreeMap<>();
        for (int i = 0; i < listEmp.size(); i++) {
            mapEmp.put(listEmp.get(i).getIdEmp(), listEmp.get(i));
        }
        for (Map.Entry<String, Employee> entry : mapEmp.entrySet()) {
            stt++;
            System.out.println("STT:"+stt+"\n*Employee's id: " + entry.getKey() + "\n" + "-"+entry.getValue());
        }
    }

    public static void searchFillingCaninetsEmp() {
        List<Employee> listEmp = Input_Output.readEmployee(EMPLOYEE_PATH);
        FilingCabinets profile = new FilingCabinets();
        for (Employee emp : listEmp) {
            profile.add(emp);
        }
        System.out.println("Enter name employee to find");
        String name = input.nextLine();
        Queue<Employee> employee = profile.search(name);
        if (employee == null) {
            System.err.println("Can't found "+name+"'s profile");
        } else {
            for (Employee emp : employee) {
                System.out.println(emp);
            }
        }
    }
}
