package furama_resorts.models;

public class Employee {
    private String idEmp;
    private String nameEmp;
    private String dofEmp;
    private String addressEmp;
    private String idCardEmp;
    private String numberPhoneEmp;
    private String emailEmp;
    private String levelEmp;
    private String positionemp;
    private String salaryEmp;

    public Employee() {
    }

    public Employee(String idEmp, String nameEmp, String dofEmp, String addressEmp, String idCardEmp,
                    String numberPhoneEmp, String emailEmp, String levelEmp, String positionEmp, String salaryEmp) {
        this.idEmp = idEmp;
        this.nameEmp = nameEmp;
        this.dofEmp = dofEmp;
        this.addressEmp = addressEmp;
        this.idCardEmp = idCardEmp;
        this.numberPhoneEmp = numberPhoneEmp;
        this.emailEmp = emailEmp;
        this.levelEmp = levelEmp;
        this.positionemp = positionEmp;
        this.salaryEmp = salaryEmp;
    }

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }

    public String getNameEmp() {
        return nameEmp;
    }

    public void setNameEmp(String nameEmp) {
        this.nameEmp = nameEmp;
    }

    public String getDofEmp() {
        return dofEmp;
    }

    public void setDofEmp(String dofEmp) {
        this.dofEmp = dofEmp;
    }

    public String getAddressEmp() {
        return addressEmp;
    }

    public void setAddressEmp(String addressEmp) {
        this.addressEmp = addressEmp;
    }

    public String getIdCardEmp() {
        return idCardEmp;
    }

    public void setIdCardEmp(String cmndEmp) {
        this.idCardEmp = idCardEmp;
    }

    public String getNumberPhoneEmp() {
        return numberPhoneEmp;
    }

    public void setNumberPhoneEmp(String numberPhoneEmp) {
        this.numberPhoneEmp = numberPhoneEmp;
    }

    public String getEmailEmp() {
        return emailEmp;
    }

    public void setEmailEmp(String emailEmp) {
        this.emailEmp = emailEmp;
    }

    public String getLevelEmp() {
        return levelEmp;
    }

    public void setLevelEmp(String levelEmp) {
        this.levelEmp = levelEmp;
    }

    public String getPositonEmp() {
        return positionemp;
    }

    public void setPositonEmp(String positonEmp) {
        this.positionemp = positonEmp;
    }

    public String getSalaryEmp() {
        return salaryEmp;
    }

    public void setSalaryEmp(String salaryEmp) {
        this.salaryEmp = salaryEmp;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "idEmp='" + idEmp + '\'' +
                ", nameEmp='" + nameEmp + '\'' +
                ", dofEmp='" + dofEmp + '\'' +
                ", addressEmp='" + addressEmp + '\'' +
                ", idCardEmp='" + idCardEmp + '\'' +
                ", numberPhoneEmp='" + numberPhoneEmp + '\'' +
                ", emailEmp='" + emailEmp + '\n' +
                ", levelEmp='" + levelEmp + '\'' +
                ", positionEmp='" + positionemp + '\'' +
                ", salaryEmp='" + salaryEmp + '\'' +
                '}';
    }
}
