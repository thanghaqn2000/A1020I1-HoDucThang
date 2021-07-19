package vn.codegym.repository.chuyenBay;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.bean.ChuyenBay;
import vn.codegym.model.bean.TuyenBay;
import vn.codegym.model.bean.LoaiTuyenBay;

import java.util.List;
import java.util.Set;

public interface ChuyenBayRepo extends JpaRepository<ChuyenBay, Integer> {
    @Query("select c from ChuyenBay c where c.soHieu.soHieu like %:soHieu%")
    Page<ChuyenBay> findSoHieu(Pageable pageable, @Param("soHieu") String soHieu);

    @Query(value = "SELECT * FROM chuyen_bay join tuyen_bay on chuyen_bay.id_tuyenbay = tuyen_bay.id " +
            "join loai_tuyen_bay on tuyen_bay.id_loai_tuyen_bay = loai_tuyen_bay.id" +
            " where loai_tuyen_bay.ten_loai_tuyen_bay = :loaiTuyenBay", nativeQuery = true)
    Page<ChuyenBay> boLoc(Pageable pageable, @Param("loaiTuyenBay") String loaiTuyenBay);


    @Query(value = "SELECT * FROM chuyen_bay join tuyen_bay on chuyen_bay.id_tuyenbay = tuyen_bay.id " +
            "join loai_tuyen_bay on tuyen_bay.id_loai_tuyen_bay = loai_tuyen_bay.id" +
            " where loai_tuyen_bay.ten_loai_tuyen_bay = :loaiTuyenBay and chuyen_bay.ngay_di = :ngayDi and chuyen_bay.ngay_den = :ngayDen", nativeQuery = true)
    Page<ChuyenBay> filterNgayDiNgayDen(@Param("loaiTuyenBay") String loaiTuyenBay,
                                        @Param("ngayDi") String ngayDi, @Param("ngayDen") String ngayDen, Pageable page);

    Page<ChuyenBay> findByTuyenBay_LoaiTuyenBayTenLoaiTuyenBay(Pageable page, String loaiTuyenBay);

    Page<ChuyenBay> findByTinhTrangChuyenBayAndTuyenBay_LoaiTuyenBayTenLoaiTuyenBay(
            String tinhTrang, String tenLoaiTB, Pageable page);

    Page<ChuyenBay> findByTuyenBayTenTuyenBayAndTuyenBay_LoaiTuyenBayTenLoaiTuyenBay(
            String tenTuyenBay, String tenLoaiTB, Pageable page);

    Page<ChuyenBay> findByTuyenBayTenTuyenBayAndTinhTrangChuyenBayAndTuyenBay_LoaiTuyenBayTenLoaiTuyenBay(
            String tenTuyenBay, String tinhTrang, String tenLoaiTB, Pageable page);

    @Query(value = "SELECT * FROM chuyen_bay join tuyen_bay on chuyen_bay.id_tuyenbay = tuyen_bay.id " +
            "join loai_tuyen_bay on tuyen_bay.id_loai_tuyen_bay = loai_tuyen_bay.id" +
            " where loai_tuyen_bay.ten_loai_tuyen_bay = :loaiTuyenBay and tuyen_bay.ten_tuyen_bay = :tuyenBay " +
            "and chuyen_bay.tinh_trang_chuyen_bay = :tinhTrang and chuyen_bay.ngay_di = :ngayDi " +
            "and chuyen_bay.ngay_den = :ngayDen ", nativeQuery = true)
    Page<ChuyenBay> filterAll(Pageable pageable, @Param("tuyenBay") String tuyenBay,
                              @Param("loaiTuyenBay") String loaiTuyenBay, @Param("tinhTrang") String tinhTrang,
                              @Param("ngayDi") String ngayDi, @Param("ngayDen") String ngayDen);


    @Query(value = "SELECT * FROM chuyen_bay join tuyen_bay on chuyen_bay.id_tuyenbay = tuyen_bay.id " +
            "join loai_tuyen_bay on tuyen_bay.id_loai_tuyen_bay = loai_tuyen_bay.id" +
            " where loai_tuyen_bay.ten_loai_tuyen_bay = :loaiTuyenBay and chuyen_bay.tinh_trang_chuyen_bay = :tinhTrang" +
            " and chuyen_bay.ngay_di = :ngayDi " +
            "and chuyen_bay.ngay_den = :ngayDen and tuyen_bay.san_bay_di = :sanBayDi and tuyen_bay.san_bay_den = :sanBayDen", nativeQuery = true)
    Page<ChuyenBay> thongke(Pageable pageable,@Param("loaiTuyenBay") String loaiTuyenBay, @Param("tinhTrang") String tinhTrang,
                            @Param("ngayDi") String ngayDi, @Param("ngayDen") String ngayDen,@Param("sanBayDi") String sanBayDi,
                            @Param("sanBayDen") String sanBayDen);


    @Query(value = "SELECT * FROM chuyen_bay join tuyen_bay on chuyen_bay.id_tuyenbay = tuyen_bay.id " +
            "join loai_tuyen_bay on tuyen_bay.id_loai_tuyen_bay = loai_tuyen_bay.id" +
            " where loai_tuyen_bay.ten_loai_tuyen_bay = :loaiTuyenBay " +
            "and (chuyen_bay.tinh_trang_chuyen_bay = :tinhTrang and chuyen_bay.ngay_di = :ngayDi " +
            "and chuyen_bay.ngay_den = :ngayDen or loai_tuyen_bay.ten_loai_tuyen_bay = :loaiTuyenBay) ", nativeQuery = true)
    List<ChuyenBay> thongkeList(@Param("loaiTuyenBay") String loaiTuyenBay, @Param("tinhTrang") String tinhTrang,
                                @Param("ngayDi") String ngayDi, @Param("ngayDen") String ngayDen);

}
