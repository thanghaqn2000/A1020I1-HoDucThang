package vn.codegym.model.bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Entity
public class ChuyenBay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tinhTrangChuyenBay;
    private String moTaNguyenNhan;
    private String timeDiDuKien;
    private String timeDenDuKien;
    private String ngayDiDuKien;
    private String NgayDenDuKien;
    private String timeDi;

    public String getMoTaNguyenNhan() {
        return moTaNguyenNhan;
    }

    public void setMoTaNguyenNhan(String moTaNguyenNhan) {
        this.moTaNguyenNhan = moTaNguyenNhan;
    }

    private String timeDen;
    private String ngayDi;
    private String NgayDen;
    @ManyToMany
    @JoinTable(
            name = "phan_cong",
            joinColumns = @JoinColumn(name = "id_chuyenbay"),
            inverseJoinColumns = @JoinColumn(name = "id_nhanvien")
    )
    private Set<NhanVien> nhanViens;

    @ManyToOne(targetEntity = TuyenBay.class)
    @JoinColumn(name = "id_tuyenbay", referencedColumnName = "id")
    private TuyenBay tuyenBay;

    @ManyToOne(targetEntity = SoHieu.class)
    @JoinColumn(name = "id_sohieu",referencedColumnName = "id")
    private SoHieu soHieu;

    public ChuyenBay() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTinhTrangChuyenBay() {
        return tinhTrangChuyenBay;
    }

    public void setTinhTrangChuyenBay(String tinhTrangChuyenBay) {
        this.tinhTrangChuyenBay = tinhTrangChuyenBay;
    }


    public String getTimeDiDuKien() {
        return timeDiDuKien;
    }

    public void setTimeDiDuKien(String timeDiDuKien) {
        this.timeDiDuKien = timeDiDuKien;
    }

    public String getTimeDenDuKien() {
        return timeDenDuKien;
    }

    public void setTimeDenDuKien(String timeDenDuKien) {
        this.timeDenDuKien = timeDenDuKien;
    }

    public String getNgayDiDuKien() {
        return ngayDiDuKien;
    }

    public void setNgayDiDuKien(String ngayDiDuKien) {
        this.ngayDiDuKien = ngayDiDuKien;
    }

    public String getNgayDenDuKien() {
        return NgayDenDuKien;
    }

    public void setNgayDenDuKien(String ngayDenDuKien) {
        NgayDenDuKien = ngayDenDuKien;
    }

    public String getTimeDi() {
        return timeDi;
    }

    public void setTimeDi(String timeDi) {
        this.timeDi = timeDi;
    }

    public String getTimeDen() {
        return timeDen;
    }

    public void setTimeDen(String timeDen) {
        this.timeDen = timeDen;
    }

    public String getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(String ngayDi) {
        this.ngayDi = ngayDi;
    }

    public String getNgayDen() {
        return NgayDen;
    }

    public void setNgayDen(String ngayDen) {
        NgayDen = ngayDen;
    }

    public Set<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(Set<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }

    public TuyenBay getTuyenBay() {
        return tuyenBay;
    }

    public void setTuyenBay(TuyenBay tuyenBay) {
        this.tuyenBay = tuyenBay;
    }

    public SoHieu getSoHieu() {
        return soHieu;
    }


    public void setSoHieu(SoHieu soHieu) {
        this.soHieu = soHieu;
    }



}
