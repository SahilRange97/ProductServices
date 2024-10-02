package com.example.demo2.services;

import com.example.demo2.Model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id);
    List<Product> getAllProducts();
}
