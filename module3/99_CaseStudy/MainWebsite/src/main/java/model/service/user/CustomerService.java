package model.service.user;

import model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> selectAllCus();
    boolean insertCus(Customer customer);
    boolean deleteCus(int idCus);
    boolean updateCus(Customer customer);
    List<Customer> findCus(String nameCus);
    int getIdAuto();
    Customer selectCus(int id);
}
