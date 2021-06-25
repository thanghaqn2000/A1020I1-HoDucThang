package com.example.repository;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT s FROM Customer as s ", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(int id) {
        return entityManager.find(Customer.class,id);
    }

    @Override
    public List<Customer> findCustomer(String name) {
        return null;
    }

    @Override
    public void save(Customer student) {
        entityManager.persist(student);
    }

    @Override
    public void delete(Customer customer) {

          entityManager.remove(entityManager.merge(customer));
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }
}
