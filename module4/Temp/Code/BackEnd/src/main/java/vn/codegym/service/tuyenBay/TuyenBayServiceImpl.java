package vn.codegym.service.tuyenBay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.bean.TuyenBay;
import vn.codegym.repository.tuyenBay.TuyenBayRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class TuyenBayServiceImpl implements TuyenBayService {
    @Autowired
    TuyenBayRepo tuyenBayRepo;

    @Override
    public List<TuyenBay> findAll() {
        return tuyenBayRepo.findAll();
    }

    @Override
    public Page<TuyenBay> findAllPage(Pageable pageable) {
        return tuyenBayRepo.findAll(pageable);
    }

    @Override
    public TuyenBay findById(int id) {
        return tuyenBayRepo.findById(id).orElse(null);
    }

    @Override
    public void save(TuyenBay tuyenBay) {
        tuyenBayRepo.save(tuyenBay);
    }

    @Override
    public void update(TuyenBay tuyenBay) {
        tuyenBayRepo.save(tuyenBay);
    }

    @Override
    public void delete(int id) {
        tuyenBayRepo.deleteById(id);
    }

    @Override
    public List<String> listNoiBay() {
        List<String> listNoiBay = new ArrayList<>();
        listNoiBay.add("Việt Nam");
        listNoiBay.add("Singapore");
        listNoiBay.add("Thailand");
        listNoiBay.add("Korea");
        listNoiBay.add("America");
        return listNoiBay;
    }

    @Override
    public List<String> listSanBay() {
        List<String> listSanBay = new ArrayList<>();
        listSanBay.add("Nội Bài");
        listSanBay.add("Tân Sơn Nhất");
        listSanBay.add("Đà Nẵng");
        listSanBay.add("Đà Lạt");
        listSanBay.add("Changi");
        listSanBay.add("Chiang Mai");
        listSanBay.add("Seoul");
        listSanBay.add("New York");
        return listSanBay;
    }

    @Override
    public Page<TuyenBay> filter(Pageable pageable, String LoaiTuyenBay, String sanBayDi, String sanBayDen) {
        return tuyenBayRepo.boLoc(pageable,LoaiTuyenBay,sanBayDi,sanBayDen);
    }

    @Override
    public Page<TuyenBay> filterTuyenBay(Pageable pageable, String loaiTuyenBay) {
        return tuyenBayRepo.boLocTuyenBay(pageable,loaiTuyenBay);
    }
}
