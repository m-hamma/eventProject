package org.hm.dto;

public record InvoiceDto(
        Long id,
        Long orderId,
        String invoiceNumber
) {
}