package vn.codegym.service.tuyenBay;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.bean.ChuyenBay;
import vn.codegym.model.bean.TuyenBay;

import java.util.List;

public interface TuyenBayService {
    List<TuyenBay> findAll();
    Page<TuyenBay> findAllPage(Pageable pageable);
    TuyenBay findById(int id);
    void save(TuyenBay tuyenBay);
    void update(TuyenBay tuyenBay);
    void delete(int id);
    List<String> listNoiBay();
    List<String> listSanBay();
    Page<TuyenBay> filter(Pageable pageable,String LoaiTuyenBay,String sanBayDi,String sanBayDen);
    Page<TuyenBay> filterTuyenBay(Pageable pageable,String loaiTuyenBay);

}
