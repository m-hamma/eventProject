package org.hm.service;
import org.hm.dto.Order;
import org.hm.event.OrderCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ApplicationEventPublisher publisher;

    public OrderService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void createOrder(Order order) {

        publisher.publishEvent(
                new OrderCreatedEvent(
                        order.getId(),
                        order.getCustomer()
                )
        );
    }
}