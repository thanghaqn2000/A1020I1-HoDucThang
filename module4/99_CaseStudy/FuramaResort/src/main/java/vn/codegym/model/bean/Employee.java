package vn.codegym.model.bean;

import vn.codegym.validation.DateOfBirth;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.Set;
@Entity
public class Employee {
    @Id
    private int employeeId;
    @NotBlank(message = "Name must be not empty")
    private String employeeName;
    @DateOfBirth(message = "Employee's age must be more than 18")
    private String employeeBirthday;
    @Pattern(regexp = "(\\d{9}|\\d{11}$)",message = "The length must be 9 or 11 number")
    private String employeeIdCard;
    @Positive
    private double employeeSalary;
    @Pattern(regexp = "^0(\\d{9}$)",message = "Phone number must be 10 number and start with 0 ")
    private String employeePhone;
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Email must be like: codegym@gmail.com")
    private String employeeEmail;
    @NotBlank(message = "Address must be not empty")
    private String employeeAddress;
    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "positionId",referencedColumnName = "positionId")
    private Position position;
    @ManyToOne(targetEntity = EducationDegree.class)
    @JoinColumn(name = "educationDegreeId",referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;
    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "divisionId",referencedColumnName = "divisionId")
    private Division division;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userName",referencedColumnName = "userName")
    private User user;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;
    public Employee() {
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
