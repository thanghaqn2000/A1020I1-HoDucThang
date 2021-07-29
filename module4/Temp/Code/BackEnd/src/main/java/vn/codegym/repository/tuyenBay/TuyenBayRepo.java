package vn.codegym.repository.tuyenBay;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.bean.ChuyenBay;
import vn.codegym.model.bean.TuyenBay;

import java.util.Set;

public interface TuyenBayRepo extends JpaRepository<TuyenBay, Integer> {

    @Query(value = "SELECT * FROM tuyen_bay join loai_tuyen_bay on tuyen_bay.id_loai_tuyen_bay = loai_tuyen_bay.id " +
            " where loai_tuyen_bay.ten_loai_tuyen_bay = :loaiTuyenBay and tuyen_bay.san_bay_di = :sanBayDi " +
            "and tuyen_bay.san_bay_den = :sanBayDen ", nativeQuery = true)
    Page<TuyenBay> boLoc(Pageable pageable, @Param("loaiTuyenBay") String loaiTuyenBay,
                         @Param("sanBayDi") String sanBayDi, @Param("sanBayDen") String sanBayDen);

    @Query(value = "SELECT * FROM tuyen_bay join loai_tuyen_bay on tuyen_bay.id_loai_tuyen_bay = loai_tuyen_bay.id " +
            " where loai_tuyen_bay.ten_loai_tuyen_bay = :loaiTuyenBay ", nativeQuery = true)
    Page<TuyenBay> boLocTuyenBay(Pageable pageable, @Param("loaiTuyenBay") String loaiTuyenBay);

    Set<TuyenBay> findTuyenBayByLoaiTuyenBay_Id(int id);

}
