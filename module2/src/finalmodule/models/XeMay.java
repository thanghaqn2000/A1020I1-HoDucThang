package finalmodule.models;

public class XeMay extends PhuongTien{
    private String congSuat;

    public XeMay() {
    }

    public XeMay(String bienKiemSoat, String tenHangSX, String namSanXuat, String chuSoHuu, String congSuat) {
        super(bienKiemSoat, tenHangSX, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public String getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(String congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public void showInfor() {

    }
}
