package org.hm.mapper;

import org.hm.dto.OrderItemDto;
import org.hm.entities.OrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemDto toDto(OrderItemEntity entity);

    @Mapping(target = "order", ignore = true)
    OrderItemEntity toEntity(OrderItemDto dto);
}