package com.nancy.backend.documents;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Sequece implements Serializable {
    
    @Id
    String id;
    Long value;

    public Sequece(){

    }

    public Sequece(String id, Long value){
        this.id = id;
        this.value = value;
    }    

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public Long getValue() {
        return value;
    }
    
    public void setValue(Long value) {
        this.value = value;
    }

}
