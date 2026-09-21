package org.hm.mapper;

import org.hm.dto.RoleDto;
import org.hm.entities.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleMapper {

    public RoleDto toDto(RoleEntity entity) {

        if (entity == null) {
            return null;
        }

        return RoleDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .libelle(entity.getLibelle())
                .build();
    }

    public List<RoleDto> toDtoList(List<RoleEntity> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }
}