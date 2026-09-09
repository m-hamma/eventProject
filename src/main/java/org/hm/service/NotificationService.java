package org.hm.service;

import org.hm.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
@Service
public class NotificationService {

    private static final Logger log =
            LoggerFactory.getLogger(NotificationService.class);

    @EventListener
    public void handle(OrderCreatedEvent event) {

        log.info("=== Début NotificationService ===");

        log.info(
                "Email envoyé au client {} pour la commande {}",
                event.customer(),
                event.orderId()
        );

        log.info("=== Fin NotificationService ===");
    }
}