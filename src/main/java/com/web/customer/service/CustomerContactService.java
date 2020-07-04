package com.web.customer.service;


import com.web.customer.dao.CustomerContactDAOImpl;
import com.web.customer.dao.CustomerDaoImpl;
import com.web.customer.model.Customer;
import com.web.customer.model.CustomerContact;
import com.web.customer.model.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerContactService {

    @Autowired
    CustomerContactDAOImpl customerContactDao;
    CustomerDaoImpl customerDao;

    public CustomerDetails getCustomer(int id) {
        Customer customer = this.customerDao.getCustomerById(id);
        CustomerContact customerContact = customerContactDao.getCustomerById(id);
        return merge(customer,customerContact);
    }

    public List<CustomerDetails> getAll() {
        List<CustomerDetails> customerDetails = new ArrayList<>();
        List<Customer> customers = customerDao.getAll();
        List<CustomerContact> contacts = customerContactDao.getAll();
        for(Customer c: customers){
            customerDetails.add(merge(c,contacts.stream().
                    filter(contact -> contact.getId()==c.getId()).
                    findFirst().get()));
        }
        return customerDetails;
    }

    private CustomerDetails merge(Customer customer, CustomerContact customerContact) {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setId(customer.getId());
        customerDetails.setFirstName(customer.getFirstName());
        customerDetails.setLastName(customer.getLastName());
        customerDetails.setAddress(customerContact.getAddress());
        customerDetails.setNumber(customerContact.getNumber());
        return customerDetails;
    }
}
