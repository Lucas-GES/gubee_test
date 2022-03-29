package com.app.gubee_products.products.domain.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Technology {

    @Id
    private Integer id;

    @Column
    private String name;

    public Technology() {
    }

    public Technology(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
