package vn.codegym.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.bean.Service;

public interface ServiceRepo extends JpaRepository<Service,String> {
}
