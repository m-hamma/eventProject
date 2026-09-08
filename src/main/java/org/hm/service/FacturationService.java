package org.hm.service;
import org.hm.event.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FacturationService {

    @KafkaListener(topics = "orders")
    public void consume(OrderCreatedEvent event) {

        System.out.println(
                "Facture créée pour la commande : "
                        + event.orderId()
        );
    }
}