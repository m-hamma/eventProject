package org.hm.dto;

import java.math.BigDecimal;

public record OrderItemDto(
        Long id,
        Long productId,
        String productCode,
        Integer quantity,
        BigDecimal unitPrice
) {
}