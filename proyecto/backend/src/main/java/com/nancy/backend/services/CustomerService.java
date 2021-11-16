package com.nancy.backend.services;

import com.nancy.backend.documents.Customer;
import com.nancy.backend.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

}
