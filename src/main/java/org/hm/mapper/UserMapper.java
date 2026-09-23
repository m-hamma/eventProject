package org.hm.mapper;

import org.hm.dto.UserDto;
import org.hm.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", source = "role.code")
    UserDto toDto(UserEntity entity);
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    UserEntity toEntity(UserDto dto);
}