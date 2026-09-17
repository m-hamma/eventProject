package org.hm.event;

import java.util.List;

public record OrderItemEvent(
        long orderId,
        Long productId

) {
}