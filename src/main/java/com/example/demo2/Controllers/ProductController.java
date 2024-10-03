package com.example.demo2.Controllers;


import com.example.demo2.Model.Product;
import com.example.demo2.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping ("/{id}")
   public Product getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id);
   }
   @GetMapping("")
   public List<Product> getAllProducts() {
        return  productService.getAllProducts();
   }

   @PutMapping("/{id}")
   public Product replaceProductById(@PathVariable long id , @RequestBody Product product) {
        return productService.replaceProductById(id, product);
   }
//    @GetMapping("/{name}")
//    public String sayHello(@PathVariable String name) {
//        return "Hello "+name+"!";
//    }
}

