package com.lucas.gubee_app.gubee_product_app.application.services;


import com.lucas.gubee_app.gubee_product_app.application.repositories.ProductRepository;
import com.lucas.gubee_app.gubee_product_app.application.resources.ProductResource;
import com.lucas.gubee_app.gubee_product_app.db.DB;
import com.lucas.gubee_app.gubee_product_app.domain.entities.Product;

import java.util.List;

public class ProductList {

    public static ProductRepository createProduct(){

        return new ProductResource(DB.getConnection());

    }

}
