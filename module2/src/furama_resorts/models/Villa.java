package furama_resorts.models;

public class Villa extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghi;
    private double dienTichHoBoi;
    private int soTang;
    public Villa() {
    }

    public Villa(String id, String tenDichVu, String kieuThue, String tieuChuanPhong, String moTaTienNghi, int chiPhiThue,
                 int amountMaxPeople, int soTang, double areUsed, double dienTichHoBoi) {
        super(id, tenDichVu, kieuThue, chiPhiThue, amountMaxPeople, areUsed);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghi = moTaTienNghi;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }



    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getMoTaTienNghi() {
        return moTaTienNghi;
    }

    public void setMoTaTienNghi(String moTaTienNghi) {
        this.moTaTienNghi = moTaTienNghi;
    }

    public double getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(double dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "id= " + this.getId() + " |" +
                ", tenDichVu= " + this.getTenDichVu() + " |" +
                ", dienTichSuDung= " + this.getDienTichSuDung() + " |" +
                ", kieuThue= " + this.getKieuThue() + " |" +
                ", chiPhiThue= " + this.getChiPhiThue() +
                ", amountMaxPeople= " + this.getSoLuongNguoi() + " |" +
                ",tieuChuanPhong= " + tieuChuanPhong + "\n" +
                ", moTaTienNghi= " + moTaTienNghi + " |" +
                ", dienTichHoBoi= " + dienTichHoBoi +
                ", soTang= " + soTang +
                '}';
    }

    @Override
    public void showInfor() {
        System.out.println("Villa{" +
                "id= " + this.getId() + " |" +
                ", tenDichVu= " + this.getTenDichVu() + " |" +
                ", dienTichSuDung= " + this.getDienTichSuDung() + " |" +
                ", kieuThue= " + this.getKieuThue() + " |" +
                ", chiPhiThue= " + this.getChiPhiThue() +
                ", amountMaxPeople= " + this.getSoLuongNguoi() + " |" +
                ",tieuChuanPhong= " + tieuChuanPhong + "\n" +
                ", moTaTienNghi= " + moTaTienNghi + " |" +
                ", dienTichHoBoi= " + dienTichHoBoi +
                ", soTang= " + soTang +
                '}');
    }
}
