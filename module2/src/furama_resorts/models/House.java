package furama_resorts.models;

public class House extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghi;
    private int soTang;

    public House() {
    }

    public House(String id, String tenDichVu, String kieuThue, int chiPhiThue, int amountMaxPeople, String tieuChuanPhong, String moTaTienNghi, int soTang) {
        super(id, tenDichVu, kieuThue, chiPhiThue, amountMaxPeople);
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
    public void showInfor() {
        System.out.println("Villa{" +
                "id= " + this.getId() + '\n' +
                ", tenDichVu= " + this.getTenDichVu() + '\n' +
                ", kieuThue= " + this.getKieuThue() + '\n' +
                ", chiPhiThue= " + this.getChiPhiThue() +
                ", amountMaxPeople= " + this.getAmountMaxPeople() + '\n' +
                ",tieuChuanPhong= " + tieuChuanPhong + '\n' +
                ", moTaTienNghi= " + moTaTienNghi + '\n' +
                ", soTang= " + soTang +
                '}');
    }
}