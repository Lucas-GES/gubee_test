package com.lucas.gubee_app.gubee_product_app.application.repositories;
import com.lucas.gubee_app.gubee_product_app.domain.entities.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
