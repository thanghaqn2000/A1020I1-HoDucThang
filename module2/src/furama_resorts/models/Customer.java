package furama_resorts.models;

import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
    private String nameOfCustomer;
    private String dof;
    private String gender;
    private String email;
    private String typeCustomer;
    private String address;
    private Services services;
    private String numberPhone;
    private String idCard;

    public Customer() {
    }

    public Customer(String nameOfCustomer, String dof, String gender, String email, String typeCustomer, String address,
                    String idCard, String numberPhone) {
        this.nameOfCustomer = nameOfCustomer;
        this.dof = dof;
        this.gender = gender;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.idCard = idCard;
        this.numberPhone = numberPhone;
    }


    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    public String getDof() {
        return dof;
    }

    public void setDof(String dof) {
        this.dof = dof;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nameOfCustomer='" + nameOfCustomer + '\'' +
                ", dof='" + dof + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", typeCustomer='" + typeCustomer + '\n' +
                ", address='" + address + '\'' +
                ", idCard=" + idCard +'\'' +
                ", numberPhone=" + numberPhone +
                '}';
    }
    public LocalDate getBirthdayToDate(){
        String[] birthdayArr = this.dof.split("/");
        LocalDate date = LocalDate.of(Integer.parseInt(birthdayArr[2]), Integer.parseInt(birthdayArr[1]), Integer.parseInt(birthdayArr[0]));
        return date;
    }
    public void showInfor() {
        System.out.println("Customer{" +
                "nameOfCustomer='" + nameOfCustomer + '\'' +
                ", dof='" + dof + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", typeCustomer='" + typeCustomer + '\n' +
                ", address='" + address + '\'' +
                ", idCard=" + idCard +'\''+
                ", numberPhone=" + numberPhone +
                '}');
    }
    @Override
    public int compareTo(Customer o) {
        if (this.nameOfCustomer .equals(o.nameOfCustomer))
            return this.dof.compareTo(o.dof);
        return this.getNameOfCustomer().compareTo(o.getNameOfCustomer());
    }
}

