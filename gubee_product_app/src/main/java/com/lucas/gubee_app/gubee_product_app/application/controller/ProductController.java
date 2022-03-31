package com.lucas.gubee_app.gubee_product_app.application.controller;

import com.lucas.gubee_app.gubee_product_app.application.services.ProductList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
public class ProductController {

    private ProductList productList;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        return Response.ok(productList.findAll()).build();
    }

}
