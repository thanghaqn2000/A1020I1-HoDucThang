package thi_module_2.models;

public class BenhAnThuong extends BenhAn{
    private double phiNamVien;

    public BenhAnThuong() {
    }


    public BenhAnThuong(String sttBenhan, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String liDoNhapVien, double phiNamVien) {
        super(sttBenhan, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public double getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return "BenhAnThuong{" +
                "sttBenhan='" + getSttBenhan() + '\'' +
                ", maBenhAn='" + getMaBenhAn() + '\'' +
                ", maBenhNhan='" + getMaBenhNhan() + '\'' +
                ", tenBenhNhan='" + getTenBenhNhan() + '\'' +
                ", ngayNhapVien='" + getNgayNhapVien() + '\'' +
                ", ngayRaVien='" + getNgayRaVien() + '\n' +
                ", liDoNhapVien='" + getLiDoNhapVien() + '\'' +
                "phiNamVien=" + phiNamVien +
                '}';
    }

    @Override
    public void showInfo() {
        System.out.println("BenhAnThuong{" +
                "sttBenhan='" + getSttBenhan() + '\'' +
                ", maBenhAn='" + getMaBenhAn() + '\'' +
                ", maBenhNhan='" + getMaBenhNhan() + '\'' +
                ", tenBenhNhan='" + getTenBenhNhan() + '\'' +
                ", ngayNhapVien='" + getNgayNhapVien() + '\'' +
                ", ngayRaVien='" + getNgayRaVien() + '\n' +
                ", liDoNhapVien='" + getLiDoNhapVien() + '\'' +
                "phiNamVien=" + phiNamVien +
                '}');
    }
}
