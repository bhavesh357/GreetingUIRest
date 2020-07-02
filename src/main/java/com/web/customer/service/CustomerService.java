package com.web.customer.service;

import com.web.customer.dao.CustomerDaoImpl;
import com.web.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerDaoImpl customerDao;


    public Customer getCustomer(int id) {
        return customerDao.getCustomerById(id);
    }
}
