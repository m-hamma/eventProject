package org.hm.event;

public record OrderCreatedEvent(
    Long orderId,
    String clientName
) {}