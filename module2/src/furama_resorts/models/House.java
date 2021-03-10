package furama_resorts.models;

public class House extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghi;
    private int soTang;

    public House() {
    }

    public House(String id, String tenDichVu, String kieuThue,String tieuChuanPhong, String moTaTienNghi , int chiPhiThue, int amountMaxPeople, int soTang, double areUsed ) {
        super(id, tenDichVu, kieuThue, chiPhiThue, amountMaxPeople, areUsed);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghi = moTaTienNghi;
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

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "House{" +
                "id= " + this.getId() + '\n' +
                ", tenDichVu= " + this.getTenDichVu() + '\n' +
                ", dienTichSuDung= " + this.getDienTichSuDung()+ '\n' +
                ", kieuThue= " + this.getKieuThue() + '\n' +
                ", chiPhiThue= " + this.getChiPhiThue() +
                ", amountMaxPeople= " + this.getSoLuongNguoi() + '\n' +
                ",tieuChuanPhong= " + tieuChuanPhong + '\n' +
                ", moTaTienNghi= " + moTaTienNghi + '\n' +
                ", soTang= " + soTang +
                '}';
    }

    @Override
    public void showInfor() {
        System.out.println("House{" +
                "id= " + this.getId() + '\n' +
                ", tenDichVu= " + this.getTenDichVu() + '\n' +
                ", dienTichSuDung= " + this.getDienTichSuDung()+ '\n' +
                ", kieuThue= " + this.getKieuThue() + '\n' +
                ", chiPhiThue= " + this.getChiPhiThue() +
                ", amountMaxPeople= " + this.getSoLuongNguoi() + '\n' +
                ",tieuChuanPhong= " + tieuChuanPhong + '\n' +
                ", moTaTienNghi= " + moTaTienNghi + '\n' +
                ", soTang= " + soTang +
                '}');
    }
}
