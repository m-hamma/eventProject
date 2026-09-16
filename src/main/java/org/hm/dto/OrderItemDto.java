package org.hm.dto;

import java.math.BigDecimal;

public record OrderItemDto(
        Long id,
        ProductDto product,
        Integer quantity,
        BigDecimal unitPrice
) {
}