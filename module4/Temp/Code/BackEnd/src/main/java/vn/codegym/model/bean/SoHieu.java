package vn.codegym.model.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SoHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String soHieu;
    private String chiTiet;

    @ManyToOne(targetEntity = LoaiMayBay.class)
    @JoinColumn(name = "id_loai_may_bay",referencedColumnName = "id")
    private LoaiMayBay loaiMayBay;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_hang_may_bay",referencedColumnName = "id")
    private HangMayBay hangMayBay;

    @OneToMany(mappedBy = "soHieu")
    private Set<ChuyenBay> chuyenBays;

    public SoHieu(int id, String soHieu, String chiTiet, LoaiMayBay loaiMayBay, HangMayBay hangMayBay) {
        this.id = id;
        this.soHieu = soHieu;
        this.chiTiet = chiTiet;
        this.loaiMayBay = loaiMayBay;
        this.hangMayBay = hangMayBay;
    }

    public SoHieu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoHieu() {
        return soHieu;
    }

    public void setSoHieu(String soHieu) {
        this.soHieu = soHieu;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    public LoaiMayBay getLoaiMayBay() {
        return loaiMayBay;
    }

    public void setLoaiMayBay(LoaiMayBay loaiMayBay) {
        this.loaiMayBay = loaiMayBay;
    }

    public HangMayBay getHangMayBay() {
        return hangMayBay;
    }

    public void setHangMayBay(HangMayBay hangMayBay) {
        this.hangMayBay = hangMayBay;
    }
}
