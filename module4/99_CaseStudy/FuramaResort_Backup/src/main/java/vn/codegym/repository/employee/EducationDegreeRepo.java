package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.bean.EducationDegree;

public interface EducationDegreeRepo extends JpaRepository<EducationDegree,Integer> {
}
