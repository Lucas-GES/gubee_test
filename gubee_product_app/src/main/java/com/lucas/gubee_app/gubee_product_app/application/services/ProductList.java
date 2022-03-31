package com.lucas.gubee_app.gubee_product_app.application.services;


import com.lucas.gubee_app.gubee_product_app.application.repositories.ProductRepository;
import com.lucas.gubee_app.gubee_product_app.domain.entities.Product;

import java.util.List;

public class ProductList {
    private ProductRepository repository;

    public List<Product> findAll(){
        return  repository.findAll();
    }
}
