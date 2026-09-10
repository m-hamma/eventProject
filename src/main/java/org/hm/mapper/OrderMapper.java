package org.hm.mapper;

import org.hm.dto.Order;
import org.hm.entities.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    OrderEntity toEntity(Order order);
    Order toDto(OrderEntity entity);
}
