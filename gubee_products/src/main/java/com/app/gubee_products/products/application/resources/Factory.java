package com.app.gubee_products.products.application.resources;

import com.app.gubee_products.products.application.repositories.ProductRepository;
import com.app.gubee_products.products.db.DB;

public class Factory {

    public static ProductRepository makeConnection(){
        return new ProductResource(DB.getConnection());
    }
}
