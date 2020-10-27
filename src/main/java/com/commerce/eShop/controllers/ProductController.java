package com.commerce.eShop.controllers;


import com.commerce.eShop.model.Product;
import com.commerce.eShop.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getProducts() throws JsonProcessingException {
        List<Product> productList = productService.listAllProducts();

        return new ObjectMapper().writeValueAsString(productList);
    }

    @PostMapping("/product")
    public String createProduct(@RequestBody String body) throws JsonProcessingException {
        Product product = new ObjectMapper().readValue(body, Product.class);

        Product returnProduct = productService.createProduct(product);

        return new ObjectMapper().writeValueAsString(returnProduct);
    }
}
