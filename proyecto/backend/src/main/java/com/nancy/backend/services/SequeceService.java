package com.nancy.backend.services;

import java.util.Optional;

import com.nancy.backend.documents.Sequece;
import com.nancy.backend.repositories.SequeceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequeceService {

    @Autowired
    private SequeceRepository sequeceRepository;

    public Long next(String id) {
        Sequece sequece;
        Optional<Sequece> optionalSequece = sequeceRepository.findById(id);
        if (optionalSequece.isPresent()) {
            sequece = optionalSequece.get();
            sequece.setValue(sequece.getValue() + 1);
        } else {
            sequece = new Sequece(id, 1L);
        } 
        sequeceRepository.save(sequece);
        return sequece.getValue(); 
    }
    
}
