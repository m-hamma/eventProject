package org.hm.event;

public record OrderUpdatedEvent(
        Long orderId,
        String customer
) {}