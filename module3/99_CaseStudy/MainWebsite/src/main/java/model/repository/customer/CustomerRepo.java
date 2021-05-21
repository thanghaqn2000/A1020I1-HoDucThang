package model.repository.customer;

import model.bean.Customer;

import java.util.List;

public interface CustomerRepo {
    List<Customer> selectAllCus();
    boolean insertCus(Customer customer);
    boolean deleteCus(int idCus);
    boolean updateCus(Customer customer);
    List<Customer> findCus(String nameCus);
    Customer selectCus(int id);
    int getIdAuto();
}
