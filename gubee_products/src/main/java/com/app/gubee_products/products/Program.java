package com.app.gubee_products.products;

import com.app.gubee_products.products.application.repositories.ProductRepository;
import com.app.gubee_products.products.application.resources.Factory;
import com.app.gubee_products.products.domain.entities.Product;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.ws.rs.core.Application;

import java.util.List;

public class Program {

    public static void main(String[] args) {
//        ProductRepository productRepository = Factory.makeConnection();
//        List<Product> list = productRepository.findAll();
//        for(Product obj: list){
//            System.out.println(obj.getId() + "\n");
//            System.out.println(obj.getName() + "\n");
//            System.out.println(obj.getProductDescription() + "\n");
//            System.out.println(obj.getMarket().getName() + "\n");
//            System.out.println(obj.getTechnology().get(0).getName() + "\n");
//        }

    }
}
