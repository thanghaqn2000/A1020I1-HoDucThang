package vn.codegym.repository.home;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.bean.ChuyenBay;

import java.util.List;

public interface SearchRepo extends JpaRepository<ChuyenBay, Integer> {

    @Query(value = "SELECT * FROM chuyen_bay join tuyen_bay on chuyen_bay.id_tuyenbay = tuyen_bay.id " +
            "join loai_tuyen_bay on tuyen_bay.id_loai_tuyen_bay = loai_tuyen_bay.id" +
            " where chuyen_bay.ngay_den = :ngayDen and chuyen_bay.ngay_di = :NgayDi " +
            "or tuyen_bay.san_bay_den = :NoiDen or tuyen_bay.ten_tuyen_bay = :tentuyenbay", nativeQuery = true)
    Page<ChuyenBay> timKiem(Pageable pageable, @Param("tentuyenbay") String tentuyenbay, @Param("NoiDen") String NoiDen,
                            @Param("NgayDi") String NgayDi, @Param("ngayDen") String ngayDen);
}
