package com.web.customer.dao;

import com.web.customer.dto.CustomerDto;
import com.web.customer.model.Customer;

import java.util.List;

public interface CustomerDao {
    Customer getCustomerById(int id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(int id);

    List<Customer> getAll();
}
