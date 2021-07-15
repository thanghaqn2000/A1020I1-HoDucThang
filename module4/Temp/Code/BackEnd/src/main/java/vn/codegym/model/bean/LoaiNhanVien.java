package vn.codegym.model.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LoaiNhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String loaiNhanVien;
    @OneToMany(mappedBy = "loaiNhanVien")
    private Set<NhanVien> nhanViens;

    public LoaiNhanVien() {
    }

    public LoaiNhanVien(int id, String loaiNhanVien) {
        this.id = id;
        this.loaiNhanVien = loaiNhanVien;
    }

    public Set<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(Set<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaiNhanVien() {
        return loaiNhanVien;
    }

    public void setLoaiNhanVien(String loaiNhanVien) {
        this.loaiNhanVien = loaiNhanVien;
    }
}
