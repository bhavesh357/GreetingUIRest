package com.web.customer.controller;

import com.web.customer.dto.CustomerDto;
import com.web.customer.model.Customer;
import com.web.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
