package com.commerce.eShop.services;

import com.commerce.eShop.model.Product;
import com.commerce.eShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Transactional()
    public List<Product> listAllProducts() {
        return productRepo.findAll();
    }

    public Product createProduct(Product product) {
        System.out.println(product.toString());
        return productRepo.save(product);
    }

}