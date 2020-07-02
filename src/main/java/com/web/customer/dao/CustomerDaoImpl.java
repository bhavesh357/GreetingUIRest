package com.web.customer.dao;

import com.web.customer.model.Customer;
import com.web.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    CustomerRepository repository;

    @Override
    public Customer getCustomerById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return repository.save(customer);
    }
}
