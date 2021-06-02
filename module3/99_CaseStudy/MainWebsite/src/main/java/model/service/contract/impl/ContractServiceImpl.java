package model.service.contract.impl;

import model.bean.Contract;
import model.repository.contract.ContractRepo;
import model.repository.contract.impl.ContractRepoImpl;
import model.service.contract.ContractService;

import java.util.List;

public class ContractServiceImpl implements ContractService {
    ContractRepo contractRepo=new ContractRepoImpl();
    @Override
    public List<Contract> selectAll() {
        return contractRepo.selectAll();
    }

    @Override
    public boolean insert(Contract contract) {
        return contractRepo.insert(contract);
    }
}
