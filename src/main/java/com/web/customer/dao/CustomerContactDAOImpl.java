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
    public CustomerContact saveCustomer(CustomerContact customer) {
        return repo.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<CustomerContact> getAll() {
        return repo.findAll();
    }
}
