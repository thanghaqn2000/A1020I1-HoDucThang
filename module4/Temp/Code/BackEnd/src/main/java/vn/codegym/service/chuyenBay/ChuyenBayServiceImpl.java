package vn.codegym.service.chuyenBay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.bean.ChuyenBay;
import vn.codegym.repository.chuyenBay.ChuyenBayRepo;

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

    @Override
    public Page<ChuyenBay> findAllPage(Pageable pageable) {
        return chuyenBayRepo.findAll(pageable);
    }

    @Override
    public Page<ChuyenBay> findSoHieu(Pageable pageable, String soHieu) {
        return chuyenBayRepo.findSoHieu(pageable,soHieu);
    }

    @Override
    public Page<ChuyenBay> filter(Pageable pageable,String loaiTuyenBay) {
        return chuyenBayRepo.findByTuyenBay_LoaiTuyenBayTenLoaiTuyenBay(pageable,loaiTuyenBay);
    }

    @Override
    public Page<ChuyenBay> filterTinhTrang(String tinhTrang,String loaiTuyenBay,  Pageable page) {
        return chuyenBayRepo.findByTinhTrangChuyenBayAndTuyenBay_LoaiTuyenBayTenLoaiTuyenBay(tinhTrang, loaiTuyenBay, page);

    }

    @Override
    public Page<ChuyenBay> filterTenTB(String tenTB, String loaiTuyenBay, Pageable page) {
        return chuyenBayRepo.findByTuyenBayTenTuyenBayAndTuyenBay_LoaiTuyenBayTenLoaiTuyenBay(tenTB, loaiTuyenBay, page);
    }

    @Override
    public Page<ChuyenBay> filterTenTB_TinhTrang(String tenTB,String tinhTrang ,String loaiTuyenBay, Pageable page) {
        return chuyenBayRepo.findByTuyenBayTenTuyenBayAndTinhTrangChuyenBayAndTuyenBay_LoaiTuyenBayTenLoaiTuyenBay(tenTB, tinhTrang, loaiTuyenBay, page);
    }

    @Override
    public Page<ChuyenBay> filterNgayDi_NgayDen(String ngayDi, String ngayDen,String loaiTuyenBay, Pageable page) {
        return chuyenBayRepo.filterNgayDiNgayDen(loaiTuyenBay, ngayDi,ngayDen, page);
    }

    @Override
    public Page<ChuyenBay> filterAll(Pageable pageable, String tenLoaiTB, String tenTB, String tinhTrang, String ngayDi, String ngayDen) {
        return chuyenBayRepo.filterAll(pageable,tenTB, tenLoaiTB,  tinhTrang, ngayDi, ngayDen);
    }


}
