package com.example.demo2.Controllers;


import com.example.demo2.Model.Product;
import com.example.demo2.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping ("/{id}")
    Product getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id);
   }
   @GetMapping("")
   List<Product> getAllProducts() {
        return  productService.getAllProducts();
   }
//    @GetMapping("/{name}")
//    public String sayHello(@PathVariable String name) {
//        return "Hello "+name+"!";
//    }
}

