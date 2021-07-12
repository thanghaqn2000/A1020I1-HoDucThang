package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.bean.ChuyenBay;
import vn.codegym.repository.ChuyenBayRepo;

import java.util.List;

@Service
public class ChuyenBayServiceImpl implements ChuyenBayService {
    @Autowired
    ChuyenBayRepo chuyenBayRepo;

    @Override
    public List<ChuyenBay> findAll() {
        return chuyenBayRepo.findAll();
    }

    @Override
    public ChuyenBay findById(int id) {
        return chuyenBayRepo.findById(id).orElse(null);
    }

    @Override
    public void update(ChuyenBay chuyenBay) {
        chuyenBayRepo.save(chuyenBay);
    }
}
