package model.bean;

public class Service {
    private int id_service;
    private int id_type_service;
    private int id_type_rental;
    private String name_type_service;
    private String name_type_rental;
    private String name_service;
    private double area;
    private double floor;
    private int max_people;
    private double cost_rental;
    private String status;

    public Service() {
    }

    public Service(int id_service, int id_type_service, int id_type_rental, String name_type_service, String name_type_rental, String name_service, double area, double floor, int max_people, double cost_rental, String status) {
        this.id_service = id_service;
        this.id_type_service = id_type_service;
        this.id_type_rental = id_type_rental;
        this.name_type_service = name_type_service;
        this.name_type_rental = name_type_rental;
        this.name_service = name_service;
        this.area = area;
        this.floor = floor;
        this.max_people = max_people;
        this.cost_rental = cost_rental;
        this.status = status;
    }

    public Service(int id_type_service, int id_type_rental, String name_service, double area, double floor, int max_people, double cost_rental, String status) {
        this.id_type_service = id_type_service;
        this.id_type_rental = id_type_rental;
        this.name_service = name_service;
        this.area = area;
        this.floor = floor;
        this.max_people = max_people;
        this.cost_rental = cost_rental;
        this.status = status;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public int getId_type_service() {
        return id_type_service;
    }

    public void setId_type_service(int id_type_service) {
        this.id_type_service = id_type_service;
    }

    public int getId_type_rental() {
        return id_type_rental;
    }

    public void setId_type_rental(int id_type_rental) {
        this.id_type_rental = id_type_rental;
    }

    public String getName_type_service() {
        return name_type_service;
    }

    public void setName_type_service(String name_type_service) {
        this.name_type_service = name_type_service;
    }

    public String getName_type_rental() {
        return name_type_rental;
    }

    public void setName_type_rental(String name_type_rental) {
        this.name_type_rental = name_type_rental;
    }

    public String getName_service() {
        return name_service;
    }

    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getFloor() {
        return floor;
    }

    public void setFloor(double floor) {
        this.floor = floor;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public double getCost_rental() {
        return cost_rental;
    }

    public void setCost_rental(double cost_rental) {
        this.cost_rental = cost_rental;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
