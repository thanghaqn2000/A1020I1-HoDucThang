package model.bean;

public class Contract {
    private int id;
    private int idEmp;
    private int idCus;
    private int idService;
    private String emp;
    private String cus;
    private String service;
    private String contractDate;
    private String endDate;
    private double deposits;
    private double totalMoney;

    public Contract() {
    }

    public Contract(int id, int idEmp, int idCus, int idService, String emp, String cus, String service, String contractDate, String endDate, double deposits, double totalMoney) {
        this.id = id;
        this.idEmp = idEmp;
        this.idCus = idCus;
        this.idService = idService;
        this.emp = emp;
        this.cus = cus;
        this.service = service;
        this.contractDate = contractDate;
        this.endDate = endDate;
        this.deposits = deposits;
        this.totalMoney = totalMoney;
    }

    public Contract(int idEmp, int idCus, int idService, String contractDate, String endDate, double deposits, double totalMoney) {
        this.id = id;
        this.idEmp = idEmp;
        this.idCus = idCus;
        this.idService = idService;
        this.contractDate = contractDate;
        this.endDate = endDate;
        this.deposits = deposits;
        this.totalMoney = totalMoney;
    }

    public Contract(int id, String emp, String cus, String service, String contractDate, String endDate, double deposits, double totalMoney) {
        this.id = id;
        this.emp = emp;
        this.cus = cus;
        this.service = service;
        this.contractDate = contractDate;
        this.endDate = endDate;
        this.deposits = deposits;
        this.totalMoney = totalMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public int getIdCus() {
        return idCus;
    }

    public void setIdCus(int idCus) {
        this.idCus = idCus;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getEmp() {
        return emp;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    public String getCus() {
        return cus;
    }

    public void setCus(String cus) {
        this.cus = cus;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposits() {
        return deposits;
    }

    public void setDeposits(double deposits) {
        this.deposits = deposits;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
