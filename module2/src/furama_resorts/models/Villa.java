package furama_resorts.models;

public class Villa extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghi;
    private double dienTichHoBoi;
    private int soTang;

    public Villa() {
    }

    public Villa(String id, String tenDichVu, String kieuThue, int chiPhiThue, int amountMaxPeople, String tieuChuanPhong, String moTaTienNghi, double dienTichHoBoi, int soTang) {
        super(id, tenDichVu, kieuThue, chiPhiThue, amountMaxPeople);
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
    public void showInfor() {
        System.out.println("Villa{" +
                "id= " + this.getId() + '\n' +
                ", tenDichVu= " + this.getTenDichVu() + '\n' +
                ", kieuThue= " + this.getKieuThue() + '\n' +
                ", chiPhiThue= " + this.getChiPhiThue() +
                ", amountMaxPeople= " + this.getAmountMaxPeople() + '\n' +
                ",tieuChuanPhong= " + tieuChuanPhong + '\n' +
                ", moTaTienNghi= " + moTaTienNghi + '\n' +
                ", dienTichHoBoi= " + dienTichHoBoi + '\n' +
                ", soTang= " + soTang +
                '}');
    }
}
