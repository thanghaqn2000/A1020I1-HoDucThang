package vn.codegym.model.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String taiKhoan;
    private String matKhau;
    private String moTa;
    private String sdt;
    private String email;
    @ManyToOne(targetEntity = LoaiNhanVien.class)
    @JoinColumn(name = "id_loaiNhanVien", referencedColumnName = "id")
    private LoaiNhanVien loaiNhanVien;
    @ManyToMany(mappedBy = "nhanViens")
    private Set<ChuyenBay> chuyenBays;

    public Set<ChuyenBay> getChuyenBays() {
        return chuyenBays;
    }

    public void setChuyenBays(Set<ChuyenBay> chuyenBays) {
        this.chuyenBays = chuyenBays;
    }

    public NhanVien() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoaiNhanVien getLoaiNhanVien() {
        return loaiNhanVien;
    }

    public void setLoaiNhanVien(LoaiNhanVien loaiNhanVien) {
        this.loaiNhanVien = loaiNhanVien;
    }
}
