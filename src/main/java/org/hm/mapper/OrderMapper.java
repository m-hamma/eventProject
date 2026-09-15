package org.hm.mapper;

import org.hm.dto.OrderDto;
import org.hm.entities.OrderEntity;
import org.hm.mapper.OrderItemMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = OrderItemMapper.class
)
public interface OrderMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    OrderEntity toEntity(OrderDto dto);

    OrderDto toDto(OrderEntity entity);
}