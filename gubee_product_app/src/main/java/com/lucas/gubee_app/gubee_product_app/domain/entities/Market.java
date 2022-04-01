package com.lucas.gubee_app.gubee_product_app.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Market {

    @Id
    private Integer id;

    @Column
    private String name;

    public Market() {
    }

    public Market(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
