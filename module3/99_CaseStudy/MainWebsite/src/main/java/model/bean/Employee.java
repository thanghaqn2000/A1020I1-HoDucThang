package model.bean;

public class Employee {
    private int id_Employee;
    private int id_Position;
    private int id_Level;
    private int id_Department;
    private double salary;
    private String name;
    private String namePosition;
    private String nameLevel;
    private String nameDepartment;
    private String dof;
    private String id_Card;
    private String phoneNumber;
    private String email;
    private String address;

    public Employee() {
    }

    public Employee(int id_Position, int id_Level, int id_Department, double salary, String name, String dof, String id_Card, String phoneNumber, String email, String address) {
        this.id_Position = id_Position;
        this.id_Level = id_Level;
        this.id_Department = id_Department;
        this.salary = salary;
        this.name = name;
        this.dof = dof;
        this.id_Card = id_Card;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Employee(int id_Employee, int id_Position, int id_Level, int id_Department, double salary, String name, String namePositon, String nameLevel, String nameDepartment, String dof, String id_Card, String phoneNumber, String email, String address) {
        this.id_Employee = id_Employee;
        this.id_Position = id_Position;
        this.id_Level = id_Level;
        this.id_Department = id_Department;
        this.salary = salary;
        this.name = name;
        this.namePosition = namePositon;
        this.nameLevel = nameLevel;
        this.nameDepartment = nameDepartment;
        this.dof = dof;
        this.id_Card = id_Card;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public int getId_Employee() {
        return id_Employee;
    }

    public void setId_Employee(int id_Employee) {
        this.id_Employee = id_Employee;
    }

    public int getId_Position() {
        return id_Position;
    }

    public void setId_Position(int id_Position) {
        this.id_Position = id_Position;
    }

    public int getId_Level() {
        return id_Level;
    }

    public void setId_Level(int id_Level) {
        this.id_Level = id_Level;
    }

    public int getId_Department() {
        return id_Department;
    }

    public void setId_Department(int id_Department) {
        this.id_Department = id_Department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePositon) {
        this.namePosition = namePositon;
    }

    public String getNameLevel() {
        return nameLevel;
    }

    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public String getDof() {
        return dof;
    }

    public void setDof(String dof) {
        this.dof = dof;
    }

    public String getId_Card() {
        return id_Card;
    }

    public void setId_Card(String id_Card) {
        this.id_Card = id_Card;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
