package com.example.userservice1.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {


    private RestTemplate restTemplate;
    public ProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    public String getProductDetails(String id){
        return restTemplate.getForObject("http://PRODUCTSERVICE1/Products/" + id, String.class);
    }
}
