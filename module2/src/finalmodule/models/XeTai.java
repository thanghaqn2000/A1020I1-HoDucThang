package finalmodule.models;

public class XeTai extends PhuongTien {
    private String trongTai;
    public XeTai() {
    }

    public XeTai(String bienKiemSoat, String tenHangSX, String namSanXuat, String chuSoHuu, String trongTai) {
        super(bienKiemSoat, tenHangSX, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public String getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(String trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public void showInfor() {

    }
}
