package com.nancy.backend.services;

import java.util.List;

import com.nancy.backend.documents.Product;
import com.nancy.backend.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    SequeceService sequeceService;
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(sequeceService.next("product"));
        }
        return productRepository.save(product);
    }
    

}
