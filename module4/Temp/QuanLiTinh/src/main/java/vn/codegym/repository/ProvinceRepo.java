package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.bean.Province;

public interface ProvinceRepo extends JpaRepository<Province,Integer> {
}
