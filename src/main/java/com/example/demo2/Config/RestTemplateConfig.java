package com.example.demo2.Config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate() {
    return new RestTemplateBuilder().build();
    }
}
