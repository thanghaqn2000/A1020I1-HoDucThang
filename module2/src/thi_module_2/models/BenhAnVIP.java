package thi_module_2.models;

public class BenhAnVIP extends BenhAn  {
    private String thoiHanVip;
    private String loaiVip;

    public BenhAnVIP() {
    }


    public BenhAnVIP(String sttBenhan, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String liDoNhapVien, String thoiHanVip, String loaiVip) {
        super(sttBenhan, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDoNhapVien);
        this.thoiHanVip = thoiHanVip;
        this.loaiVip = loaiVip;
    }

    public String getThoiHanVip() {
        return thoiHanVip;
    }

    public void setThoiHanVip(String thoiHanVip) {
        this.thoiHanVip = thoiHanVip;
    }

    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    @Override
    public String toString() {
        return "BenhAnVip{" +
                "sttBenhan='" + getSttBenhan() + '\'' +
                ", maBenhAn='" + getMaBenhAn() + '\'' +
                ", maBenhNhan='" + getMaBenhNhan() + '\'' +
                ", tenBenhNhan='" + getTenBenhNhan() + '\'' +
                ", ngayNhapVien='" + getNgayNhapVien() + '\'' +
                ", ngayRaVien='" + getNgayRaVien() + '\'' +
                ", liDoNhapVien='" + getLiDoNhapVien() + '\n' +
                "thoiHanVip='" + thoiHanVip + '\'' +
                ", loaiVip='" + loaiVip + '\'' +
                '}';
    }

    @Override
    public void showInfo() {
        System.out.println("BenhAnVip{" +
                "sttBenhan='" + getSttBenhan() + '\'' +
                ", maBenhAn='" + getMaBenhAn() + '\'' +
                ", maBenhNhan='" + getMaBenhNhan() + '\'' +
                ", tenBenhNhan='" + getTenBenhNhan() + '\'' +
                ", ngayNhapVien='" + getNgayNhapVien() + '\'' +
                ", ngayRaVien='" + getNgayRaVien() + '\'' +
                ", liDoNhapVien='" + getLiDoNhapVien() + '\n' +
                "thoiHanVip='" + thoiHanVip + '\'' +
                ", loaiVip='" + loaiVip + '\'' +
                '}');
    }
}
