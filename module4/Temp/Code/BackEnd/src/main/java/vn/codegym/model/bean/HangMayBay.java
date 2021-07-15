package vn.codegym.model.bean;

import javax.persistence.*;

@Entity
public class HangMayBay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tenHangMayBay;
    @OneToOne(mappedBy = "hangMayBay")
    private SoHieu soHieu;
    public HangMayBay() {
    }

    public HangMayBay(int id, String tenHangMayBay) {
        this.id = id;
        this.tenHangMayBay = tenHangMayBay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenHangMayBay() {
        return tenHangMayBay;
    }

    public void setTenHangMayBay(String tenHangMayBay) {
        this.tenHangMayBay = tenHangMayBay;
    }
}
