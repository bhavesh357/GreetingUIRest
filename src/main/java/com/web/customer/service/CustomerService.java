package com.web.customer.service;

import com.web.customer.dao.CustomerDaoImpl;
import com.web.customer.dto.CustomerDto;
import com.web.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerDaoImpl customerDao;


    public Customer getCustomer(int id) {
        return customerDao.getCustomerById(id);
    }

    public Customer addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        return customerDao.saveCustomer(customer);
    }

    public Customer modifyCustomer(CustomerDto customerDto, int id) {
        Customer customer = customerDao.getCustomerById(id);
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        return customerDao.saveCustomer(customer);
    }

    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }

    public List<Customer> getAll() {
        return customerDao.getAll();
    }
}
