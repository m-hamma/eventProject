package org.hm.service;

import org.hm.event.InvoiceCreatedEvent;
import org.hm.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
@Service
public class FacturationService {
    private static final Logger log =
            LoggerFactory.getLogger(FacturationService.class);

    private final ApplicationEventPublisher publisher;

    public FacturationService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @EventListener
    public void consume(OrderCreatedEvent event) {

        log.info("=== Début FacturationService ===");

        log.info(
                "Facture créée pour la commande {}",
                event.orderId()
        );

        publisher.publishEvent(
                new InvoiceCreatedEvent(
                        event.orderId()
                )
        );

        log.info(
                "Publication de InvoiceCreatedEvent pour la commande {}",
                event.orderId()
        );

        log.info("=== Fin FacturationService ===");
    }
}