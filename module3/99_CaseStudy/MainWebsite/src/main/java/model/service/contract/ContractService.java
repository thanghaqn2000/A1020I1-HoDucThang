package model.service.contract;

import model.bean.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> selectAll();
    boolean insert(Contract contract);
}
