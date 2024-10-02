package com.example.demo2.services;

import com.example.demo2.Model.Category;
import com.example.demo2.Model.Product;
import com.example.demo2.dtos.FakeStoreProductServiceDtos;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    private  Product convertFakeProductDtoToProduct(FakeStoreProductServiceDtos dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());

        Category category = new Category();
        category.setTitle(dto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product getProductById(long id) {
        FakeStoreProductServiceDtos fakeStoreProductServiceDtos =
        restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductServiceDtos.class);
        if(fakeStoreProductServiceDtos == null){
            return null;
        }

        return convertFakeProductDtoToProduct(fakeStoreProductServiceDtos);
    }

    @Override
    public List<Product> getAllProducts() {
//         List<FakeStoreProductServiceDtos> fakeStoreProductServiceDtos =
//                 restTemplate.getForObject("https://fakestoreapi.com/products",List<FakeStoreProductServiceDtos>.class);
        FakeStoreProductServiceDtos [] fakeStoreProductServiceDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductServiceDtos[].class);
         if(fakeStoreProductServiceDtos == null){
             return null;
         }
        List<Product>response = new ArrayList<Product>();
        for (FakeStoreProductServiceDtos dto : fakeStoreProductServiceDtos) {
            response.add(convertFakeProductDtoToProduct(dto));
        }
        return response;
    }
}
