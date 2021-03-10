package furama_resorts.common;

import furama_resorts.models.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static furama_resorts.manager.EmployeeManager.COMMON;

public abstract class Input_Output {
    public  final static String VILLA_PATH="E:\\GitHub\\A1020I1-HoDucThang\\module2\\src\\furama_resorts\\data\\Villa.csv";
    public  final static String HOUSE_PATH="E:\\GitHub\\A1020I1-HoDucThang\\module2\\src\\furama_resorts\\data\\House.csv";
    public  final static String ROOM_PATH="E:\\GitHub\\A1020I1-HoDucThang\\module2\\src\\furama_resorts\\data\\Room.csv";
    public  final static String CUSTOMER_PATH="E:\\GitHub\\A1020I1-HoDucThang\\module2\\src\\furama_resorts\\data\\Customer.csv";
    public  final static String BOOKING_PATH="E:\\GitHub\\A1020I1-HoDucThang\\module2\\src\\furama_resorts\\data\\Booking.csv";
    public  final static String EMPLOYEE_PATH="E:\\GitHub\\A1020I1-HoDucThang\\module2\\src\\furama_resorts\\data\\Employee.csv";

    public static void writeFile(String path, String line) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeFileVilla(Villa villa){
        List<Villa> listVilla = new ArrayList<>();
        listVilla.add(villa);
        String lineVilla;
        for (Villa itemVilla : listVilla) {
            lineVilla = villa.getId() + COMMON + villa.getTenDichVu() + COMMON + villa.getKieuThue() + COMMON +
                    villa.getMoTaTienNghi() + COMMON + villa.getTieuChuanPhong() + COMMON + villa.getSoTang() + COMMON +
                    villa.getChiPhiThue() + COMMON + villa.getSoLuongNguoi() + COMMON + villa.getDienTichSuDung() + COMMON
                    + villa.getDienTichHoBoi();
            Input_Output.writeFile(VILLA_PATH, lineVilla);
        }
    }
    public static void writeFileEmp(Employee employee){
        List<Employee> listEmp = new ArrayList<>();
        listEmp.add(employee);
        String lineEmp;
        for (Employee itemEmp : listEmp) {
            lineEmp = employee.getIdEmp() + COMMON + employee.getNameEmp() + COMMON + employee.getDofEmp() + COMMON +
                    employee.getAddressEmp() + COMMON + employee.getIdCardEmp() + COMMON + employee.getNumberPhoneEmp() + COMMON +
                    employee.getEmailEmp() + COMMON + employee.getLevelEmp() + COMMON + employee.getPositonEmp() + COMMON
                    + employee.getSalaryEmp();
            Input_Output.writeFile(EMPLOYEE_PATH, lineEmp);
        }
    }
    public static void writeFileRoom(Room room){
        List<Room> listRoom = new ArrayList<>();
        listRoom.add(room);
        String lineRoom;
        for (Room itemRoom : listRoom) {
            lineRoom = room.getId() + COMMON + room.getTenDichVu() +  COMMON + room.getKieuThue()+
                    COMMON + room.getTenDVDiKem()+ COMMON+ room.getDonVi()+ COMMON+ room.getGiaTien()
                    + COMMON + room.getChiPhiThue() + COMMON + room.getSoLuongNguoi()+COMMON+room.getDienTichSuDung();
            Input_Output.writeFile(ROOM_PATH, lineRoom);
        }
    }
     public static void writeFileHouse(House house){
         List<House> listHouse = new ArrayList<>();
         listHouse.add(house);
         String lineHouse;
         for (House itemHouse : listHouse) {
             lineHouse = house.getId() + COMMON + house.getTenDichVu() + COMMON + house.getMoTaTienNghi() + COMMON +
                     house.getTieuChuanPhong() + COMMON + house.getKieuThue() + COMMON + house.getSoTang() + COMMON
                     + house.getChiPhiThue() + COMMON + house.getSoLuongNguoi() + COMMON + house.getDienTichSuDung();
             Input_Output.writeFile(HOUSE_PATH, lineHouse);
         }
    }public static void writeFileCus(Customer customer){
        List<Customer> listCustomer = new ArrayList<>();
        listCustomer.add(customer);
        String lineCustomer;
        for (Customer itemCus : listCustomer) {
            lineCustomer = customer.getNameOfCustomer() + COMMON + customer.getDof() + COMMON
                    + customer.getGender() + COMMON + customer.getEmail() + COMMON + customer.getAddress() + COMMON +
                    customer.getTypeCustomer() + COMMON + customer.getIdCard() + COMMON + customer.getNumberPhone();
            Input_Output.writeFile(CUSTOMER_PATH, lineCustomer);
        }
    }
    public static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public static List<Villa> readVilla(String path) {
        List<String> list = readFile(path);
        List<Villa> listVilla = new ArrayList<>();
        String[] arrayVilla = null;
        for (String i : list) {
            arrayVilla = i.split(",");
            Villa villa = new Villa(arrayVilla[0], arrayVilla[1], arrayVilla[2], arrayVilla[3],
                    arrayVilla[4], Integer.parseInt(arrayVilla[5]), Integer.parseInt(arrayVilla[6]),
                    Integer.parseInt(arrayVilla[7]), Double.parseDouble(arrayVilla[8]),Double.parseDouble(arrayVilla[9]));
            listVilla.add(villa);
        }
        return listVilla;
    }
    public static List<House> readHouse(String path) {
        List<String> list = readFile(path);
        List<House> listHouse = new ArrayList<>();
        String[] arrayHouse = null;
        for (String i : list) {
            arrayHouse = i.split(",");
            House house = new House(arrayHouse[0], arrayHouse[1], arrayHouse[2], arrayHouse[3],
                    arrayHouse[4], Integer.parseInt(arrayHouse[5]), Integer.parseInt(arrayHouse[6]),
                    Integer.parseInt(arrayHouse[7]), Double.parseDouble(arrayHouse[8]));
            listHouse.add(house);
        }
        return listHouse;
    }
    public static List<Room> readRoom(String path) {
        List<String> list = readFile(path);
        List<Room> listRoom = new ArrayList<>();
        String[] arrayRoom = null;
        for (String i : list) {
            arrayRoom = i.split(",");
            Room room = new Room(arrayRoom[0], arrayRoom[1], arrayRoom[2], arrayRoom[3],
                    arrayRoom[4], Integer.parseInt(arrayRoom[5]), Integer.parseInt(arrayRoom[6]),
                    Integer.parseInt(arrayRoom[7]), Double.parseDouble(arrayRoom[8]));
            listRoom.add(room);
        }
        return listRoom;
    }
    public static List<Customer> readCustomer(String path) {
        List<String> list = readFile(path);
        List<Customer> listCustomer = new ArrayList<>();
        String[] arrayCus = null;
        for (String i : list) {
            arrayCus = i.split(",");
            Customer customer = new Customer(arrayCus[0], arrayCus[1], arrayCus[2], arrayCus[3], arrayCus[4], arrayCus[5],
                   arrayCus[6], arrayCus[7]);
            listCustomer.add(customer);
        }
        return listCustomer;
    }
    public static List<Employee> readEmployee(String path) {
        List<String> list = readFile(path);
        List<Employee> listEmployee = new ArrayList<>();
        String[] arrayEmp = null;
        for (String i : list) {
            arrayEmp = i.split(",");
            Employee employee = new Employee(arrayEmp[0], arrayEmp[1], arrayEmp[2], arrayEmp[3], arrayEmp[4], arrayEmp[5],
                    arrayEmp[6], arrayEmp[7],arrayEmp[8],arrayEmp[9]);
            listEmployee.add(employee);
        }
        return listEmployee;
    }
}
