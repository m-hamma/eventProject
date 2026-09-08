package org.hm.service;

import org.hm.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @EventListener
    public void handle(OrderCreatedEvent event) {
        System.out.println(
                "Email envoyé au client "
                        + event.customer()
        );
    }
}