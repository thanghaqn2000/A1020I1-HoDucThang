package furama_resorts.models;

public class Room extends Services {
    private String tenDVDiKem;
    private String donVi;
    private int giaTien;

    public Room() {
    }

    public Room( String id, String tenDichVu, String kieuThue,String tenDVDiKem, String donVi,  int chiPhiThue,
                 int amountMaxPeople,int giaTien ,double areUsed ) {
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
    public String toString() {
        return "Room{" +
                "id= " + this.getId() +
                ", tenDichVu= " + this.getTenDichVu() +
                ", dienTichSuDung= " + this.getDienTichSuDung()+
                ", kieuThue= " + this.getKieuThue() +
                ", chiPhiThue= " + this.getChiPhiThue() +
                ", amountMaxPeople= " + this.getSoLuongNguoi() + '\n' +
                ",tenDVDiKem='" + tenDVDiKem + '\'' +
                ", donVi='" + donVi + '\'' +
                ", giaTien=" + giaTien +
                '}';
    }

    @Override
    public void showInfor() {
        System.out.println("Room{" +
                "id= " + this.getId() +
                ", tenDichVu= " + this.getTenDichVu() +
                ", dienTichSuDung= " + this.getDienTichSuDung()+
                ", kieuThue= " + this.getKieuThue() +
                ", chiPhiThue= " + this.getChiPhiThue() +
                ", amountMaxPeople= " + this.getSoLuongNguoi() + '\n' +
                ",tenDVDiKem='" + tenDVDiKem + '\'' +
                ", donVi='" + donVi + '\'' +
                ", giaTien=" + giaTien +
                '}');
    }
}
