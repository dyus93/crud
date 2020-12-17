package com.example.product.service;

import com.example.product.dto.ProductDto;
import com.example.product.persistence.entity.Product;
import com.example.product.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> getOneById(Long id){
        return productRepository.findById(id);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public void save(ProductDto productDto){
        Product product = Product.builder()
                .added(new Date())
                .title(productDto.getTitle())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .build();

        productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
