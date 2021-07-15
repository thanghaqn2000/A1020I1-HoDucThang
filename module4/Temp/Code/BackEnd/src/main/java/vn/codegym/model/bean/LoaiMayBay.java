package vn.codegym.model.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LoaiMayBay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tenLoaiMayBay;
    @OneToMany(mappedBy = "loaiMayBay")
    private Set<SoHieu> soHieus;
    public LoaiMayBay() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiMayBay() {
        return tenLoaiMayBay;
    }

    public void setTenLoaiMayBay(String tenLoaiMayBay) {
        this.tenLoaiMayBay = tenLoaiMayBay;
    }

    public LoaiMayBay(int id, String tenLoaiMayBay) {
        this.id = id;
        this.tenLoaiMayBay = tenLoaiMayBay;
    }


}
