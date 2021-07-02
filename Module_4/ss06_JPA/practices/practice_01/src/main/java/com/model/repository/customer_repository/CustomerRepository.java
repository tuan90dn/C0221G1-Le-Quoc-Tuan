package com.model.repository.customer_repository;

import com.model.entity.Customer;
import com.model.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
@Repository

public class CustomerRepository implements ICustomerRepository {
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = BaseRepository.entityManager.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = BaseRepository.entityManager.createQuery("select c from Customer c where  c.id=:id", Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != null) {
            BaseRepository.entityManager.merge(customer);
        } else {
            BaseRepository.entityManager.persist(customer);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            BaseRepository.entityManager.remove(customer);
        }
    }
}
