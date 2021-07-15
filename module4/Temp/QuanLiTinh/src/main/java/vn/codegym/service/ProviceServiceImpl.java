package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.bean.Province;
import vn.codegym.repository.ProvinceRepo;

@Service
public class ProviceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepo provinceRepo;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepo.findAll();
    }

    @Override
    public Province findById(int id) {
        return provinceRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepo.save(province);
    }

    @Override
    public void remove(Province province) {
        provinceRepo.delete(province);
    }
}
