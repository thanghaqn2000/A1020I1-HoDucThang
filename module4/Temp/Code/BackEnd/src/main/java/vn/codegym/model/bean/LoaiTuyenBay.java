package vn.codegym.model.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LoaiTuyenBay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tenLoaiTuyenBay;
    @OneToMany(mappedBy = "loaiTuyenBay")
    private Set<TuyenBay> tuyenBays;

    public LoaiTuyenBay() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiTuyenBay() {
        return tenLoaiTuyenBay;
    }

    public void setTenLoaiTuyenBay(String tenLoaiTuyenBay) {
        this.tenLoaiTuyenBay = tenLoaiTuyenBay;
    }

    public Set<TuyenBay> getTuyenBays() {
        return tuyenBays;
    }

    public void setTuyenBays(Set<TuyenBay> tuyenBays) {
        this.tuyenBays = tuyenBays;
    }
}
