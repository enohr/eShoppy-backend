package com.commerce.eShop.controllers;


import com.commerce.eShop.model.Product;
import com.commerce.eShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getProducts() {
        List<Product> productList = productService.listAllProducts();
        System.out.println(productList);
        return "Teste";
    }

    @PostMapping("/product")
    public void createProduct() {
        Product p1 = new Product(1, "Teste", "Product 1", new BigDecimal(1.99), "skuid123123");

        productService.createProduct(p1);
    }
}
