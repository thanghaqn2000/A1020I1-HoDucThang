package model.bean;

public class MatBang {
    private  int id;
    private int idLoaiMatBang;
    private String loaiMatBang;
    private String trangThai;
    private double dienTich;
    private int tang;
    private double giaTien;
    private String ngayBatDau;
    private String ngayKetThuc;

    public MatBang() {
    }

    public MatBang(int id, int idLoaiMatBang, String loaiMatBang, String trangThai, double dienTich, int tang, double giaTien, String ngayBatDau, String ngayKetThuc) {
        this.id = id;
        this.idLoaiMatBang = idLoaiMatBang;
        this.loaiMatBang = loaiMatBang;
        this.trangThai = trangThai;
        this.dienTich = dienTich;
        this.tang = tang;
        this.giaTien = giaTien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public MatBang(int id, int idLoaiMatBang, String trangThai, double dienTich, int tang, double giaTien, String ngayBatDau, String ngayKetThuc) {
        this.id = id;
        this.idLoaiMatBang = idLoaiMatBang;
        this.trangThai = trangThai;
        this.dienTich = dienTich;
        this.tang = tang;
        this.giaTien = giaTien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public MatBang(int idLoaiMatBang, String trangThai, double dienTich, int tang, double giaTien, String ngayBatDau, String ngayKetThuc) {
        this.idLoaiMatBang = idLoaiMatBang;
        this.trangThai = trangThai;
        this.dienTich = dienTich;
        this.tang = tang;
        this.giaTien = giaTien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLoaiMatBang() {
        return idLoaiMatBang;
    }

    public void setIdLoaiMatBang(int idLoaiMatBang) {
        this.idLoaiMatBang = idLoaiMatBang;
    }

    public String getLoaiMatBang() {
        return loaiMatBang;
    }

    public void setLoaiMatBang(String loaiMatBang) {
        this.loaiMatBang = loaiMatBang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
