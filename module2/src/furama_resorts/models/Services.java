package furama_resorts.models;

public abstract class Services {
    private String id;
    private String tenDichVu;
    private String kieuThue;
    private int chiPhiThue;
    private int soLuongNguoi;
    private double dienTichSuDung;
    public Services() {
    }

    public Services(String id, String tenDichVu, String kieuThue, int chiPhiThue, int amountMaxPeople, double areUsed) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.kieuThue = kieuThue;
        this.chiPhiThue = chiPhiThue;
        this.soLuongNguoi = amountMaxPeople;
        this.dienTichSuDung = areUsed;
    }

    public double getDienTichSuDung() {
        return dienTichSuDung;
    }

    public void setDienTichSuDung(double dienTichSuDung) {
        this.dienTichSuDung = dienTichSuDung;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }

    public int getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(int chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public abstract void showInfor();

}
