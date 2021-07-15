package vn.codegym.model.bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class TuyenBay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(min = 5,max = 10,message = "The length must be >= 5")
    private String tenTuyenBay;

    private String noiDi;
    private String noiDen;



    private String sanBayDi;
    private String sanBayDen;
    @ManyToOne(targetEntity = LoaiTuyenBay.class)
    @JoinColumn(name = "id_loai_tuyen_bay",referencedColumnName = "id")
    private LoaiTuyenBay loaiTuyenBay;
    @OneToMany(mappedBy = "tuyenBay",cascade = CascadeType.ALL)
    private Set<ChuyenBay> chuyenBays;
    public TuyenBay() {
    }

    public LoaiTuyenBay getLoaiTuyenBay() {
        return loaiTuyenBay;
    }

    public void setLoaiTuyenBay(LoaiTuyenBay loaiTuyenBay) {
        this.loaiTuyenBay = loaiTuyenBay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTuyenBay() {
        return tenTuyenBay;
    }

    public void setTenTuyenBay(String tenTuyenBay) {
        this.tenTuyenBay = tenTuyenBay;
    }

    public String getSanBayDi() {
        return sanBayDi;
    }

    public void setSanBayDi(String sanBayDi) {
        this.sanBayDi = sanBayDi;
    }

    public String getSanBayDen() {
        return sanBayDen;
    }

    public Set<ChuyenBay> getChuyenBays() {
        return chuyenBays;
    }

    public void setChuyenBays(Set<ChuyenBay> chuyenBays) {
        this.chuyenBays = chuyenBays;
    }

    public void setSanBayDen(String sanBayDen) {
        this.sanBayDen = sanBayDen;
    }
    public String getNoiDi() {
        return noiDi;
    }

    public void setNoiDi(String noiDi) {
        this.noiDi = noiDi;
    }

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

}
