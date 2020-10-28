package com.commerce.eShop.controllers;


import com.commerce.eShop.model.Product;
import com.commerce.eShop.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getProducts() throws JsonProcessingException {
        List<Product> productList = productService.listAllProducts();

        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(productList), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody String body) throws JsonProcessingException {
        Product product;
        try {
            product = new ObjectMapper().readValue(body, Product.class);

            Product returnProduct = productService.createProduct(product);

            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(returnProduct), HttpStatus.CREATED);
        } catch (UnrecognizedPropertyException e) {
            String errorMsg = "unexpected field: " + e.getPropertyName();
            e.printStackTrace();
            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(errorMsg), HttpStatus.FORBIDDEN);
        }

    }
}
