package com.nancy.backend.documents;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product implements Serializable {

    @Id
    private Long id;
    private String name;
    private String brand;
    private LocalDate expiration;
    private Float price;
    private Float taxes;
    
    public Product() {

    }

    public Product(Long id, String name, String brand, LocalDate expiration, Float price, Float taxes) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.expiration = expiration;
        this.price = price;
        this.taxes = taxes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTaxes() {
        return taxes;
    }

    public void setTaxes(Float taxes) {
        this.taxes = taxes;
    }

}
