package com.app.gubee_products.products.application.repositories;

import com.app.gubee_products.products.domain.entities.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
