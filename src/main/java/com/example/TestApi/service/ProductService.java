package com.example.TestApi.service;


import com.example.TestApi.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void delete(int id);
    void update(ProductDto dto);
    void add(ProductDto dto);
    ProductDto getProduct(int id);
    List<ProductDto> getAllProduct();
}
