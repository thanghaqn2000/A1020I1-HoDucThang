package model.bean;

public class Customer {
    private int customer_Id;
    private int type_Customer_Id;
    private String type_Customer;
    private String customer_Name;
    private String customer_Birthday;
    private String customer_Id_Card;
    private String customer_Phone;
    private String customer_Email;
    private String customer_Address;


    public Customer() {
    }

    public Customer(int type_Customer_Id, String customer_Name, String customer_Birthday, String customer_Id_Card,
                    String customer_Phone, String customer_Email, String customer_Address) {
        this.type_Customer_Id = type_Customer_Id;
        this.customer_Name = customer_Name;
        this.customer_Birthday = customer_Birthday;
        this.customer_Id_Card = customer_Id_Card;
        this.customer_Phone = customer_Phone;
        this.customer_Email = customer_Email;
        this.customer_Address = customer_Address;
    }

    public Customer(int customer_Id, String type_Customer, String customer_Name, String customer_Birthday,
                    String customer_Id_Card, String customer_Phone, String customer_Email,
                    String customer_Address) {
        this.customer_Id = customer_Id;
        this.type_Customer = type_Customer;
        this.customer_Name = customer_Name;
        this.customer_Birthday = customer_Birthday;
        this.customer_Id_Card = customer_Id_Card;
        this.customer_Phone = customer_Phone;
        this.customer_Email = customer_Email;
        this.customer_Address = customer_Address;
    }

    public Customer(String type_Customer, String customer_Name, String customer_Birthday,
                    String customer_Id_Card, String customer_Phone, String customer_Email, String customer_Address) {
        this.type_Customer = type_Customer;
        this.customer_Name = customer_Name;
        this.customer_Birthday = customer_Birthday;
        this.customer_Id_Card = customer_Id_Card;
        this.customer_Phone = customer_Phone;
        this.customer_Email = customer_Email;
        this.customer_Address = customer_Address;
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }

    public int getType_Customer_Id() {
        return type_Customer_Id;
    }

    public void setType_Customer_Id(int type_Customer_Id) {
        this.type_Customer_Id = type_Customer_Id;
    }
    public String getType_Customer() {
        return type_Customer;
    }

    public void setType_Customer(String type_Customer_Id) {
        this.type_Customer = type_Customer_Id;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public String getCustomer_Birthday() {
        return customer_Birthday;
    }

    public void setCustomer_Birthday(String customer_Birthday) {
        this.customer_Birthday = customer_Birthday;
    }

    public String getCustomer_Id_Card() {
        return customer_Id_Card;
    }

    public void setCustomer_Id_Card(String customer_Id_Card) {
        this.customer_Id_Card = customer_Id_Card;
    }

    public String getCustomer_Phone() {
        return customer_Phone;
    }

    public void setCustomer_Phone(String customer_Phone) {
        this.customer_Phone = customer_Phone;
    }

    public String getCustomer_Email() {
        return customer_Email;
    }

    public void setCustomer_Email(String customer_Email) {
        this.customer_Email = customer_Email;
    }

    public String getCustomer_Address() {
        return customer_Address;
    }

    public void setCustomer_Address(String customer_Address) {
        this.customer_Address = customer_Address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_Id=" + customer_Id +
                ", type_Customer_Id=" + type_Customer_Id +
                ", type_Customer='" + type_Customer + '\'' +
                ", customer_Name='" + customer_Name + '\'' +
                ", customer_Birthday='" + customer_Birthday + '\'' +
                ", customer_Id_Card='" + customer_Id_Card + '\'' +
                ", customer_Phone='" + customer_Phone + '\'' +
                ", customer_Email='" + customer_Email + '\'' +
                ", customer_Address='" + customer_Address + '\'' +
                '}';
    }
}
