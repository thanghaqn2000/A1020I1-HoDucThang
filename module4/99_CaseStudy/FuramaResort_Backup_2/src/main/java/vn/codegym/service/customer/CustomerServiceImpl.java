package vn.codegym.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.bean.Customer;
import vn.codegym.repository.customer.CustomerRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public Page<Customer> findByName(String name,Pageable pageable) {
        return customerRepo.searchName(name,pageable);
    }

    @Override
    public Set<String> selectName(String name) {
        return customerRepo.selectName(name);
    }

    @Override
    public Customer findById(String id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public void create(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void delete(String id) {
        customerRepo.deleteById(id);
    }

    @Override
    public boolean checkId(String id) {
//        for (Customer customer : customerRepo.findAll()) {
//            if (id.equals(customer.getCustomerId()))
//                return false;
//        }
        return customerRepo.existsById(id);
    }
}
