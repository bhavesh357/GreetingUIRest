package com.web.customer.dao;

import com.web.customer.exception.CustomerException;
import com.web.customer.model.Customer;
import com.web.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;


@Component
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    CustomerRepository repository;

    @Override
    public Customer getCustomerById(int id) {
        try {
            return repository.findById(id).get();
        }catch (NoSuchElementException ex){
            throw new CustomerException("No Customer with ID "+id+" exist.");
        }

    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex){
            throw new CustomerException("No Customer with ID "+id+" exist.");
        }
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

}
