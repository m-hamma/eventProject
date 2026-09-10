package org.hm.service;

import org.hm.entities.InvoiceEntity;
import org.hm.entities.OrderEntity;
import org.hm.event.InvoiceCreatedEvent;
import org.hm.event.OrderCreatedEvent;
import org.hm.mapper.InvoiceMapper;
import org.hm.repositories.InvoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FacturationService {
    private static final Logger log =
            LoggerFactory.getLogger(FacturationService.class);

    private final ApplicationEventPublisher publisher;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public FacturationService(ApplicationEventPublisher publisher, InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.publisher = publisher;
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @EventListener
    public void consume(OrderCreatedEvent event) {

        log.info("=== Début FacturationService ===");

        log.info(
                "Création de la facture pour la commande {}",
                event.orderId()
        );

        String factureNumber =
                "FAC-" + event.orderId();

        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setInvoiceNumber(factureNumber);
        invoiceEntity.setCreatedAt(LocalDateTime.now());

        OrderEntity order = new OrderEntity();
        order.setId(event.orderId());

        invoiceEntity.setOrder(order);

        invoiceRepository.save(invoiceEntity);

        log.info(
                "Facture {} enregistrée",
                factureNumber
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