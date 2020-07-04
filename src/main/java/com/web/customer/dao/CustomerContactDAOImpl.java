package com.web.customer.dao;

import com.web.customer.model.Customer;
import com.web.customer.model.CustomerContact;
import com.web.customer.model.CustomerDetails;
import com.web.customer.repository.CustomerContactRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerContactDAOImpl implements CustomerContactDao{

    @Autowired
    private CustomerContactRepositories repo;

    @Override
    public CustomerContact getCustomerById(int id) {
        return repo.findById(id).get();
    }

    @Override
    public CustomerDetails saveCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(int id) {

    }

    @Override
    public List<CustomerDetails> getAll() {
        return null;
    }
}
