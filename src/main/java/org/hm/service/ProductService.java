package org.hm.service;

import jakarta.annotation.PostConstruct;
import org.hm.entities.ProductEntity;
import org.hm.mapper.ProductMapper;
import org.hm.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.hm.dto.ProductDto;

import java.util.function.Function;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private final ProductRepository repository;
    private Map<Long, ProductEntity> productsCache;
    private final ProductMapper productMapper;

    public ProductService(
            ProductRepository repository,
            ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }

    @PostConstruct
    public void init() {

        productsCache = repository.findAll()
                .stream()
                .collect(Collectors.toMap(
                        ProductEntity::getId,
                        Function.identity()
                ));
    }


    public List<ProductDto> findAll() {
        return productsCache.values()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    public ProductDto findById(Long id) {

        ProductEntity product = productsCache.get(id);

        if (product == null) {
            throw new IllegalArgumentException(
                    "Produit introuvable : " + id);
        }

        return productMapper.toDto(product);
    }
}