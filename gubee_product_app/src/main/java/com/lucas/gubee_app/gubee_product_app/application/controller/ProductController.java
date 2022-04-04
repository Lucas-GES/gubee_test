package com.lucas.gubee_app.gubee_product_app.application.controller;

import com.lucas.gubee_app.gubee_product_app.application.repositories.ProductRepository;
import com.lucas.gubee_app.gubee_product_app.application.services.ProductList;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/product")
public class ProductController {

    private ProductRepository productRepository = ProductList.createProduct();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        return Response.ok(productRepository.findAll()).build();
    }

}
