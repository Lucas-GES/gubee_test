package com.product;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import javax.json.Json;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ProductControllerTest {

    @Test
    public void testProductEndpoint() {

        given()
                .when().get("/api/product")
                .then()
                .statusCode(200);
    }

}
