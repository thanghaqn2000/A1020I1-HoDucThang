package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.bean.Position;

public interface PositionRepo extends JpaRepository<Position,Integer> {
}
