package com.web.customer.dao;

import com.web.customer.model.Customer;

public interface CustomerDao {
    Customer getCustomerById(int id);

    Customer addCustomer(Customer customer);
}
