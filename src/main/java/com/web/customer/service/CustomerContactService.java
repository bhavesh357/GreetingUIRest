package com.web.customer.service;


import com.web.customer.dao.CustomerContactDAOImpl;
import com.web.customer.dao.CustomerDaoImpl;
import com.web.customer.model.Customer;
import com.web.customer.model.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerContactService {

    @Autowired
    CustomerContactDAOImpl customerContactDao;
    CustomerDaoImpl customerDao;

    public CustomerDetails getCustomer(int id) {
        CustomerDetails customerDetails = new CustomerDetails();
        Customer customer = this.customerDao.getCustomerById(id);
        CustomerDetails customerContact = customerContactDao.getCustomerById(id);
        customerDetails.setId(customer.getId());
        customerDetails.setFirstName(customer.getFirstName());
        customerDetails.setLastName(customer.getLastName());
        customerDetails.setAddress(customerContact.getAddress());
        customerDetails.setNumber(customerContact.getNumber());
        return customerDetails;
    }
}
