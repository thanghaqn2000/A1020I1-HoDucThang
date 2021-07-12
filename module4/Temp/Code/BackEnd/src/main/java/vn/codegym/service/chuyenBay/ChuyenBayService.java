package vn.codegym.service;

import vn.codegym.model.bean.ChuyenBay;

import java.util.List;

public interface ChuyenBayService {
    List<ChuyenBay> findAll();
    ChuyenBay findById(int id);
    void update(ChuyenBay chuyenBay);

}
