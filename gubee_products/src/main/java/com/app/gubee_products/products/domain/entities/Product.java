package com.app.gubee_products.products.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Product {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String productDescription;

    @Column
    private Market market;

    @Column
    private List<Technology> technology;

    public Product() {
    }

    public Product(Integer id, String name, String productDescription, Market market, List<Technology> technology) {
        this.id = id;
        this.name = name;
        this.productDescription = productDescription;
        this.market = market;
        this.insertTechnology(technology);
    }

    public void insertTechnology(List<Technology> technology){
        for(Technology t : technology){
            this.technology.add(t);
        }
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public List<Technology> getTechnology() {
        return technology;
    }
}
