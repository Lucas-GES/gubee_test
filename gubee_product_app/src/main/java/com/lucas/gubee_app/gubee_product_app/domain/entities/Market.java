package com.lucas.gubee_app.gubee_product_app.domain.entities;


public class Market {

    private Integer id;

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
