package furama_resorts.models;

public class Room extends Services {
    private String tenDVDiKem;
    private String donVi;
    private int giaTien;

    public Room() {
    }

    public Room(String id, String tenDichVu, String kieuThue, int chiPhiThue, int amountMaxPeople, double areUsed, String tenDVDiKem, String donVi, int giaTien) {
        super(id, tenDichVu, kieuThue, chiPhiThue, amountMaxPeople, areUsed);
        this.tenDVDiKem = tenDVDiKem;
        this.donVi = donVi;
        this.giaTien = giaTien;
    }
    public String getTenDVDiKem() {
        return tenDVDiKem;
    }

    public void setTenDVDiKem(String tenDVDiKem) {
        this.tenDVDiKem = tenDVDiKem;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public void showInfor() {
        System.out.println("Room{" +
                "id= " + this.getId() + '\n' +
                ", tenDichVu= " + this.getTenDichVu() + '\n' +
                ", dienTichSuDung= " + this.getDienTichSuDung()+ '\n' +
                ", kieuThue= " + this.getKieuThue() + '\n' +
                ", chiPhiThue= " + this.getChiPhiThue() +
                ", amountMaxPeople= " + this.getSoLuongNguoi() + '\n' +
                ",tenDVDiKem='" + tenDVDiKem + '\'' +
                ", donVi='" + donVi + '\'' +
                ", giaTien=" + giaTien +
                '}');
    }
}
