package com.web.customer.controller;

import com.web.customer.dto.CustomerDto;
import com.web.customer.model.Customer;
import com.web.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Customer addCustomer(@Valid @RequestBody CustomerDto customerDto){
        return service.addCustomer(customerDto);
    }

    @PutMapping("/{id}")
    public Customer modifyCustomer(@Valid @RequestBody CustomerDto customerDto, @PathVariable int id){
        return service.modifyCustomer(customerDto,id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id){
        service.deleteCustomer(id);
    }


}
