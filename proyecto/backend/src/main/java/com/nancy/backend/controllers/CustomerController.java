package com.nancy.backend.controllers;

import com.nancy.backend.documents.Customer;
import com.nancy.backend.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/customers")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;   
    
    @GetMapping
    public Iterable<Customer> findAll() {
        return customerService.findAll();
    }

}
