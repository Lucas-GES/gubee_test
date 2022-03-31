package com.lucas.gubee_app.gubee_product_app.application.resources;

import com.lucas.gubee_app.gubee_product_app.application.repositories.ProductRepository;
import com.lucas.gubee_app.gubee_product_app.db.DB;

public class Factory {

    public static ProductRepository makeConnection(){
        return new ProductResource(DB.getConnection());
    }
}
