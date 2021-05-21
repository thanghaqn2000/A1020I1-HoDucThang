package model.service.user.impl;

import model.repository.customer.CustomerRepo;
import model.repository.customer.impl.CustomerRepoImpl;
import model.service.user.CustomerService;
import model.bean.Customer;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepo customerRepo=new CustomerRepoImpl();

    @Override
    public List<Customer> selectAllCus() {
        return customerRepo.selectAllCus();
    }

    @Override
    public boolean insertCus(Customer customer) {
        return customerRepo.insertCus(customer);
    }

    @Override
    public boolean deleteCus(int idCus) {
        return customerRepo.deleteCus(idCus);
    }

    @Override
    public boolean updateCus(Customer customer) {
        return customerRepo.updateCus(customer);
    }

    @Override
    public List<Customer> findCus(String nameCus) {
        return customerRepo.findCus(nameCus);
    }

    @Override
    public int getIdAuto() {
        return customerRepo.getIdAuto();
    }
}
