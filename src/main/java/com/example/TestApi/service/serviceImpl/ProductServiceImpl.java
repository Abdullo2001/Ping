package com.example.TestApi.service.serviceImpl;

import com.example.TestApi.repository.ProductRepository;
import com.example.TestApi.dto.ProductDto;
import com.example.TestApi.entity.ProductEntity;
import com.example.TestApi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public void delete(int id) {
        Optional<ProductEntity> entity=repository.findById(id);
        repository.delete(entity.get());
    }

    @Override
    public void update(ProductDto dto) {
        Optional<ProductEntity> entity=repository.findById(dto.productId);
        entity.get().setProductName(dto.productName);
        entity.get().setProductPrice(dto.productPrice);
        entity.get().setProductSize(dto.productSize);
        repository.save(entity.get());
    }

    @Override
    public void add(ProductDto dto) {
        ProductEntity entity=new ProductEntity();
        entity.setProductName(dto.productName);
        entity.setProductPrice(dto.productPrice);
        entity.setProductSize(dto.productSize);
        repository.save(entity);
    }

    @Override
    public ProductDto getProduct(int id) {
        Optional<ProductEntity> entity=repository.findById(id);
        ProductDto dto=new ProductDto();
        dto.setProductName(entity.get().productName);
        dto.setProductPrice(entity.get().productPrice);
        dto.setProductSize(entity.get().productSize);
        return dto;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<ProductEntity> entities=repository.findAll();
        List<ProductDto> dtos=new ArrayList<>();

        for (ProductEntity entity: entities){
            ProductDto dto=new ProductDto();
            dto.setProductName(entity.productName);
            dto.setProductPrice(entity.productPrice);
            dto.setProductSize(entity.productSize);
            dto.setProductId(entity.productId);

            dtos.add(dto);
        }
        return dtos;
    }
}
