package com.nancy.backend.repositories;

import com.nancy.backend.documents.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {
    
}
