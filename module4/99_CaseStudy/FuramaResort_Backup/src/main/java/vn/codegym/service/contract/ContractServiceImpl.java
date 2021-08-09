package vn.codegym.service.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.codegym.model.bean.Contract;
import vn.codegym.repository.contract.ContractRepo;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepo contractRepo;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Contract> findAllSort(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("contractStartDate"));
        return contractRepo.findAll(pageable);
    }

    @Override
    public Page<Contract> findByDate(String dateStart, String dateEnd, Pageable pageable) {
        return null;
    }

    @Override
    public Contract findById(int id) {
        return contractRepo.findById(id).orElse(null);
    }

    @Override
    public void create(Contract contract) {
        contractRepo.save(contract);
    }

    @Override
    public void update(Contract contract) {
        contractRepo.save(contract);
    }

    @Override
    public void delete(int id) {
        contractRepo.deleteById(id);
    }

    @Override
    public boolean checkId(String id) {
        return false;
    }
}
