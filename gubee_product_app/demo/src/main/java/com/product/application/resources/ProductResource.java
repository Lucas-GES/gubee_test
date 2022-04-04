package com.product.application.resources;


import com.product.application.repositories.ProductRepository;
import com.product.db.DbException;
import com.product.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProductResource implements ProductRepository {

    private Connection conn;

    public ProductResource(Connection conn){this.conn = conn;}

    private Product instantiateProduct(ResultSet rs) throws SQLException {
        Product product = new Product(
        rs.getInt("id"),
        rs.getString("name"),
        rs.getString("description"),
        rs.getString("market.name"),
        Collections.singletonList(rs.getString("technologies.name")));
        return product;
    }

    @Override
    public List<Product> findAll() {
        String query = "SELECT product.id,product.name, product.description, market.name, technologies.name "
                + "FROM product "
                + "join market on product.marketId = market.id "
                + "join technologies on product.techId = technologies.id";
        try(PreparedStatement st = conn.prepareStatement(query)){
            try(ResultSet rs = st.executeQuery()){
                List<Product> list = new ArrayList<>();
                Map<Integer, Product> map = new HashMap<>();

                while (rs.next()){
                    Product product;
                    product = instantiateProduct(rs);
                    list.add(product);
                }
                return list;
            }
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }
}
