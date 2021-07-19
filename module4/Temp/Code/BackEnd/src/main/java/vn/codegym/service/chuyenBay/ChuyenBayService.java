package vn.codegym.service.chuyenBay;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.bean.ChuyenBay;
import vn.codegym.model.bean.TuyenBay;

import java.util.List;

public interface ChuyenBayService {
    List<ChuyenBay> findAll();
    ChuyenBay findById(int id);
    void update(ChuyenBay chuyenBay);
    Page<ChuyenBay> findAllPage(Pageable pageable);
    Page<ChuyenBay> findSoHieu(Pageable pageable,String soHieu);
    Page<ChuyenBay> filter(Pageable pageable,String loaiTuyenBay);
    Page<ChuyenBay> filterTinhTrang(String tinhTrang,String loaiTuyenBay,Pageable page);
    Page<ChuyenBay> filterTenTB(String tenTB,String loaiTuyenBay,Pageable page);
    Page<ChuyenBay> filterTenTB_TinhTrang(String tenTB,String tinhTrang,String loaiTuyenBay,Pageable page);
    Page<ChuyenBay> filterNgayDi_NgayDen(String ngayDi,String ngayDen,String loaiTuyenBay,Pageable page);
    Page<ChuyenBay> filterAll(Pageable pageable,String tenLoaiTB,String tenTB,String tinhTrang,String ngayDi,String ngayDen);

    Page<ChuyenBay> thongKe(Pageable pageable,String tenLoaiTB,String tinhTrang,String ngayDi,String ngayDen,String sanBayDi,
                            String sanBayDen);

    List<ChuyenBay> thongKeList(String tenLoaiTB,String tinhTrang,String ngayDi,String ngayDen);

}
