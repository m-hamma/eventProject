package org.hm.dto;

import org.hm.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(
        Long id,
        String libelle,
        String customer,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        OrderStatus status,
        List<OrderItemDto> items
) {
}