package com.web.customer.controller;

import com.web.customer.dto.CustomerDto;
import com.web.customer.model.Customer;
import com.web.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping
    public Customer getCustomer(@RequestParam int id){
        return service.getCustomer(id);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody CustomerDto customerDto){
        return service.addCustomer(customerDto);
    }
}
