package com.example.demo2.dtos;

import lombok.Getter;
import lombok.Setter;

public class FakeStoreProductServiceDtos {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private double price;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String image;
    @Getter
    @Setter
    private String category;
}
