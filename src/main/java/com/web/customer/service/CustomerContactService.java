package com.web.customer.service;


import com.web.customer.dao.CustomerContactDAOImpl;
import com.web.customer.dao.CustomerDaoImpl;
import com.web.customer.dto.CustomerDetailsDto;
import com.web.customer.model.Customer;
import com.web.customer.model.CustomerContact;
import com.web.customer.model.CustomerDetails;
import com.web.customer.util.CustomerTime;
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

    public CustomerDetails addCustomer(CustomerDetailsDto customerDetailsDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDetailsDto.getFirstName());
        customer.setLastName(customerDetailsDto.getLastName());
        String timeStamp = CustomerTime.getTimeStamp();
        customer.setRegisteredTime(timeStamp);
        customer.setModifiedTime(timeStamp);
        customer = customerDao.saveCustomer(customer);
        CustomerContact customerContact = new CustomerContact();
        customerContact.setId(customer.getId());
        customerContact.setAddress(customerDetailsDto.getAddress());
        customerContact.setNumber(customerDetailsDto.getNumber());
        customerContactDao.saveCustomer(customerContact);
        return getCustomer(customer.getId());
    }
}
