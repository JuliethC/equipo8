package com.nancy.backend.repositories;

import com.nancy.backend.documents.Sequece;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequeceRepository extends MongoRepository<Sequece, String> {
    
}
