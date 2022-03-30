package com.app.gubee_products.products.application.services;

import com.app.gubee_products.products.application.repositories.ProductRepository;
import com.app.gubee_products.products.domain.entities.Product;

import java.util.List;

public class ProductList {
    private ProductRepository repository;

    public List<Product> findAll(){
        return  repository.findAll();
    }
}
