package org.hm.mapper;

import org.hm.dto.ClientDto;
import org.hm.dto.ProductDto;
import org.hm.entities.ClientEntity;
import org.hm.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDto toDto(ClientEntity entity) {

        return new ClientDto(
                entity.getId(),
                entity.getCode(),
                entity.getNom(),
                entity.getEmail(), entity.getTelephone()
        );
    }

    public ClientEntity toEntity(ClientDto dto) {

        return ClientEntity.builder()
                .id(dto.id())
                .code(dto.code())
                .nom(dto.nom())
                .email(dto.email())
                .telephone(dto.telephone())
                .build();
    }
}