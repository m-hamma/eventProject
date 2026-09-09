package org.hm.event;

public record InvoiceCreatedEvent(
        Long orderId
) {
}