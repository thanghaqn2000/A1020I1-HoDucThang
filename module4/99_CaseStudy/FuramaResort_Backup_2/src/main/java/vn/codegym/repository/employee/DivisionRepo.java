package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.bean.Division;

public interface DivisionRepo extends JpaRepository<Division,Integer> {
}
