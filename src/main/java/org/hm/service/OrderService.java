package org.hm.service;
import org.hm.dto.Order;
import org.hm.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
@Service
public class OrderService {

    private static final Logger log =
            LoggerFactory.getLogger(OrderService.class);

    private final ApplicationEventPublisher publisher;

    public OrderService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void createOrder(Order order) {

        log.info("=== Début OrderService ===");

        log.info(
                "Création de la commande {} pour le client {}",
                order.getId(),
                order.getCustomer()
        );

        log.info(
                "Publication de OrderCreatedEvent pour la commande {}",
                order.getId()
        );

        publisher.publishEvent(
                new OrderCreatedEvent(
                        order.getId(),
                        order.getCustomer()
                )
        );

        log.info("=== Fin OrderService ===");
    }
}