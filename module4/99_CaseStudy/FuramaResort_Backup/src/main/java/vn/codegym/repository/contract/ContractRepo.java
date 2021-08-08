package vn.codegym.repository.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.bean.Contract;

public interface ContractRepo extends JpaRepository<Contract,Integer> {
}
