package com.web.customer.controller;

import com.web.customer.dto.CustomerDto;
import com.web.customer.model.Customer;
import com.web.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id){
        return service.getCustomer(id);
    }

    @GetMapping
    public List<Customer> getCustomer(){
        return service.getAll();
    }

    @PostMapping
    public Customer addCustomer(@RequestBody CustomerDto customerDto){
        return service.addCustomer(customerDto);
    }

    @PutMapping
    public Customer modifyCustomer(@RequestBody CustomerDto customerDto,@RequestParam int id){
        return service.modifyCustomer(customerDto,id);
    }

    @DeleteMapping
    public void deleteCustomer(@RequestParam int id){
        service.deleteCustomer(id);
    }

}
