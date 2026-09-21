package org.hm.mapper;

import org.hm.dto.UserDto;
import org.hm.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public UserDto toDto(UserEntity entity) {

        if (entity == null) {
            return null;
        }

        return UserDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .role(entity.getRole().getCode())
                .enabled(entity.getEnabled())
                .build();
    }
    public List<UserDto> toDtoList(List<UserEntity> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }
}