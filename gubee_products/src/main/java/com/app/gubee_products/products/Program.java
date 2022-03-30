package com.app.gubee_products.products;

import com.app.gubee_products.products.application.repositories.ProductRepository;
import com.app.gubee_products.products.application.resources.Factory;
import com.app.gubee_products.products.application.resources.ProductResource;
import com.app.gubee_products.products.application.services.ProductList;
import com.app.gubee_products.products.domain.entities.Product;

import java.util.List;

public class Program {

    public static void main(String[] args) {
        ProductRepository productRepository = Factory.makeConnection();
        System.out.println("=== TEST 3: seller findAll ===");
        List<Product> list = productRepository.findAll();
        for(Product obj: list){
            System.out.println(obj + "\n");
        }
    }
}
