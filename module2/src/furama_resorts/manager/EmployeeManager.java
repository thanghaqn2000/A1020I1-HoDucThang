package furama_resorts.manager;

import furama_resorts.common.Input_Output;
import furama_resorts.models.Employee;
import furama_resorts.models.FilingCabinets;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static furama_resorts.common.Input_Output.*;
import static furama_resorts.common.Validate.ValidateEmployee.*;
import static furama_resorts.models.MainControllers.displayMainMenu;
public class EmployeeManager {
    public static final String WRONG = "Enter incorrectly , please enter again";
    public static final String COMMON = ",";
    static Scanner input = new Scanner(System.in);

    public static void functionEmployee() {
        boolean check = true;
        do {
            System.out.println("1. Thêm nhân viên" + "\n" + "2. Hiển thị thông tin nhân viên" + "\n" +
                    "3. Tủ hồ sơ" + "\n" + "4. Exit");
            String choose = input.nextLine();

            switch (choose) {
                case "1":
                    Employee employee = new Employee();
                    addEmployee(employee);
                    break;
                case "2":
                    showMapEmp();
                    break;
                case "3":
                    searchFillingCaninetsEmp();
                    break;
                case "4":
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Không tìm thấy chức năng");
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
        writeFileEmp(employee);
    }
    public static void showMapEmp(){
        List<Employee> listEmp = Input_Output.readEmployee(EMPLOYEE_PATH);
        Map<String,Employee> mapEmp=new TreeMap<>();
        for (int i = 0; i <listEmp.size() ; i++) {
            mapEmp.put(listEmp.get(i).getIdEmp(),listEmp.get(i));
        }
        for (Map.Entry<String, Employee> entry : mapEmp.entrySet()) {
            System.out.println("Employee's id: " + entry.getKey() + "\n" + entry.getValue());
        }
    }
    public static void searchFillingCaninetsEmp(){
        List<Employee> listEmp = Input_Output.readEmployee(EMPLOYEE_PATH);
        FilingCabinets profile=new FilingCabinets();
        for (Employee emp:listEmp ) {
            profile.add(emp);
        }
        System.out.println("Enter name employee");
        String name=input.nextLine();
        Employee employee=profile.search(name);
        if(profile.search(name)==null){
            System.out.println("Can't found profile of: "+name);
        }else{
            System.out.println(employee);
        }
    }
}
