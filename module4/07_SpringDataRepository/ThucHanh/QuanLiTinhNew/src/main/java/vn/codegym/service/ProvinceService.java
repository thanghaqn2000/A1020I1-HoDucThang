package vn.codegym.service;

import vn.codegym.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(int id);

    void save(Province province);

    void remove(Province province);
}
