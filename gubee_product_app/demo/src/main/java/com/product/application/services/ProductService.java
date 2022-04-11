package com.product.application.services;

import com.product.entities.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductService {

    public List<Product> instantiateProduct(ResultSet rs) throws SQLException {
        List<Product> products = new ArrayList<>();
        while(rs.next()) {
            Product product = new Product(
                    rs.getInt("product.id"),
                    rs.getString("product.name"),
                    rs.getString("product.description"),
                    rs.getString("market.name"),
                    Collections.singletonList(rs.getString("technologies.name")));
            products.add(product);
        }
        return products;
    }

    private List<Product> getDistinctProducts(List<Product> products){
        for(int i=0; i< products.size(); i++){
            for(int j=i+1; j<products.size(); j++){
                if(products.get(i).getId().equals(products.get(j).getId())){
                    products.get(i).insertTechByTech(products.get(j).getTechnology());
                    products.remove(j);
                    j--;
                }
            }
        }
        return products;
    }

}
