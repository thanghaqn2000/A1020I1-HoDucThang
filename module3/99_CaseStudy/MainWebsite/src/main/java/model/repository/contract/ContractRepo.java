package model.repository.contract;

import model.bean.Contract;

import java.util.List;

public interface ContractRepo {
    List<Contract> selectAll();
    boolean insert(Contract contract);
}
