package com.example.TestApi.controller;

import com.example.TestApi.dto.ProductDto;
import com.example.TestApi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable int id) {
        return service.getProduct(id);
    }

    @GetMapping
    public List<ProductDto> getAllProduct() {
        return service.getAllProduct();
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDto dto){
        service.add(dto);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDto dto){
        service.update(dto);
    }

    @DeleteMapping("/id")
    public void deleteProduct(@PathVariable int id){
        service.delete(id);
    }
}