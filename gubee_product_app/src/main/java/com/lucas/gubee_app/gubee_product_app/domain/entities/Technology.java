package com.lucas.gubee_app.gubee_product_app.domain.entities;



public class Technology {

    private Integer id;

    private String name;

    public Technology() {
    }

    public Technology(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
