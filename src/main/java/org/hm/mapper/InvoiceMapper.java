package org.hm.mapper;

import org.hm.dto.InvoiceDto;
import org.hm.entities.InvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "order", ignore = true)
    InvoiceEntity toEntity(InvoiceDto invoice);

    @Mapping(target = "orderId", source = "order.id")
    InvoiceDto toDto(InvoiceEntity entity);
}