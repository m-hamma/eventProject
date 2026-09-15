package org.hm.mapper;

import org.hm.dto.ProductDto;
import org.hm.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto toDto(ProductEntity entity) {

        return new ProductDto(
                entity.getId(),
                entity.getCode(),
                entity.getLibelle(),
                entity.getPrix()
        );
    }

    public ProductEntity toEntity(ProductDto dto) {

        return ProductEntity.builder()
                .id(dto.id())
                .code(dto.code())
                .libelle(dto.libelle())
                .prix(dto.prix())
                .build();
    }
}