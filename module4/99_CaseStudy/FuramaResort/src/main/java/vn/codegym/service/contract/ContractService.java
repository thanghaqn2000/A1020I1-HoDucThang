package vn.codegym.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.bean.Contract;
import vn.codegym.model.bean.Customer;

import java.util.Set;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);
    Page<Contract> findAllSort(int pageNum,int pageSize);
    Page<Contract> findByDate(String dateStart,String dateEnd,Pageable pageable);
    Contract findById(int id);
    void create(Contract contract);
    void update(Contract contract);
    void delete(int id);
    boolean checkId(String id);
}
