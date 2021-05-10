package model.repository.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CustomerRepositoryImplement implements CustomerRepository {
    private static Map<Integer, Customer> customerMap = new TreeMap<>();

    static {
        customerMap.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customerMap.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customerMap.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customerMap.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customerMap.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customerMap.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public boolean save(Customer customer) {
        int idCustomer = (int) (Math.random() * 100);
        customer.setId(idCustomer);
        customerMap.put(idCustomer, customer);
        return true;
    }

    @Override
    public Customer findById(int idCustomer) {
        return customerMap.get(idCustomer);
    }

    @Override
    public boolean edit(int idCustomer, Customer customer) {
        customerMap.put(idCustomer, customer);
        return true;
    }


    @Override
    public void delete(int idCustomer) {
        customerMap.remove(idCustomer);
    }
}
