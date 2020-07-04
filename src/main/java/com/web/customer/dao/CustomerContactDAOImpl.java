package com.web.customer.dao;

import com.web.customer.exception.CustomerException;
import com.web.customer.model.Customer;
import com.web.customer.model.CustomerContact;
import com.web.customer.model.CustomerDetails;
import com.web.customer.repository.CustomerContactRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CustomerContactDAOImpl implements CustomerContactDao{

    @Autowired
    private CustomerContactRepositories repo;

    @Override
    public CustomerContact getCustomerById(int id) {
        try {
            return repo.findById(id).get();
        }catch (NoSuchElementException ex){
            throw new CustomerException("No Customer with ID "+id+" exist.");
        }
    }

    @Override
    public CustomerContact saveCustomer(CustomerContact customer) {
        return repo.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException ex){
            throw new CustomerException("No Customer with ID "+id+" exist.");
        }
    }

    @Override
    public List<CustomerContact> getAll() {
        return repo.findAll();
    }
}
