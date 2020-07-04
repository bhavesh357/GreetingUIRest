package com.web.customer.dao;

import com.web.customer.model.Customer;
import com.web.customer.model.CustomerContact;
import com.web.customer.model.CustomerDetails;

import java.util.List;

public interface CustomerContactDao {
    CustomerContact getCustomerById(int id);

    CustomerContact saveCustomer(CustomerContact customer);

    void deleteCustomer(int id);

    List<CustomerContact> getAll();
}
