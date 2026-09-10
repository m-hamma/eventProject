package org.hm.dto;

public record Invoice(
        Long id,
        Long orderId,
        String invoiceNumber
) {
}